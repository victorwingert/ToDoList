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
