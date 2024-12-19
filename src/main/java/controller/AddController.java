package controller;

import view.Main;

public class AddController {
    
    Main main;

    public AddController(Main main) {
        this.main = main;
    }

    public void add(String id, String nome, String categoria, String prioridade, String status) {
        String[] newRow = {id, nome, categoria, prioridade, status};
        CSVFileController.addCSV("data.csv", newRow);
        main.updateTable();
    }
}
