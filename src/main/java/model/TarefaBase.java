package model;

public abstract class TarefaBase {
    
    // Classe abstrata que possui o basico que uma Tarefa deve ter
    
    private int id;
    private String nome;
    private String categoria;
    private String prioridade;
    private String status;

    public TarefaBase(int id, String nome, String categoria, String prioridade, String status) {
        this.id = id;
        this.nome = nome;
        this.categoria = categoria;
        this.prioridade = prioridade;
        this.status = status;
    }
}
