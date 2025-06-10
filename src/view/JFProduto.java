package view;

import controller.ControllerProduto;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import model.Produto;
import util.Utilitario;

public class JFProduto extends javax.swing.JFrame {

    Produto produto = new Produto();
    ControllerProduto controllerProduto = new ControllerProduto();
    ArrayList<Produto> listaProduto = new ArrayList<>();

    private byte[] imagemSelecionada;

    public JFProduto() {
        initComponents();
        habilitarCampos(false);
        carregaProduto();

        Utilitario.adicionarIcone(this);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txtQuantidade = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtPreco = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtObservacao = new javax.swing.JTextArea();
        txtImagem = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTProduto = new javax.swing.JTable();
        btnSalvar = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        btnNovo = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        btnPesquisarNome = new javax.swing.JButton();
        txtPesquisaNome = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(74, 126, 88));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Gestão de Produto");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, -1, -1));

        jPanel2.setBackground(new java.awt.Color(74, 126, 88));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)), "Dados do Produto:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtQuantidade.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtQuantidade.setEnabled(false);
        jPanel2.add(txtQuantidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 80, 80, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Código:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, -1));

        txtCodigo.setEditable(false);
        txtCodigo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtCodigo.setEnabled(false);
        jPanel2.add(txtCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 50, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Nome Produto:");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 30, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Observação:");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

        txtNome.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtNome.setEnabled(false);
        jPanel2.add(txtNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 30, 310, -1));

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Preço (R$)");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 80, -1, -1));

        txtPreco.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtPreco.setEnabled(false);
        jPanel2.add(txtPreco, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 80, 100, -1));

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Quantidade:");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));

        txtObservacao.setColumns(20);
        txtObservacao.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtObservacao.setRows(5);
        txtObservacao.setEnabled(false);
        jScrollPane2.setViewportView(txtObservacao);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 120, 450, 100));

        txtImagem.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtImagem.setForeground(new java.awt.Color(255, 255, 255));
        txtImagem.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtImagem.setText("Clique aqui...");
        txtImagem.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtImagem.setEnabled(false);
        txtImagem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtImagemMouseClicked(evt);
            }
        });
        jPanel2.add(txtImagem, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 20, 120, 190));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 750, 230));

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
        jScrollPane1.setViewportView(JTProduto);
        if (JTProduto.getColumnModel().getColumnCount() > 0) {
            JTProduto.getColumnModel().getColumn(0).setMinWidth(30);
            JTProduto.getColumnModel().getColumn(0).setPreferredWidth(30);
            JTProduto.getColumnModel().getColumn(0).setMaxWidth(30);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 470, 740, 330));

        btnSalvar.setBackground(new java.awt.Color(51, 51, 51));
        btnSalvar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnSalvar.setForeground(new java.awt.Color(255, 255, 255));
        btnSalvar.setText("SALVAR");
        btnSalvar.setEnabled(false);
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });
        jPanel1.add(btnSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 330, -1, 56));

        btnLimpar.setBackground(new java.awt.Color(51, 51, 51));
        btnLimpar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnLimpar.setForeground(new java.awt.Color(255, 255, 255));
        btnLimpar.setText("Limpar");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });
        jPanel1.add(btnLimpar, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 400, -1, 56));

        btnNovo.setBackground(new java.awt.Color(51, 51, 51));
        btnNovo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnNovo.setForeground(new java.awt.Color(255, 255, 255));
        btnNovo.setText("NOVO");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });
        jPanel1.add(btnNovo, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 330, -1, 56));

        btnExcluir.setBackground(new java.awt.Color(51, 51, 51));
        btnExcluir.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnExcluir.setForeground(new java.awt.Color(255, 255, 255));
        btnExcluir.setText("EXCLUIR");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });
        jPanel1.add(btnExcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 330, -1, 56));

        btnAlterar.setBackground(new java.awt.Color(51, 51, 51));
        btnAlterar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnAlterar.setForeground(new java.awt.Color(255, 255, 255));
        btnAlterar.setText("ALTERAR");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAlterar, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 330, 110, 56));

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Pesquisar pelo Nome:");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 420, -1, -1));

        btnCancelar.setBackground(new java.awt.Color(51, 51, 51));
        btnCancelar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setText("CANCELAR");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 330, -1, 56));

        btnPesquisarNome.setBackground(new java.awt.Color(51, 51, 51));
        btnPesquisarNome.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnPesquisarNome.setForeground(new java.awt.Color(255, 255, 255));
        btnPesquisarNome.setText("Pesquisar");
        btnPesquisarNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarNomeActionPerformed(evt);
            }
        });
        jPanel1.add(btnPesquisarNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 400, -1, 56));

        txtPesquisaNome.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel1.add(txtPesquisaNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 420, 250, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 790, 810));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtImagemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtImagemMouseClicked

        selecionaImagem();
    }//GEN-LAST:event_txtImagemMouseClicked

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed

        habilitarCampos(true);

    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed

        habilitarCampos(false);
        limpaCampos();

    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed

        if (txtCodigo.getText().isEmpty()) {
            produto = new Produto();
        } else {
            produto.setIdproduto(Integer.parseInt(txtCodigo.getText()));
        }

        produto.setNome(txtNome.getText());
        produto.setQuantidade(Integer.parseInt(txtQuantidade.getText()));
        produto.setPreco(Double.parseDouble(txtPreco.getText()));
        produto.setImagem(imagemSelecionada);
        produto.setObservacao(txtObservacao.getText());

        if (txtCodigo.getText().isEmpty()) {
            if (controllerProduto.controllerCadastrarProduto(produto)) {
                JOptionPane.showMessageDialog(this, "Produto cadastrado com sucesso.", "ATENÇÃO", JOptionPane.INFORMATION_MESSAGE);
                limpaCampos();
                habilitarCampos(false);
                carregaProduto();
            } else {
                JOptionPane.showMessageDialog(this, "erro ao cadastrar produto.", "ERRO", JOptionPane.ERROR_MESSAGE);
            }
        } else {

            int linha = JTProduto.getSelectedRow();
            int codigoProduto = (int) JTProduto.getValueAt(linha, 0);

            Produto existeProduto = controllerProduto.controllerRetonaProduto(codigoProduto);

            if (existeProduto == null) {
                JOptionPane.showMessageDialog(this, "Produto não foi encontrado");
                return;
            }

            byte[] novaImagem = imagemSelecionada != null ? imagemSelecionada : existeProduto.getImagem();
            byte[] imagemAtual = existeProduto.getImagem();

            if (novaImagem != null && imagemAtual != null && Arrays.equals(novaImagem, imagemAtual)) {
                existeProduto.setImagem(imagemAtual);
            } else {
                existeProduto.setImagem(novaImagem);
            }

            existeProduto.setNome(txtNome.getText());
            existeProduto.setQuantidade(Integer.parseInt(txtQuantidade.getText()));
            existeProduto.setPreco(Double.parseDouble(txtPreco.getText()));
            existeProduto.setObservacao(txtObservacao.getText());

            if (controllerProduto.controllerAtualizarProduto(existeProduto)) {
                JOptionPane.showMessageDialog(this, "Produto alterado com sucesso", "ATENÇÃO", JOptionPane.INFORMATION_MESSAGE);
                limpaCampos();
                habilitarCampos(false);
                carregaProduto();
            } else {
                JOptionPane.showMessageDialog(this, "erro ao alterar produto.", "ERRO", JOptionPane.ERROR_MESSAGE);
            }

        }

        imagemSelecionada = null;

    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed

        int linha = JTProduto.getSelectedRow();
        int codigoProduto = (int) JTProduto.getValueAt(linha, 0);

        if (controllerProduto.controllerExcluirProduto(codigoProduto)) {
            JOptionPane.showMessageDialog(this, "Produto excluido com suceso", "ATENÇÃO", JOptionPane.INFORMATION_MESSAGE);
            carregaProduto();
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao excluir produto", "ERRO", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed

        int linha = JTProduto.getSelectedRow();

        if (linha >= 0) {

            int codigoProduto = (int) JTProduto.getValueAt(linha, 0);

            produto = controllerProduto.controllerRetonaProduto(codigoProduto);

            txtCodigo.setText(String.valueOf(produto.getIdproduto()));
            txtNome.setText(produto.getNome());
            txtQuantidade.setText(String.valueOf(produto.getQuantidade()));
            txtPreco.setText(String.valueOf(produto.getPreco()));
            txtObservacao.setText(produto.getObservacao());

            carregaImagemLabel(produto.getImagem());

            habilitarCampos(true);

        } else {
            JOptionPane.showMessageDialog(this, "Erro ao selecionar o produto", "ERRO", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnAlterarActionPerformed

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
            java.util.logging.Logger.getLogger(JFProduto.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFProduto.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFProduto.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFProduto.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFProduto().setVisible(true);
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

    private void habilitarCampos(boolean condicao) {

        txtCodigo.setEnabled(condicao);
        txtNome.setEnabled(condicao);
        txtQuantidade.setEnabled(condicao);
        txtObservacao.setEnabled(condicao);
        txtPreco.setEnabled(condicao);
        txtImagem.setEnabled(condicao);
        btnSalvar.setEnabled(condicao);

    }

    private void limpaCampos() {
        txtCodigo.setText("");
        txtPesquisaNome.setText("");
        txtPreco.setText("");
        txtImagem.setText("");
        txtImagem.setIcon(null);
        txtQuantidade.setText("");
        txtNome.setText("");
        txtObservacao.setText("");
    }

    private void selecionaImagem() {

        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Imgens", "jpg", "jpeg", "png", "gif");
        chooser.setFileFilter(filter);

        int imagemReturn = chooser.showOpenDialog(this);

        if (imagemReturn == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            try {

                FileInputStream fis = new FileInputStream(file);
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                byte[] buffer = new byte[4096];
                int bytesRead;
                while ((bytesRead = fis.read(buffer)) != -1) {
                    baos.write(buffer, 0, bytesRead);
                }
                fis.close();
                imagemSelecionada = baos.toByteArray();

                ImageIcon imagemIcon = new ImageIcon(imagemSelecionada);
                txtImagem.setIcon(imagemIcon);
                txtImagem.setText("");

            } catch (IOException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Erro ao selecionar a imagem", "ERRO", JOptionPane.ERROR_MESSAGE);
            }
        }

    }

    private void carregaImagemLabel(byte[] imagem) {

        try {

            byte[] imagemBytes = imagem;
            System.out.println("imagem carregada" + imagemBytes);

            ImageIcon icon = new ImageIcon(imagemBytes);
            txtImagem.setIcon(icon);
            txtImagem.setText(null);

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao carregar imagem.", "ERRO", JOptionPane.ERROR_MESSAGE);
        }

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable JTProduto;
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnPesquisarNome;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JLabel txtImagem;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextArea txtObservacao;
    private javax.swing.JTextField txtPesquisaNome;
    private javax.swing.JTextField txtPreco;
    private javax.swing.JTextField txtQuantidade;
    // End of variables declaration//GEN-END:variables
}
