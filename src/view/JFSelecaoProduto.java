package view;

import controller.ControllerProduto;
import interfaces.ProdutoListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Produto;
import util.Utilitario;

public class JFSelecaoProduto extends javax.swing.JFrame {

    Produto produto = new Produto();
    ControllerProduto controllerProduto = new ControllerProduto();
    ArrayList<Produto> listaProduto = new ArrayList<>();

    private ProdutoListener produtoListener;

    public void setProdutoListener(ProdutoListener produtoListener) {
        this.produtoListener = produtoListener;
    }

    public JFSelecaoProduto() {
        initComponents();
        carregaProduto();

        txtPesquisaNome.setText("");

        Utilitario.adicionarIcone(this);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTProduto = new javax.swing.JTable();
        btnLimpar = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        btnPesquisarNome = new javax.swing.JButton();
        txtPesquisaNome = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(74, 126, 88));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        JTProduto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Nome", "Preço", "Quantidade"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        JTProduto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTProdutoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(JTProduto);
        if (JTProduto.getColumnModel().getColumnCount() > 0) {
            JTProduto.getColumnModel().getColumn(0).setMinWidth(30);
            JTProduto.getColumnModel().getColumn(0).setPreferredWidth(30);
            JTProduto.getColumnModel().getColumn(0).setMaxWidth(30);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 660, 330));

        btnLimpar.setBackground(new java.awt.Color(51, 51, 51));
        btnLimpar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnLimpar.setForeground(new java.awt.Color(255, 255, 255));
        btnLimpar.setText("Limpar");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });
        jPanel1.add(btnLimpar, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 20, -1, 56));

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Pesquisar pelo Nome:");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));

        btnPesquisarNome.setBackground(new java.awt.Color(51, 51, 51));
        btnPesquisarNome.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnPesquisarNome.setForeground(new java.awt.Color(255, 255, 255));
        btnPesquisarNome.setText("Pesquisar");
        btnPesquisarNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarNomeActionPerformed(evt);
            }
        });
        jPanel1.add(btnPesquisarNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 20, -1, 56));

        txtPesquisaNome.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel1.add(txtPesquisaNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 40, 250, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 690, 440));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed

        txtPesquisaNome.setText("");
        carregaProduto();

    }//GEN-LAST:event_btnLimparActionPerformed

    private void btnPesquisarNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarNomeActionPerformed

        String nomePesquisa = txtPesquisaNome.getText().trim();
        List<Produto> listaProduto = new ArrayList<>();

        DefaultTableModel modelo = (DefaultTableModel) JTProduto.getModel();
        modelo.setNumRows(0);

        if (!nomePesquisa.isEmpty()) {
            listaProduto = controllerProduto.ControllerRetornaProdutoPelnoNome(nomePesquisa);
            if (listaProduto.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Nenhuma produto foi encontrado");
                carregaProduto();
            } else {
                for (Produto produto : listaProduto) {
                    modelo.addRow(new Object[]{
                        produto.getIdproduto(),
                        produto.getNome(),
                        produto.getPreco(),
                        produto.getQuantidade()
                    });
                }
            }
        }


    }//GEN-LAST:event_btnPesquisarNomeActionPerformed

    private void JTProdutoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTProdutoMouseClicked

        int linha = JTProduto.getSelectedRow();
        if (linha != -1 && produtoListener != null) {
            produto = new Produto();
            produto = listaProduto.get(linha);
            produtoListener.produtoSelecionado(produto);
        }

    }//GEN-LAST:event_JTProdutoMouseClicked

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
            java.util.logging.Logger.getLogger(JFSelecaoProduto.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFSelecaoProduto.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFSelecaoProduto.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFSelecaoProduto.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFSelecaoProduto().setVisible(true);
            }
        });
    }

    private void carregaProduto() {

        listaProduto = controllerProduto.controllerListaProduto();
        DefaultTableModel modelo = (DefaultTableModel) JTProduto.getModel();
        modelo.setNumRows(0);

        int cont = listaProduto.size();
        for (int i = 0; i < cont; i++) {
            modelo.addRow(new Object[]{
                listaProduto.get(i).getIdproduto(),
                listaProduto.get(i).getNome(),
                listaProduto.get(i).getPreco(),
                listaProduto.get(i).getQuantidade()
            });

        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable JTProduto;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnPesquisarNome;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtPesquisaNome;
    // End of variables declaration//GEN-END:variables
}
