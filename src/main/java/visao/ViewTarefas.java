
package visao;
import controle.ControleAgenda;
import javax.swing.table.DefaultTableModel;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

public class ViewTarefas extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(ViewTarefas.class.getName());

    public ViewTarefas() {
        initComponents();
    jTableTarefas.setModel(new javax.swing.table.DefaultTableModel(
    new Object [][] {
    },
    new String [] {
        "Título da tarefa", "Nível de prioridade", "Data de criação" // Nomes das colunas
    }
));

       jComboBoxPrioridade.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { 
    "Alto", "Médio", "Baixo" 
}));

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        labelTitulo = new javax.swing.JLabel();
        labelGerenciadorDeTarefas = new javax.swing.JLabel();
        jTextFieldTitulo = new javax.swing.JTextField();
        botaoAdicionar = new javax.swing.JButton();
        BotaoRemover = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableTarefas = new javax.swing.JTable();
        jComboBoxPrioridade = new javax.swing.JComboBox<>();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(800, 600));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));

        labelTitulo.setFont(new java.awt.Font("Rockwell Extra Bold", 1, 24)); // NOI18N
        labelTitulo.setForeground(new java.awt.Color(255, 255, 255));
        labelTitulo.setText("Título");

        labelGerenciadorDeTarefas.setFont(new java.awt.Font("Rockwell Extra Bold", 1, 24)); // NOI18N
        labelGerenciadorDeTarefas.setForeground(new java.awt.Color(255, 255, 255));
        labelGerenciadorDeTarefas.setText("Gerenciador de Tarefas");

        jTextFieldTitulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldTituloActionPerformed(evt);
            }
        });

        botaoAdicionar.setFont(new java.awt.Font("Rockwell Extra Bold", 1, 12)); // NOI18N
        botaoAdicionar.setText("Adicionar");
        botaoAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoAdicionarActionPerformed(evt);
            }
        });

        BotaoRemover.setFont(new java.awt.Font("Rockwell Extra Bold", 1, 12)); // NOI18N
        BotaoRemover.setText("Remover");

        jTableTarefas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Titulo da tarefa", "Nivel de prioridade", "Data de criação"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableTarefas);

        jComboBoxPrioridade.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "alta", "baixa", "media", " " }));
        jComboBoxPrioridade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxPrioridadeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(labelTitulo)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(78, 78, 78)
                        .addComponent(jComboBoxPrioridade, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(botaoAdicionar)
                        .addGap(67, 67, 67)
                        .addComponent(BotaoRemover))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(215, 215, 215)
                        .addComponent(labelGerenciadorDeTarefas))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 751, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(labelGerenciadorDeTarefas)
                .addGap(63, 63, 63)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelTitulo)
                    .addComponent(jTextFieldTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxPrioridade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoAdicionar)
                    .addComponent(BotaoRemover))
                .addGap(84, 84, 84)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(283, Short.MAX_VALUE))
        );

        jMenu1.setText("Menu");
        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxPrioridadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxPrioridadeActionPerformed
        
    }//GEN-LAST:event_jComboBoxPrioridadeActionPerformed

    private void jTextFieldTituloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldTituloActionPerformed
    }//GEN-LAST:event_jTextFieldTituloActionPerformed

    private void botaoAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoAdicionarActionPerformed
    DefaultTableModel modelo = (DefaultTableModel) jTableTarefas.getModel();

    String titulo = jTextFieldTitulo.getText();
    
    String prioridade = (String) jComboBoxPrioridade.getSelectedItem();
    
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    String dataCriacao = sdf.format(new Date());
    
    if (!titulo.trim().isEmpty()) { 
        Object[] linha = new Object[]{titulo, prioridade, dataCriacao};
        modelo.addRow(linha);
        jTextFieldTitulo.setText("");
        jComboBoxPrioridade.setSelectedIndex(0); 
    } else {
        
        JOptionPane.showMessageDialog(this, "O título da tarefa não pode estar vazio.", "Erro de Entrada", JOptionPane.ERROR_MESSAGE);
    }
    ControleAgenda a1 = new ControleAgenda();
    
    boolean teste = a1.cadastrarTarefa(titulo, prioridade);
    if (teste == true){
        JOptionPane.showMessageDialog(this, "Sucesso!");
    }else {
                JOptionPane.showMessageDialog(this, "Erro!");

    }
    }//GEN-LAST:event_botaoAdicionarActionPerformed

    public static void main(String args[]) {
  
        java.awt.EventQueue.invokeLater(() -> new ViewTarefas().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotaoRemover;
    private javax.swing.JButton botaoAdicionar;
    private javax.swing.JComboBox<String> jComboBoxPrioridade;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableTarefas;
    private javax.swing.JTextField jTextFieldTitulo;
    private javax.swing.JLabel labelGerenciadorDeTarefas;
    private javax.swing.JLabel labelTitulo;
    // End of variables declaration//GEN-END:variables
}
