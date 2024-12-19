package controller;

import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import view.Edit;
import view.Main;

public class EditController {

    private Main main;
    private JTable jTable;

    public EditController(Main main) {
        this.main = main;
        this.jTable = main.getjTable();
    }

    public void fillFieldsFromSelectedRow(Edit edit) {
        int selectedRow = jTable.getSelectedRow();

        if (selectedRow != -1) {
            DefaultTableModel model = (DefaultTableModel) jTable.getModel();

            String nome = model.getValueAt(selectedRow, 1).toString();
            String categoria = model.getValueAt(selectedRow, 2).toString();
            String prioridade = model.getValueAt(selectedRow, 3).toString();
            String status = model.getValueAt(selectedRow, 4).toString();

            edit.setNomeField(nome);
            edit.setCategoriaField(categoria);
            edit.setPrioridadeField(prioridade);
            edit.setStatusField(status);

            main.getEditDialog().setVisible(true);
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

    public void edit(String nome, String categoria, String prioridade, String status) {
        String filePath = "data.csv";
        List<String[]> data = CSVFileController.readCSV(filePath);
        String id = getIdSelectedRow();

        for (int i = 0; i < data.size(); i++) {
            if (data.get(i)[0].equals(id)) {
                data.set(i, new String[]{id, nome, categoria, prioridade, status});
                break;
            }
        }

        CSVFileController.writeCSV(filePath, data);

        main.updateTable();
    }

}
