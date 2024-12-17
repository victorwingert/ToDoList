package model;

public class Tarefa extends TarefaBase {
    
    // Tarefa herda todos os métodos publicos de TarefaBase

    public Tarefa(int id, String descricao, String categoria, String prioridade, String status) {
        super(id, descricao, categoria, prioridade, status);
    }

    @Override
    public void imprimir() {
        System.out.println("ID: " + getId() + " | Descricao: " + getDescricao() +
                           " | Categoria: " + getCategoria() + " | Prioridade: " + getPrioridade() +
                           " | Status: " + getStatus());
    }
}
