package modelo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AgendaDAO {

    private static final String ARQUIVO = "agenda.bd.txt";

    public void salvar(ModeloAgenda tarefa) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARQUIVO, true))) {
            bw.write(
                tarefa.getDescricao() + ";" +
                tarefa.getPrioridade() + ";" +
                tarefa.getDataCriacao()
            );
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<ModeloAgenda> listarTodos() {
        List<ModeloAgenda> lista = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(ARQUIVO))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split(";");
                if (partes.length == 3) {
                    lista.add(new ModeloAgenda(partes[0], partes[1], partes[2]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return lista;
    }

    public boolean atualizar(ModeloAgenda tarefaAtualizada) {
        List<ModeloAgenda> tarefas = listarTodos();

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARQUIVO))) {
            for (ModeloAgenda t : tarefas) {
                if (t.getDescricao().equals(tarefaAtualizada.getDescricao())) {
                    bw.write(
                        tarefaAtualizada.getDescricao() + ";" +
                        tarefaAtualizada.getPrioridade() + ";" +
                        tarefaAtualizada.getDataCriacao()
                    );
                } else {
                    bw.write(
                        t.getDescricao() + ";" +
                        t.getPrioridade() + ";" +
                        t.getDataCriacao()
                    );
                }
                bw.newLine();
            }
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deletar(String descricao) {
        List<ModeloAgenda> tarefas = listarTodos();

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARQUIVO))) {
            for (ModeloAgenda t : tarefas) {
                if (!t.getDescricao().equals(descricao)) {
                    bw.write(
                        t.getDescricao() + ";" +
                        t.getPrioridade() + ";" +
                        t.getDataCriacao()
                    );
                    bw.newLine();
                }
            }
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
