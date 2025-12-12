
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
    
        jTableTarefas.getSelectionModel().addListSelectionListener(e -> {
            int linha = jTableTarefas.getSelectedRow();
            if (linha >= 0) {
                jTextFieldTitulo.setText(jTableTarefas.getValueAt(linha, 0).toString());
                jComboBoxPrioridade.setSelectedItem(jTableTarefas.getValueAt(linha, 1).toString());
            }
        });

        jTableTarefas.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][] {
        },
        new String [] {
            "Título da tarefa", "Nível de prioridade", "Data de criação" // Nomes das colunas
        })
        );

       jComboBoxPrioridade.setModel(new javax.swing.DefaultComboBoxModel<>(
        new String[] {"Alto", "Médio", "Baixo"})
       );
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
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
        botaoAtualizar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
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
        BotaoRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoRemoverActionPerformed(evt);
            }
        });

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

        botaoAtualizar.setFont(new java.awt.Font("Rockwell Extra Bold", 1, 12)); // NOI18N
        botaoAtualizar.setText("Atualizar");
        botaoAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoAtualizarActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Rockwell Extra Bold", 0, 12)); // NOI18N
        jButton1.setText("Listar tarefas");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(botaoAtualizar)
                .addGap(48, 48, 48)
                .addComponent(jButton1)
                .addGap(228, 228, 228))
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
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoAtualizar)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(285, Short.MAX_VALUE))
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
    }// </editor-fold>                        

    private void jComboBoxPrioridadeActionPerformed(java.awt.event.ActionEvent evt) {                                                    
        
    }                                                   

    private void jTextFieldTituloActionPerformed(java.awt.event.ActionEvent evt) {                                                 
    }                                                

    private void botaoAdicionarActionPerformed(java.awt.event.ActionEvent evt) {                                               
    DefaultTableModel modelo = (DefaultTableModel) jTableTarefas.getModel();

    String titulo = jTextFieldTitulo.getText();
    
    String prioridade = (String) jComboBoxPrioridade.getSelectedItem();
    
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
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
    }                                              

    private void BotaoRemoverActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // TODO add your handling code here:
        int linha = jTableTarefas.getSelectedRow();

        if (linha < 0) {
            JOptionPane.showMessageDialog(this, "Selecione uma tarefa para remover.");
            return;
        }
        
        DefaultTableModel modelo = (DefaultTableModel) jTableTarefas.getModel();
        String tituloDaTabela = (String) modelo.getValueAt(linha, 0);
        modelo.removeRow(linha);

        ControleAgenda controle = new ControleAgenda();
        boolean ok = controle.deletarTarefa(tituloDaTabela);

        if (ok) {
            JOptionPane.showMessageDialog(this, "Tarefa removida com sucesso!");
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao remover a tarefa do arquivo!");
        }    
    }                                            

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        listarTodasAsTarefas();
    }                                        

    private void botaoAtualizarActionPerformed(java.awt.event.ActionEvent evt) {                                               
 int linha = jTableTarefas.getSelectedRow();

    if (linha < 0) {
        JOptionPane.showMessageDialog(this, "Selecione uma tarefa para atualizar.");
        return;
    }

    // Dados originais da linha selecionada
    String descricaoOriginal = jTableTarefas.getValueAt(linha, 0).toString();

    // Novos valores digitados
    String novaDescricao = jTextFieldTitulo.getText().trim();
    String novaPrioridade = jComboBoxPrioridade.getSelectedItem().toString();

    if (novaDescricao.isEmpty()) {
        JOptionPane.showMessageDialog(this, "O título não pode estar vazio.");
        return;
    }

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    String novaDataCriacao = sdf.format(new Date());

    ControleAgenda controle = new ControleAgenda();

    // Atualiza tarefa passando a *descrição original*
    boolean sucesso = controle.atualizarTarefa(descricaoOriginal, novaDescricao, novaPrioridade, novaDataCriacao);

    if (sucesso) {
        JOptionPane.showMessageDialog(this, "Tarefa atualizada com sucesso!");

        listarTodasAsTarefas();

    } else {
        JOptionPane.showMessageDialog(this, "Erro ao atualizar tarefa.");
    }
    }                                              
    
    private void listarTodasAsTarefas() {

    ControleAgenda controle = new ControleAgenda();
    java.util.List<modelo.ModeloAgenda> tarefas = controle.listarTarefas();

    DefaultTableModel modelo = (DefaultTableModel) jTableTarefas.getModel();
    modelo.setRowCount(0);

    for (modelo.ModeloAgenda t : tarefas) {
        modelo.addRow(new Object[]{
            t.getDescricao(),
            t.getPrioridade(),
            t.getDataCriacao()
        });
    }

    StringBuilder msg = new StringBuilder("Tarefas agendadas:\n\n");

    for (modelo.ModeloAgenda t : tarefas) {
        msg.append(t.getDescricao())
           .append(" - ")
           .append(t.getPrioridade())
           .append(" - Criada em: ")
           .append(t.getDataCriacao())
           .append("\n");
    }

    JOptionPane.showMessageDialog(this, msg.toString());
}    
    public static void main(String args[]) {
  
        java.awt.EventQueue.invokeLater(() -> new ViewTarefas().setVisible(true));
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton BotaoRemover;
    private javax.swing.JButton botaoAdicionar;
    private javax.swing.JButton botaoAtualizar;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBoxPrioridade;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableTarefas;
    private javax.swing.JTextField jTextFieldTitulo;
    private javax.swing.JLabel labelGerenciadorDeTarefas;
    private javax.swing.JLabel labelTitulo;
    // End of variables declaration                   

    private boolean removerDoTxt(int linha) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
