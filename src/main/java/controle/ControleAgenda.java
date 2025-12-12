package controle;

import modelo.AgendaDAO;
import modelo.ModeloAgenda;
import java.util.List;

public class ControleAgenda {

    private AgendaDAO dao = new AgendaDAO();

    public boolean cadastrarTarefa(String descricao, String prioridade) {
        if (descricao == null || descricao.trim().isEmpty()) {
            System.err.println("Erro: Descrição da tarefa não pode ser vazia.");
            return false;
        }

        ModeloAgenda novaTarefa = new ModeloAgenda(descricao, prioridade);
        dao.salvar(novaTarefa);
        return true;
    }

    public ModeloAgenda buscarTarefaPorDescricao(String descricao) {
        List<ModeloAgenda> tarefas = dao.listarTodos();
        for (ModeloAgenda tarefa : tarefas) {
            if (tarefa.getDescricao().equals(descricao)) {
                return tarefa;
            }
        }
        return null;
    }

    public boolean atualizarTarefa(String descricaoAntiga, String novaDescricao, String novaPrioridade, String novaDataCriacao) {

        ModeloAgenda tarefa = buscarTarefaPorDescricao(descricaoAntiga);

        if (tarefa == null) {
            return false;
        }

        tarefa.setDescricao(novaDescricao);
        tarefa.setPrioridade(novaPrioridade);
        tarefa.setDataCriacao(novaDataCriacao);

        return dao.atualizar(descricaoAntiga, tarefa);
    }

    public boolean deletarTarefa(String descricao) {
        return dao.deletar(descricao);
    }

    public List<ModeloAgenda> listarTarefas() {
        return dao.listarTodos();
    }
}
