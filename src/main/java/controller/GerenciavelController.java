package controller;

import interfaces.Gerenciavel;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.TarefaBase;
import model.TarefaPessoal;
import model.TarefaProfissional;
import view.Main;

public class GerenciavelController implements Gerenciavel {

    private Main main;
    private JTable jTable;

    public GerenciavelController(Main main) {
        this.main = main;
        this.jTable = main.getjTable();
    }

    public Main getMain() {
        return main;
    }

    @Override
    public void adicionar(TarefaBase tarefa) {
        if (tarefa instanceof TarefaProfissional) {
            addProfissional((TarefaProfissional) tarefa);
        } else if (tarefa instanceof TarefaPessoal) {
            addPessoal((TarefaPessoal) tarefa);
        }
    }

    private void addProfissional(TarefaProfissional tarefaProfissional) {
        String id = String.valueOf(tarefaProfissional.getId());
        String nome = tarefaProfissional.getNome();
        String categoria = tarefaProfissional.getCategoria();
        String prioridade = tarefaProfissional.getPrioridade();
        String status = tarefaProfissional.getStatus();
        String responsavel = tarefaProfissional.getResponsavel();
        String prazo = tarefaProfissional.getPrazoEntrega();

        String baseFilePath = "tarefas_base.csv";

        List<String[]> baseData = CSVFileController.readCSV(baseFilePath);

        // Verifica se o ID já existe
        for (String[] row : baseData) {
            if (row[0].equals(id)) {
                javax.swing.JOptionPane.showMessageDialog(main, "ID já existe! Não é possível adicionar a tarefa.", "Erro", javax.swing.JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

        // Adiciona a tarefa na base de dados
        String[] tarefaBase = {id, nome, categoria, prioridade, status};
        CSVFileController.addCSV(baseFilePath, tarefaBase);

        // Adiciona a tarefa profissional
        String[] tarefaProfissionalData = {id, responsavel, prazo};
        CSVFileController.addCSV("tarefas_profissionais.csv", tarefaProfissionalData);

        // Atualiza a tabela da interface
        main.updateTable();
    }

    private void addPessoal(TarefaPessoal tarefaPessoal) {
        String id = String.valueOf(tarefaPessoal.getId());
        String nome = tarefaPessoal.getNome();
        String categoria = tarefaPessoal.getCategoria();
        String prioridade = tarefaPessoal.getPrioridade();
        String status = tarefaPessoal.getStatus();
        String anotacoes = tarefaPessoal.getAnotacoes();
        String dataLembrete = tarefaPessoal.getDataLembrete();

        String baseFilePath = "tarefas_base.csv";

        List<String[]> baseData = CSVFileController.readCSV(baseFilePath);

        for (String[] row : baseData) {
            if (row[0].equals(id)) {
                javax.swing.JOptionPane.showMessageDialog(main, "ID já existe! Não é possível adicionar a tarefa.", "Erro", javax.swing.JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

        // Adiciona a tarefa na base de dados
        String[] tarefaBase = {id, nome, categoria, prioridade, status};
        CSVFileController.addCSV(baseFilePath, tarefaBase);

        // Adiciona a tarefa pessoal
        String[] tarefaPessoalData = {id, anotacoes, dataLembrete};
        CSVFileController.addCSV("tarefas_pessoais.csv", tarefaPessoalData);

        // Atualiza a tabela da interface
        main.updateTable();
    }

    @Override
    public void remover() {
        int selectedRow = jTable.getSelectedRow();

        if (selectedRow != -1) {
            DefaultTableModel model = (DefaultTableModel) jTable.getModel();
            String selectedId = model.getValueAt(selectedRow, 0).toString();

            String baseCsvFile = "tarefas_base.csv";
            List<String[]> baseData = CSVFileController.readCSV(baseCsvFile);

            baseData.removeIf(row -> row[0].equals(selectedId));
            CSVFileController.writeCSV(baseCsvFile, baseData);

            String categoria = model.getValueAt(selectedRow, 2).toString();

            if (categoria.equals("Profissional")) {
                String profCsvFile = "tarefas_profissionais.csv";
                List<String[]> profData = CSVFileController.readCSV(profCsvFile);
                profData.removeIf(row -> row[0].equals(selectedId));
                CSVFileController.writeCSV(profCsvFile, profData);
            } else if (categoria.equals("Pessoal")) {
                String pessoalCsvFile = "tarefas_pessoais.csv";
                List<String[]> pessoalData = CSVFileController.readCSV(pessoalCsvFile);
                pessoalData.removeIf(row -> row[0].equals(selectedId));
                CSVFileController.writeCSV(pessoalCsvFile, pessoalData);
            }

            main.updateTable();
        } else {
            javax.swing.JOptionPane.showMessageDialog(main, "Nenhuma linha selecionada!", "Erro", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }
}
