package model;

public abstract class TarefaBase {
    
    // Classe abstrata que possui o basico que uma Tarefa deve ter
    
    private int id;
    private String descricao;
    private String categoria;
    private String prioridade;
    private String status;

    public TarefaBase(int id, String descricao, String categoria, String prioridade, String status) {
        this.id = id;
        this.descricao = descricao;
        this.categoria = categoria;
        this.prioridade = prioridade;
        this.status = status;
    }
    
    public abstract void imprimir();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(String prioridade) {
        this.prioridade = prioridade;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
