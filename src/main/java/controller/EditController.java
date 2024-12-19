package controller;

import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import view.EditPessoal;
import view.EditProfissional;
import view.Main;

public class EditController {

    private Main main;
    private JTable jTable;

    public EditController(Main main) {
        this.main = main;
        this.jTable = main.getjTable();
    }

    public void fillFieldsFromSelectedRowPessoal(EditPessoal edit) {
        String selectedId = getIdSelectedRow();

        if (selectedId != null) {
            String baseFilePath = "tarefas_base.csv";
            List<String[]> baseData = CSVFileController.readCSV(baseFilePath);

            String nome = "", categoria = "", prioridade = "", status = "";
            for (String[] row : baseData) {
                if (row[0].equals(selectedId)) {
                    nome = row[1];
                    categoria = row[2];
                    prioridade = row[3];
                    status = row[4];
                    break;
                }
            }

            String pessoalFilePath = "tarefas_pessoais.csv";
            List<String[]> pessoalData = CSVFileController.readCSV(pessoalFilePath);

            String anotacoes = "", dataLembrete = "";
            for (String[] row : pessoalData) {
                if (row[0].equals(selectedId)) {
                    anotacoes = row[1];
                    dataLembrete = row[2];
                    break;
                }
            }

            edit.setNomeField(nome);
            edit.setPrioridadeField(prioridade);
            edit.setStatusField(status);
            edit.setAnotacoes(anotacoes);
            edit.setDataLembrete(dataLembrete);

            main.getEditDialog().setVisible(true);
        } else {
            javax.swing.JOptionPane.showMessageDialog(main, "Nenhuma linha selecionada!", "Erro", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }

    public void fillFieldsFromSelectedRowProfissional(EditProfissional edit) {
        String selectedId = getIdSelectedRow();

        if (selectedId != null) {
            String baseFilePath = "tarefas_base.csv";
            List<String[]> baseData = CSVFileController.readCSV(baseFilePath);

            String nome = "", categoria = "", prioridade = "", status = "";
            for (String[] row : baseData) {
                if (row[0].equals(selectedId)) {
                    nome = row[1];
                    categoria = row[2];
                    prioridade = row[3];
                    status = row[4];
                    break;
                }
            }

            String profissionalFilePath = "tarefas_profissionais.csv";
            List<String[]> profissonalData = CSVFileController.readCSV(profissionalFilePath);

            String responsavel = "", prazo = "";
            for (String[] row : profissonalData) {
                if (row[0].equals(selectedId)) {
                    responsavel = row[1];
                    prazo = row[2];
                    break;
                }
            }

            edit.setNomeField(nome);
            edit.setPrioridadeField(prioridade);
            edit.setStatusField(status);
            edit.setResponsavel(responsavel);
            edit.setPrazo(prazo);

            main.getEditDialogProfissional().setVisible(true);
        } else {
            javax.swing.JOptionPane.showMessageDialog(main, "Nenhuma linha selecionada!", "Erro", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }

    private String getIdSelectedRow() {
        int selectedRow = jTable.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) jTable.getModel();
        String id = model.getValueAt(selectedRow, 0).toString();
        return id;
    }

    public void editPessoal(String nome, String categoria, String prioridade, String status, String anotacoes, String dataLembrete) {
        String baseFilePath = "tarefas_base.csv";
        List<String[]> baseData = CSVFileController.readCSV(baseFilePath);
        String id = getIdSelectedRow();

        for (int i = 0; i < baseData.size(); i++) {
            if (baseData.get(i)[0].equals(id)) {
                baseData.set(i, new String[]{id, nome, categoria, prioridade, status});
                break;
            }
        }

        CSVFileController.writeCSV(baseFilePath, baseData);

        String pessoalFilePath = "tarefas_pessoais.csv";
        List<String[]> pessoalData = CSVFileController.readCSV(pessoalFilePath);

        for (int i = 0; i < pessoalData.size(); i++) {
            if (pessoalData.get(i)[0].equals(id)) {
                pessoalData.set(i, new String[]{id, anotacoes, dataLembrete});
                break;
            }
        }

        CSVFileController.writeCSV(pessoalFilePath, pessoalData);

        main.updateTable();
    }

    public void editProfissional(String nome, String categoria, String prioridade, String status, String responsavel, String prazo) {
        String baseFilePath = "tarefas_base.csv";
        List<String[]> baseData = CSVFileController.readCSV(baseFilePath);
        String id = getIdSelectedRow();

        for (int i = 0; i < baseData.size(); i++) {
            if (baseData.get(i)[0].equals(id)) {
                baseData.set(i, new String[]{id, nome, categoria, prioridade, status});
                break;
            }
        }

        CSVFileController.writeCSV(baseFilePath, baseData);

        String profissionalFilePath = "tarefas_profissionais.csv";
        List<String[]> profissionalData = CSVFileController.readCSV(profissionalFilePath);

        for (int i = 0; i < profissionalData.size(); i++) {
            if (profissionalData.get(i)[0].equals(id)) {
                profissionalData.set(i, new String[]{id, responsavel, prazo});
                break;
            }
        }

        CSVFileController.writeCSV(profissionalFilePath, profissionalData);

        main.updateTable();
    }

}
