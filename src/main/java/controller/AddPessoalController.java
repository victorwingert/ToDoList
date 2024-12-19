package controller;

import model.TarefaPessoal;
import view.Main;

public class AddPessoalController {

    Main main;

    public AddPessoalController(Main main) {
        this.main = main;
    }

    public void add(String id, String nome, String categoria, String prioridade, String status, String anotacoes, String dataLembrete) {
        String[] tarefaBase = {id, nome, categoria, prioridade, status};

        CSVFileController.addCSV("tarefas_base.csv", tarefaBase);

        TarefaPessoal tarefaPessoal = new TarefaPessoal(Integer.parseInt(id), nome, categoria, prioridade, status);
        tarefaPessoal.setAnotacoes(anotacoes);
        tarefaPessoal.setDataLembrete(dataLembrete);

        String[] tarefaPessoalData = {id, anotacoes, dataLembrete};
        CSVFileController.addCSV("tarefas_pessoais.csv", tarefaPessoalData);

        main.updateTable();
    }
}
