package controle;

import modelo.AgendaDAO;
import modelo.ModeloAgenda;
import java.util.List;

public class ControleAgenda {

    private AgendaDAO dao = new AgendaDAO();

    // Cadastrar nova tarefa
    public boolean cadastrarTarefa(String descricao, String prioridade) {
        if (descricao == null || descricao.trim().isEmpty()) {
            System.err.println("Erro: Descrição da tarefa não pode ser vazia.");
            return false;
        }

        ModeloAgenda novaTarefa = new ModeloAgenda(descricao, prioridade);
        dao.salvar(novaTarefa);
        return true;
    }

    // Buscar tarefa pela descrição
    public ModeloAgenda buscarTarefaPorDescricao(String descricao) {
        List<ModeloAgenda> tarefas = dao.listarTodos();
        for (ModeloAgenda tarefa : tarefas) {
            if (tarefa.getDescricao().equals(descricao)) {
                return tarefa;
            }
        }
        return null;
    }

    // Atualizar tarefa existente
    public boolean atualizarTarefa(String descricao, String novaPrioridade) {
        ModeloAgenda tarefaAtualizada = new ModeloAgenda(descricao, novaPrioridade);
        return dao.atualizar(tarefaAtualizada);
    }

    // Deletar tarefa
    public boolean deletarTarefa(String descricao) {
        return dao.deletar(descricao);
    }

    // Listar todas as tarefas
    public List<ModeloAgenda> listarTarefas() {
        return dao.listarTodos();
    }
}
