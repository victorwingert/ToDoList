package controller;

import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import view.Main;

public class VerController {

    private Main main;
    private JTable jTable;

    public VerController(Main main) {
        this.main = main;
        this.jTable = main.getjTable();
    }

    private String getIdSelectedRow() {
        int selectedRow = jTable.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) jTable.getModel();
        String id = model.getValueAt(selectedRow, 0).toString();
        return id;
    }

    public void fillLabelsPessoal() {
        String selectedRowId = getIdSelectedRow();
        int selectedRowIdNumber = Integer.parseInt(selectedRowId);

        if (selectedRowIdNumber != -1) {
            List<String[]> tarefasPessoais = CSVFileController.readCSV("tarefas_pessoais.csv");

            for (String[] tarefaPessoal : tarefasPessoais) {
                if (tarefaPessoal[0].equals(selectedRowId)) {
                    main.getVerPessoal().getAnotacoes().setText(tarefaPessoal[1]);
                    main.getVerPessoal().getDataLembrete().setText(tarefaPessoal[2]);
                    break;
                }
            }

            main.getVerPessoal().setVisible(true);
        } else {
            javax.swing.JOptionPane.showMessageDialog(main, "Nenhuma linha selecionada!", "Erro", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }

    public void fillLabelsProfissional() {
        String selectedRowId = getIdSelectedRow();
        int selectedRowIdNumber = Integer.parseInt(selectedRowId);

        if (selectedRowIdNumber != -1) {
            List<String[]> tarefasProfissionais = CSVFileController.readCSV("tarefas_profissionais.csv");

            for (String[] tarefaProfissional : tarefasProfissionais) {
                if (tarefaProfissional[0].equals(selectedRowId)) {
                    main.getVerProfissional().getPrazo().setText(tarefaProfissional[2]);
                    main.getVerProfissional().getResponsavel().setText(tarefaProfissional[1]);
                    break;
                }
            }

            main.getVerProfissional().setVisible(true);
        } else {
            javax.swing.JOptionPane.showMessageDialog(main, "Nenhuma linha selecionada!", "Erro", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }
}
