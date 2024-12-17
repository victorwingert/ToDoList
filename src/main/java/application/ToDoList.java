package application;

import controller.GerenciadorTarefas;
import model.Tarefa;

public class ToDoList {

    public static void main(String[] args) {
        GerenciadorTarefas gerenciador = new GerenciadorTarefas();
        
        // criando as tarefas
        Tarefa tarefa1 = new Tarefa(1, "Estudar Java", "Estudos", "Alta", "Pendente");
        Tarefa tarefa2 = new Tarefa(2, "Fazer compras", "Pessoal", "Media", "Concluida");
        
        // adicionando tarefas
        gerenciador.adicionar(tarefa1);
        gerenciador.adicionar(tarefa2);
        
        // listando tarefas
        System.out.println("Lista de Tarefas:");
        gerenciador.listar().forEach(t -> t.imprimir());
        
        // editando tarefa
        Tarefa novaTarefa = new Tarefa(1, "Estudar Teoria dos Numeros", "Estudos", "Alta", "Pendente");
        gerenciador.editar(1, novaTarefa);
        
        // removendo tarefa
        gerenciador.remover(2);
        
        // listando tarefas apos mudanças
        System.out.println("Lista de Tarefas Atualizada:");
        gerenciador.listar().forEach(t -> t.imprimir());
    }
}
