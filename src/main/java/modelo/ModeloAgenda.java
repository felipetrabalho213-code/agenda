package modelo;

public class ModeloAgenda {
    private String descricao;
    private String prioridade;

    public ModeloAgenda(String descricao, String prioridade) {
        this.descricao = descricao;
        this.prioridade = prioridade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(String prioridade) {
        this.prioridade = prioridade;
    }

    // Formato para salvar no arquivo
    public String toFileString() {
        return descricao + ";" + prioridade;
    }
}
