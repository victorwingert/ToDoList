//package controller;
//
//import interfaces.Gerenciavel;
//import java.util.ArrayList;
//import java.util.List;
//import model.TarefaBase;
//
//public class GerenciadorTarefas implements Gerenciavel {
//    private List<TarefaBase> tarefas;
//
//    public GerenciadorTarefas() {
//        this.tarefas = new ArrayList<>();
//    }
//    
//    @Override
//    public void adicionar(TarefaBase tarefa) {
//        tarefas.add(tarefa);
//        System.out.println("Tarefa adicionada com sucesso!");
//    }
//
//    @Override
//    public void remover(int id) {
//        tarefas.removeIf(t -> t.getId() == id); // remove todas as tarefas com o id especificado
//        System.out.println("Tarefa removida com sucesso!");
//    }
//
//    @Override
//    public void editar(int id, TarefaBase novaTarefa) {
//        for (int i = 0; i < tarefas.size(); i++) {
//            if (tarefas.get(i).getId() == id) {
//                tarefas.set(i, novaTarefa);
//                System.out.println("Tarefa editada com sucesso!");
//                return;       
//            }
//        }
//        System.out.println("Tarefa não encontrada.");
//    }
//
//    @Override
//    public List<TarefaBase> listar() {
//        return tarefas;
//    }
//}
