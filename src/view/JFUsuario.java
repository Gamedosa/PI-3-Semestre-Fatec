package view;

import controller.ControllerPerfilAcesso;
import controller.ControllerUsuario;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.PerfilAcesso;
import model.Usuario;
import util.Utilitario;

public class JFUsuario extends javax.swing.JFrame {

    ControllerUsuario controllerUsuario = new ControllerUsuario();
    Usuario u = new Usuario();
    ArrayList<Usuario> listaUsuario = new ArrayList<>();

    ControllerPerfilAcesso cpa = new ControllerPerfilAcesso();

    public JFUsuario() {
        initComponents();
        habilitarCampos(false);
        carregarUsuarios();

        Utilitario.adicionarIcone(this);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtlogin = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtSenha = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();
        jcTipoAcesso = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTUsuario = new javax.swing.JTable();
        btnSalvar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnNovo = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(74, 126, 88));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Gestão de Usuário");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(122, 25, -1, -1));

        jPanel2.setBackground(new java.awt.Color(74, 126, 88));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)), "Dados do Usuário:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Login:");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));

        txtlogin.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtlogin.setEnabled(false);
        jPanel2.add(txtlogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, 190, -1));

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
        jLabel4.setText("Nome Completo:");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 30, -1, -1));

        txtNome.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtNome.setEnabled(false);
        jPanel2.add(txtNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 30, 260, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Tipo de Acesso:");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

        txtSenha.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtSenha.setEnabled(false);
        jPanel2.add(txtSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 80, 220, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Senha:");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 80, -1, -1));

        jcTipoAcesso.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jcTipoAcesso.setLightWeightPopupEnabled(false);
        jPanel2.add(jcTipoAcesso, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, 130, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 116, 557, 176));

        JTUsuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Nome", "Login", "Perfil de Acesso"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(JTUsuario);
        if (JTUsuario.getColumnModel().getColumnCount() > 0) {
            JTUsuario.getColumnModel().getColumn(0).setMinWidth(30);
            JTUsuario.getColumnModel().getColumn(0).setPreferredWidth(30);
            JTUsuario.getColumnModel().getColumn(0).setMaxWidth(30);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 390, 557, 260));

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
        jPanel1.add(btnSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 310, -1, 56));

        btnCancelar.setBackground(new java.awt.Color(51, 51, 51));
        btnCancelar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setText("CANCELAR");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 310, -1, 56));

        btnNovo.setBackground(new java.awt.Color(51, 51, 51));
        btnNovo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnNovo.setForeground(new java.awt.Color(255, 255, 255));
        btnNovo.setText("NOVO");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });
        jPanel1.add(btnNovo, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 310, -1, 56));

        btnExcluir.setBackground(new java.awt.Color(51, 51, 51));
        btnExcluir.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnExcluir.setForeground(new java.awt.Color(255, 255, 255));
        btnExcluir.setText("EXCLUIR");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });
        jPanel1.add(btnExcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 310, -1, 56));

        btnAlterar.setBackground(new java.awt.Color(51, 51, 51));
        btnAlterar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnAlterar.setForeground(new java.awt.Color(255, 255, 255));
        btnAlterar.setText("ALTERAR");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAlterar, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 310, 110, 56));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 590, 700));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed

        habilitarCampos(true);
        u = new Usuario();
        carregaTipoPerfil(jcTipoAcesso, u);

    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed

        limpaCampos();
        habilitarCampos(false);

    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed

        int linha = JTUsuario.getSelectedRow();
        int codigoUsuario = (int) JTUsuario.getValueAt(linha, 0);

        if (controllerUsuario.controllerExcluirUsuario(codigoUsuario)) {
            JOptionPane.showMessageDialog(this, "Usuario excluído com sucesso!", "ATENÇÃO", JOptionPane.INFORMATION_MESSAGE);
            carregarUsuarios();
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao excluir usuário!", "ERRO", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed

        if (txtCodigo.getText().isEmpty()) {
            u = new Usuario();
        } else {
            u.setIdusuario(Integer.parseInt(txtCodigo.getText()));
        }

        u.setNome(txtNome.getText());
        u.setLogin(txtlogin.getText());
        u.setSenha(txtSenha.getText());

        String tipoPerfil = jcTipoAcesso.getSelectedItem().toString();
        PerfilAcesso perfilAcesso = cpa.ControllerRetornarPerfilAcessoPorTipoDAO(tipoPerfil);

        if (perfilAcesso != null) {
            u.setPerfilAcesso(perfilAcesso);

            if (txtCodigo.getText().isEmpty()) {

                if (controllerUsuario.controllerCadastrarUsuario(u)) {
                    JOptionPane.showMessageDialog(this, "Usuário cadastrado com sucesso", "ATENÇÃO", JOptionPane.INFORMATION_MESSAGE);
                    limpaCampos();
                    habilitarCampos(false);
                    carregarUsuarios();
                } else {
                    JOptionPane.showMessageDialog(this, "Erro ao cadastrar usuário", "ERRO", JOptionPane.ERROR_MESSAGE);
                }

            } else {

                if (controllerUsuario.controllerAtualizarUsuario(u)) {
                    JOptionPane.showMessageDialog(this, "Usuário alterado com sucesso", "ATENÇÃO", JOptionPane.INFORMATION_MESSAGE);
                    limpaCampos();
                    habilitarCampos(false);
                    carregarUsuarios();
                } else {
                    JOptionPane.showMessageDialog(this, "Erro ao alterar usuário", "ERRO", JOptionPane.ERROR_MESSAGE);
                }

            }

        } else {
            JOptionPane.showMessageDialog(this, "Perfil de acesso não encontrado!", "ERRO", JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed

        int linha = JTUsuario.getSelectedRow();
        if (linha >= 0) {
            int codigoUsuario = (int) JTUsuario.getValueAt(linha, 0);
            u = controllerUsuario.ControllerRetornarUsuario(codigoUsuario);

            txtCodigo.setText(String.valueOf(u.getIdusuario()));
            txtNome.setText(u.getNome());
            txtlogin.setText(u.getLogin());
            txtSenha.setText(u.getSenha());
            carregaTipoPerfil(jcTipoAcesso, u);
            habilitarCampos(true);
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um usuário para alterar.", "AVISO", JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_btnAlterarActionPerformed

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
            java.util.logging.Logger.getLogger(JFUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFUsuario().setVisible(true);
            }
        });
    }

    private void habilitarCampos(boolean condicao) {

        txtCodigo.setEnabled(condicao);
        txtNome.setEnabled(condicao);
        txtlogin.setEnabled(condicao);
        txtSenha.setEnabled(condicao);
        jcTipoAcesso.setEnabled(condicao);
        btnSalvar.setEnabled(condicao);

    }

    private void limpaCampos() {
        txtCodigo.setText("");
        txtNome.setText("");
        txtSenha.setText("");
        txtlogin.setText("");
        jcTipoAcesso.removeAllItems();
    }

    private void carregaTipoPerfil(JComboBox<String> combobox, Usuario usuario) {

        combobox.removeAllItems();

        ArrayList<PerfilAcesso> tiposPerfil = cpa.controllerListaPerfilAcessos();

        for (PerfilAcesso tipoPerfil : tiposPerfil) {
            combobox.addItem(tipoPerfil.getTipoPerfil());
        }

        if (u != null && u.getPerfilAcesso() != null) {
            combobox.setSelectedItem(u.getPerfilAcesso().getTipoPerfil());
        }

    }

    private void carregarUsuarios() {

        listaUsuario = controllerUsuario.controllerListaUsuario();

        DefaultTableModel modelo = (DefaultTableModel) JTUsuario.getModel();
        modelo.setNumRows(0);

        int cont = listaUsuario.size();
        for (int i = 0; i < cont; i++) {
            modelo.addRow(new Object[]{
                listaUsuario.get(i).getIdusuario(),
                listaUsuario.get(i).getNome(),
                listaUsuario.get(i).getLogin(),
                listaUsuario.get(i).getPerfilAcesso().getTipoPerfil()
            });
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable JTUsuario;
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> jcTipoAcesso;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtNome;
    private javax.swing.JPasswordField txtSenha;
    private javax.swing.JTextField txtlogin;
    // End of variables declaration//GEN-END:variables
}
