package controller;

import java.util.List;
import javax.swing.table.DefaultTableModel;

public class TableController {

    public static void populateTable(String filePath, DefaultTableModel tableModel) {
        List<String[]> data = CSVFileController.readCSV(filePath);
        tableModel.setRowCount(0);
        for (String[] row : data) {
            tableModel.addRow(row);
        }
    }
}
