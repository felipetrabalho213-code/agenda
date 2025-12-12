package visao;

import controle.ControleAgenda;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ViewTarefas extends javax.swing.JFrame {

    public ViewTarefas() {
        initComponents();
        listarTodasAsTarefas();

        jTableTarefas.getSelectionModel().addListSelectionListener(e -> {
            int linha = jTableTarefas.getSelectedRow();
            if (linha >= 0) {
                jTextFieldTitulo.setText(jTableTarefas.getValueAt(linha, 0).toString());
                jComboBoxPrioridade.setSelectedItem(jTableTarefas.getValueAt(linha, 1).toString());
            }
        });
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTextFieldTitulo = new javax.swing.JTextField();
        jComboBoxPrioridade = new javax.swing.JComboBox<>();
        botaoAdicionar = new javax.swing.JButton();
        botaoAtualizar = new javax.swing.JButton();
        botaoRemover = new javax.swing.JButton();
        botaoListar = new javax.swing.JButton();
        botaoVoltar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableTarefas = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gerenciador de Tarefas");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));

        jComboBoxPrioridade.setModel(
            new javax.swing.DefaultComboBoxModel<>(new String[]{"Alta", "Média", "Baixa"})
        );

        botaoAdicionar.setText("Adicionar");
        botaoAdicionar.addActionListener(evt -> adicionar());

        botaoAtualizar.setText("Atualizar");
        botaoAtualizar.addActionListener(evt -> atualizar());

        botaoRemover.setText("Remover");
        botaoRemover.addActionListener(evt -> remover());

        botaoListar.setText("Listar tarefas");
        botaoListar.addActionListener(evt -> listarTodasAsTarefas());

        botaoVoltar.setText("Voltar");
        botaoVoltar.addActionListener(evt -> {
            dispose();
            new ViewPrincipal().setVisible(true);
        });

        jTableTarefas.setModel(new DefaultTableModel(
            new Object[][]{},
            new String[]{"Título", "Prioridade", "Data/Hora"}
        ));
        jScrollPane1.setViewportView(jTableTarefas);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(layout);

        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(20)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 740, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jTextFieldTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(10)
                            .addComponent(jComboBoxPrioridade, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(10)
                            .addComponent(botaoAdicionar)
                            .addGap(10)
                            .addComponent(botaoAtualizar)
                            .addGap(10)
                            .addComponent(botaoRemover)
                            .addGap(10)
                            .addComponent(botaoListar)
                            .addGap(10)
                            .addComponent(botaoVoltar)))
                    .addContainerGap(20, Short.MAX_VALUE))
        );

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(20)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextFieldTitulo)
                        .addComponent(jComboBoxPrioridade)
                        .addComponent(botaoAdicionar)
                        .addComponent(botaoAtualizar)
                        .addComponent(botaoRemover)
                        .addComponent(botaoListar)
                        .addComponent(botaoVoltar))
                    .addGap(20)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(20, Short.MAX_VALUE))
        );

        setContentPane(jPanel1);
        pack();
        setLocationRelativeTo(null);
    }

    private void adicionar() {
        String titulo = jTextFieldTitulo.getText().trim();
        String prioridade = jComboBoxPrioridade.getSelectedItem().toString();

        if (titulo.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Título obrigatório");
            return;
        }

        new ControleAgenda().cadastrarTarefa(titulo, prioridade);
        listarTodasAsTarefas();
        jTextFieldTitulo.setText("");
    }

    private void atualizar() {
        int linha = jTableTarefas.getSelectedRow();
        if (linha < 0) {
            JOptionPane.showMessageDialog(this, "Selecione uma tarefa");
            return;
        }

        String descricaoOriginal = jTableTarefas.getValueAt(linha, 0).toString();
        String novaDescricao = jTextFieldTitulo.getText().trim();
        String novaPrioridade = jComboBoxPrioridade.getSelectedItem().toString();

        new ControleAgenda().atualizarTarefa(descricaoOriginal, novaDescricao, novaPrioridade);
        listarTodasAsTarefas();
    }

    private void remover() {
        int linha = jTableTarefas.getSelectedRow();
        if (linha < 0) {
            JOptionPane.showMessageDialog(this, "Selecione uma tarefa");
            return;
        }

        String descricao = jTableTarefas.getValueAt(linha, 0).toString();

        new ControleAgenda().deletarTarefa(descricao);
        listarTodasAsTarefas();
    }

    private void listarTodasAsTarefas() {
        DefaultTableModel model = (DefaultTableModel) jTableTarefas.getModel();
        model.setRowCount(0);

        new ControleAgenda().listarTarefas().forEach(t ->
            model.addRow(new Object[]{
                t.getDescricao(),
                t.getPrioridade(),
                t.getDataCriacao()
            })
        );
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> new ViewTarefas().setVisible(true));
    }

    private javax.swing.JButton botaoAdicionar;
    private javax.swing.JButton botaoAtualizar;
    private javax.swing.JButton botaoRemover;
    private javax.swing.JButton botaoListar;
    private javax.swing.JButton botaoVoltar;
    private javax.swing.JComboBox<String> jComboBoxPrioridade;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableTarefas;
    private javax.swing.JTextField jTextFieldTitulo;
}
