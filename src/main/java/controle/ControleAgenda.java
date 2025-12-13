package controle;

import modelo.AgendaDAO;
import modelo.ModeloAgenda;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ControleAgenda {

    private AgendaDAO dao = new AgendaDAO();

    public boolean cadastrarTarefa(String descricao, String prioridade) {
        if (descricao == null || descricao.trim().isEmpty()) return false;

        String data = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss")
                .format(new Date());

        ModeloAgenda tarefa = new ModeloAgenda(descricao, prioridade, data);

        dao.salvar(tarefa);
        return true;
    }

   public boolean atualizarTarefa(String descricaoOriginal, String novaDescricao, String novaPrioridade) {

    List<ModeloAgenda> tarefas = dao.listarTodos();

    for (ModeloAgenda t : tarefas) {
        if (t.getDescricao().equals(descricaoOriginal)) {

            String novaData = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss")
                    .format(new Date());

            ModeloAgenda tarefaAtualizada = new ModeloAgenda(novaDescricao, novaPrioridade, novaData);

            dao.atualizar(descricaoOriginal, tarefaAtualizada);
            return true;
        }
    }
    return false;
}


    public boolean deletarTarefa(String descricao) {
        return dao.deletar(descricao);
    }

    public List<ModeloAgenda> listarTarefas() {
        return dao.listarTodos();
    }
}