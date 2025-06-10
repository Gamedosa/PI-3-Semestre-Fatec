package view;

import javax.swing.JFrame;
import util.Utilitario;

public class JFPrincipal extends javax.swing.JFrame {

    private static String nome;

    public JFPrincipal(String nomeUsuario) {
        this.nome = nomeUsuario;
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        Utilitario.adicionarIcone(this);
        txtNome.setText(nome);
    }

    private JFPrincipal() {

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtNome = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        btnCadastrarUsuario = new javax.swing.JMenuItem();
        btnCadastrarProduto = new javax.swing.JMenuItem();
        btnCadastrarCliente = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        btnPedidoOrcamento = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(74, 126, 88));

        txtNome.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtNome.setText("jLabel1");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(173, 173, 173)
                .addComponent(txtNome)
                .addContainerGap(419, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(177, 177, 177)
                .addComponent(txtNome)
                .addContainerGap(419, Short.MAX_VALUE))
        );

        jMenu1.setText("Cadastro");
        jMenu1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        btnCadastrarUsuario.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnCadastrarUsuario.setText("Cadastrar Usuário");
        btnCadastrarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarUsuarioActionPerformed(evt);
            }
        });
        jMenu1.add(btnCadastrarUsuario);

        btnCadastrarProduto.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnCadastrarProduto.setText("Cadastrar Produto");
        btnCadastrarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarProdutoActionPerformed(evt);
            }
        });
        jMenu1.add(btnCadastrarProduto);

        btnCadastrarCliente.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnCadastrarCliente.setText("Cadastrar Cliente");
        btnCadastrarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarClienteActionPerformed(evt);
            }
        });
        jMenu1.add(btnCadastrarCliente);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Pedidos");
        jMenu2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        btnPedidoOrcamento.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnPedidoOrcamento.setText("Pedidos de Orçamento");
        btnPedidoOrcamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPedidoOrcamentoActionPerformed(evt);
            }
        });
        jMenu2.add(btnPedidoOrcamento);

        jMenuBar1.add(jMenu2);

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

    private void btnCadastrarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarUsuarioActionPerformed
        
        new JFUsuario().setVisible(true);
        
    }//GEN-LAST:event_btnCadastrarUsuarioActionPerformed

    private void btnCadastrarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarProdutoActionPerformed
        
        new JFProduto().setVisible(true);
        
    }//GEN-LAST:event_btnCadastrarProdutoActionPerformed

    private void btnCadastrarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarClienteActionPerformed
        
        new JFCliente().setVisible(true);
        
    }//GEN-LAST:event_btnCadastrarClienteActionPerformed

    private void btnPedidoOrcamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPedidoOrcamentoActionPerformed
        
        new JFOrcamento(nome).setVisible(true);
        
    }//GEN-LAST:event_btnPedidoOrcamentoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Metal".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JFPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem btnCadastrarCliente;
    private javax.swing.JMenuItem btnCadastrarProduto;
    private javax.swing.JMenuItem btnCadastrarUsuario;
    private javax.swing.JMenuItem btnPedidoOrcamento;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel txtNome;
    // End of variables declaration//GEN-END:variables
}
