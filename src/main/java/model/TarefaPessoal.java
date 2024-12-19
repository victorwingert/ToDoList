package model;

public class TarefaPessoal extends TarefaBase {
    
    private String anotacoes;
    private String dataLembrete;

    public TarefaPessoal(int id, String descricao, String categoria, String prioridade, String status) {
        super(id, descricao, categoria, prioridade, status);
    }

    public String getAnotacoes() {
        return anotacoes;
    }

    public void setAnotacoes(String anotacoes) {
        this.anotacoes = anotacoes;
    }

    public String getDataLembrete() {
        return dataLembrete;
    }

    public void setDataLembrete(String dataLembrete) {
        this.dataLembrete = dataLembrete;
    }
    
}
