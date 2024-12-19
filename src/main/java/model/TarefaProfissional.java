package model;

public class TarefaProfissional extends TarefaBase {
    
    private String responsavel;
    private String prazoEntrega;

    public TarefaProfissional(int id, String descricao, String categoria, String prioridade, String status) {
        super(id, descricao, categoria, prioridade, status);
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public String getPrazoEntrega() {
        return prazoEntrega;
    }

    public void setPrazoEntrega(String prazoEntrega) {
        this.prazoEntrega = prazoEntrega;
    }
}
