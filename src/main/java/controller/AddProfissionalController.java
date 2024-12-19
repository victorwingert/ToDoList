package controller;

import model.TarefaProfissional;
import view.Main;

public class AddProfissionalController {

    Main main;

    public AddProfissionalController(Main main) {
        this.main = main;
    }

    public void add(String id, String nome, String categoria, String prioridade, String status, String responsavel, String prazo) {
        String[] tarefaBase = {id, nome, categoria, prioridade, status};

        CSVFileController.addCSV("tarefas_base.csv", tarefaBase);

        TarefaProfissional tarefaProfissional = new TarefaProfissional(Integer.parseInt(id), nome, categoria, prioridade, status);
        tarefaProfissional.setResponsavel(responsavel);
        tarefaProfissional.setPrazoEntrega(prazo);

        String[] tarefaProfissionalData = {id, responsavel, prazo};
        CSVFileController.addCSV("tarefas_profissionais.csv", tarefaProfissionalData);

        main.updateTable();
    }

}
