package controller;

import java.util.List;
import model.TarefaProfissional;
import model.TarefaPessoal;
import view.Main;

public class AddController {

    private Main main;

    public AddController(Main main) {
        this.main = main;
    }

    public Main getMain() {
        return main;
    }

    public void addProfissional(String id, String nome, String categoria, String prioridade, String status, String responsavel, String prazo) {
        String baseFilePath = "tarefas_base.csv";

        List<String[]> baseData = CSVFileController.readCSV(baseFilePath);

        for (String[] row : baseData) {
            if (row[0].equals(id)) {
                javax.swing.JOptionPane.showMessageDialog(main, "ID já existe! Não é possível adicionar a tarefa.", "Erro", javax.swing.JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

        String[] tarefaBase = {id, nome, categoria, prioridade, status};
        CSVFileController.addCSV(baseFilePath, tarefaBase);

        TarefaProfissional tarefaProfissional = new TarefaProfissional(Integer.parseInt(id), nome, categoria, prioridade, status);
        tarefaProfissional.setResponsavel(responsavel);
        tarefaProfissional.setPrazoEntrega(prazo);

        String[] tarefaProfissionalData = {id, responsavel, prazo};
        CSVFileController.addCSV("tarefas_profissionais.csv", tarefaProfissionalData);

        main.updateTable();
    }

    public void addPessoal(String id, String nome, String categoria, String prioridade, String status, String anotacoes, String dataLembrete) {
        String baseFilePath = "tarefas_base.csv";

        List<String[]> baseData = CSVFileController.readCSV(baseFilePath);

        for (String[] row : baseData) {
            if (row[0].equals(id)) {
                javax.swing.JOptionPane.showMessageDialog(main, "ID já existe! Não é possível adicionar a tarefa.", "Erro", javax.swing.JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

        String[] tarefaBase = {id, nome, categoria, prioridade, status};
        CSVFileController.addCSV(baseFilePath, tarefaBase);

        TarefaPessoal tarefaPessoal = new TarefaPessoal(Integer.parseInt(id), nome, categoria, prioridade, status);
        tarefaPessoal.setAnotacoes(anotacoes);
        tarefaPessoal.setDataLembrete(dataLembrete);

        String[] tarefaPessoalData = {id, anotacoes, dataLembrete};
        CSVFileController.addCSV("tarefas_pessoais.csv", tarefaPessoalData);

        main.updateTable();
    }
}
