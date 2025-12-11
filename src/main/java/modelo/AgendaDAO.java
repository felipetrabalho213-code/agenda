package modelo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AgendaDAO {

    private static final String NOME_ARQUIVO = "agenda_db.txt";

    // Converte uma linha do arquivo em ModeloTarefa
    private ModeloAgenda parseTarefa(String linha) {
        String[] partes = linha.split(";");
        if (partes.length == 2) {
            String descricao = partes[0];
            String prioridade = partes[1];
            return new ModeloAgenda(descricao, prioridade);
        }
        return null;
    }

    // Lista todas as tarefas
    public List<ModeloAgenda> listarTodos() {
        List<ModeloAgenda> tarefas = new ArrayList<>();
        File arquivo = new File(NOME_ARQUIVO);

        if (!arquivo.exists() || arquivo.length() == 0) {
            return tarefas;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(NOME_ARQUIVO))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                if (linha.trim().isEmpty()) continue;

                ModeloAgenda tarefa = parseTarefa(linha);
                if (tarefa != null) {
                    tarefas.add(tarefa);
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler arquivo: " + e.getMessage());
        }

        return tarefas;
    }

    // Salva nova tarefa
    public void salvar(ModeloAgenda tarefa) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(NOME_ARQUIVO, true))) {
            writer.write(tarefa.toFileString());
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Erro ao salvar tarefa: " + e.getMessage());
        }
    }

    // Atualiza tarefa existente (busca pela descrição)
    public boolean atualizar(ModeloAgenda tarefaAtualizada) {
        List<ModeloAgenda> tarefas = listarTodos();
        boolean encontrado = false;

        for (int i = 0; i < tarefas.size(); i++) {
            if (tarefas.get(i).getDescricao().equals(tarefaAtualizada.getDescricao())) {
                tarefas.set(i, tarefaAtualizada);
                encontrado = true;
                break;
            }
        }

        if (encontrado) {
            reescreverArquivo(tarefas);
            return true;
        }
        return false;
    }

    // Deleta tarefa (busca pela descrição)
    public boolean deletar(String descricao) {
        List<ModeloAgenda> tarefas = listarTodos();
        List<ModeloAgenda> restantes = tarefas.stream()
                .filter(t -> !t.getDescricao().equals(descricao))
                .collect(Collectors.toList());

        if (restantes.size() < tarefas.size()) {
            reescreverArquivo(restantes);
            return true;
        }
        return false;
    }

    // Reescreve o arquivo
    private void reescreverArquivo(List<ModeloAgenda> tarefas) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(NOME_ARQUIVO, false))) {
            for (ModeloAgenda tarefa : tarefas) {
                writer.write(tarefa.toFileString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Erro ao reescrever arquivo: " + e.getMessage());
        }
    }
}
