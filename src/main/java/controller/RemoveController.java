package controller;

import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import view.Main;

public class RemoveController {

    private Main main;
    private JTable jTable;

    public RemoveController(Main main) {
        this.main = main;
        jTable = main.getjTable();
    }

    public void remove() {
        int selectedRow = jTable.getSelectedRow();

        if (selectedRow != -1) {
            DefaultTableModel model = (DefaultTableModel) jTable.getModel();
            String selectedId = model.getValueAt(selectedRow, 0).toString();

            String csvFile = "data.csv";

            List<String[]> data = CSVFileController.readCSV(csvFile);

            data.removeIf(row -> row[0].equals(selectedId));

            CSVFileController.writeCSV(csvFile, data);

            main.updateTable();
        } else {
            javax.swing.JOptionPane.showMessageDialog(main, "Nenhuma linha selecionada!", "Erro", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }
}
