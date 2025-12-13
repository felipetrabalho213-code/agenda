package modelo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AgendaDAO {

    private static final String ARQUIVO = "agenda.bd.txt";

    // Salvar uma nova tarefa
    public void salvar(ModeloAgenda tarefa) {
        List<ModeloAgenda> tarefas = listarTodos();
        tarefas.add(tarefa);
        salvarTodosNoArquivo(tarefas);
    }

    public void atualizar(String descricaoOriginal, ModeloAgenda tarefaAtualizada) {
    List<ModeloAgenda> tarefas = listarTodos();
    for (int i = 0; i < tarefas.size(); i++) {
        if (tarefas.get(i).getDescricao().trim()
                .equalsIgnoreCase(descricaoOriginal.trim())) {
            tarefas.set(i, tarefaAtualizada);
            break;
        }
    }
    salvarTodosNoArquivo(tarefas);
}

    // Deletar tarefa com base no título
    public boolean deletar(String descricao) {
        List<ModeloAgenda> tarefas = listarTodos();
        boolean removido = tarefas.removeIf(t -> t.getDescricao().trim()
                .equalsIgnoreCase(descricao.trim()));
        if (removido) {
            salvarTodosNoArquivo(tarefas);
        }
        return removido;
    }

    // Listar todas as tarefas do arquivo
    public List<ModeloAgenda> listarTodos() {
        List<ModeloAgenda> tarefas = new ArrayList<>();
        File file = new File(ARQUIVO);
        if (!file.exists()) return tarefas;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split(";");
                if (partes.length == 3) {
                    tarefas.add(new ModeloAgenda(partes[0], partes[1], partes[2]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tarefas;
    }

    // Salvar todas as tarefas no arquivo
    private void salvarTodosNoArquivo(List<ModeloAgenda> tarefas) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARQUIVO))) {
            for (ModeloAgenda t : tarefas) {
                bw.write(t.toFileString());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
