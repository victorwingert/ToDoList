package interfaces;

import java.util.List;
import model.TarefaBase;

public interface Gerenciavel {
     void adicionar(TarefaBase tarefa);
     void remover(int id);
     void editar(int id, TarefaBase tarefa);
     List<TarefaBase> listar();
}
