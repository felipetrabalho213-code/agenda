package modelo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ModeloAgenda {

    private String descricao;
    private String prioridade;
    private String dataCriacao;

    public ModeloAgenda(String descricao, String prioridade) {
        this.descricao = descricao;
        this.prioridade = prioridade;

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        this.dataCriacao = sdf.format(new Date());
    }

    public ModeloAgenda(String descricao, String prioridade, String dataCriacao) {
        this.descricao = descricao;
        this.prioridade = prioridade;
        this.dataCriacao = dataCriacao;
    }

    public String getDescricao() { return descricao; }
    public String getPrioridade() { return prioridade; }
    public String getDataCriacao() { return dataCriacao; }

    public void setDescricao(String descricao) { this.descricao = descricao; }
    public void setPrioridade(String prioridade) { this.prioridade = prioridade; }
    public void setDataCriacao(String dataCriacao) { this.dataCriacao = dataCriacao; }

    public String toFileString() {
        return descricao + ";" + prioridade + ";" + dataCriacao;
    }
}
