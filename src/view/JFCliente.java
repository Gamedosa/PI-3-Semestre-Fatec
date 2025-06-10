package view;

import controller.ControllerCliente;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Cliente;
import util.Utilitario;

public class JFCliente extends javax.swing.JFrame {

    ControllerCliente controllerCliente = new ControllerCliente();
    Cliente cliente = new Cliente();
    ArrayList<Cliente> listaCliente = new ArrayList<>();

    public JFCliente() {
        initComponents();
        habilitarCampos(false);
        carregaCliente();

        Utilitario.adicionarIcone(this);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jcUF = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtCelular = new javax.swing.JFormattedTextField();
        jLabel8 = new javax.swing.JLabel();
        txtCep = new javax.swing.JFormattedTextField();
        jLabel9 = new javax.swing.JLabel();
        txtRua = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtNumero = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtComplemento = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtBairro = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtCidade = new javax.swing.JTextField();
        txtCpf = new javax.swing.JFormattedTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTCliente = new javax.swing.JTable();
        btnSalvar = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        btnNovo = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        btnPesquisarCpf = new javax.swing.JButton();
        txtPesquisaCPF = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(74, 126, 88));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Gestão de Cliente");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, -1, -1));

        jPanel2.setBackground(new java.awt.Color(74, 126, 88));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)), "Dados do Cliente:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("CPF:");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 30, -1, -1));

        txtEmail.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtEmail.setEnabled(false);
        jPanel2.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, 310, -1));

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
        jLabel5.setText("UF:");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 180, -1, -1));

        jcUF.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jcUF.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MG", "MS", "MT", "PA", "PB", "PE", "PI", "PR", "RJ", "RN", "RO", "RR", "SC", "SE", "SP", "TO" }));
        jcUF.setEnabled(false);
        jcUF.setLightWeightPopupEnabled(false);
        jPanel2.add(jcUF, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 180, 70, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("E-mail:");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Número do Celular:");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 80, -1, -1));

        try {
            txtCelular.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCelular.setEnabled(false);
        txtCelular.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel2.add(txtCelular, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 80, 170, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("CEP:");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));

        try {
            txtCep.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCep.setEnabled(false);
        txtCep.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtCep.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCepKeyPressed(evt);
            }
        });
        jPanel2.add(txtCep, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, 140, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Rua:");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 130, -1, -1));

        txtRua.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtRua.setEnabled(false);
        jPanel2.add(txtRua, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 130, 310, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Número:");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 130, -1, -1));

        txtNumero.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtNumero.setEnabled(false);
        jPanel2.add(txtNumero, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 130, 110, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Complemento:");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, -1));

        txtComplemento.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtComplemento.setEnabled(false);
        jPanel2.add(txtComplemento, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, 120, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Bairro:");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 180, -1, -1));

        txtBairro.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtBairro.setEnabled(false);
        jPanel2.add(txtBairro, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 180, 120, -1));

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Cidade:");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 180, -1, -1));

        txtCidade.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtCidade.setEnabled(false);
        jPanel2.add(txtCidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 180, 140, -1));

        try {
            txtCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCpf.setEnabled(false);
        txtCpf.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel2.add(txtCpf, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 30, 150, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 750, 230));

        JTCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Nome", "CPF", "E-mail", "Nº Celular"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(JTCliente);
        if (JTCliente.getColumnModel().getColumnCount() > 0) {
            JTCliente.getColumnModel().getColumn(0).setMinWidth(30);
            JTCliente.getColumnModel().getColumn(0).setPreferredWidth(30);
            JTCliente.getColumnModel().getColumn(0).setMaxWidth(30);
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
        jPanel1.add(btnLimpar, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 400, -1, 56));

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
        jLabel14.setText("Pesquisar pelo CPF:");
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

        btnPesquisarCpf.setBackground(new java.awt.Color(51, 51, 51));
        btnPesquisarCpf.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnPesquisarCpf.setForeground(new java.awt.Color(255, 255, 255));
        btnPesquisarCpf.setText("Pesquisar");
        btnPesquisarCpf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarCpfActionPerformed(evt);
            }
        });
        jPanel1.add(btnPesquisarCpf, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 400, -1, 56));

        try {
            txtPesquisaCPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtPesquisaCPF.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel1.add(txtPesquisaCPF, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 420, 190, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 790, 810));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed

        habilitarCampos(true);

    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed

        if (txtCodigo.getText().isEmpty()) {
            cliente = new Cliente();
        } else {
            cliente.setIdcliente(Integer.parseInt(txtCodigo.getText()));
        }

        cliente.setNome(txtNome.getText());
        cliente.setCpf(txtCpf.getText());
        cliente.setCelular(txtCelular.getText());
        cliente.setEmail(txtEmail.getText());
        cliente.setCep(txtCep.getText());
        cliente.setLogradouro(txtRua.getText());
        cliente.setNumero(txtNumero.getText());
        cliente.setComplemento(txtComplemento.getText());
        cliente.setBairro(txtBairro.getText());
        cliente.setLocalidade(txtCidade.getText());
        cliente.setUf(jcUF.getSelectedItem().toString());

        if (txtCodigo.getText().isEmpty()) {
            //Inserindo usuário
            if (controllerCliente.controllerCadastrarCliente(cliente)) {
                JOptionPane.showMessageDialog(this, "Cliente Cadastrado com sucesso", "ATENÇÃO", JOptionPane.INFORMATION_MESSAGE);
                carregaCliente();
                limpaCampos();
                habilitarCampos(false);
            } else {
                JOptionPane.showMessageDialog(this, "Erro ao cadastrar cliente", "ERRO", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            //Atualizando cliente
            if (controllerCliente.controllerAtualizarCliente(cliente)) {
                JOptionPane.showMessageDialog(this, "Cliente alterado com sucesso", "ATENÇÃO", JOptionPane.INFORMATION_MESSAGE);
                carregaCliente();
                limpaCampos();
                habilitarCampos(false);
            } else {
                JOptionPane.showMessageDialog(this, "Erro ao alterar cliente", "ERRO", JOptionPane.ERROR_MESSAGE);
            }
        }


    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed

        int linha = JTCliente.getSelectedRow();
        int codigoCliente = (int) JTCliente.getValueAt(linha, 0);

        if (controllerCliente.controllerExcluirCliente(codigoCliente)) {
            JOptionPane.showMessageDialog(this, "Cliente excluido com sucesso!", "ATENÇÃO", JOptionPane.INFORMATION_MESSAGE);
            carregaCliente();
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao excluir cliente", "ERRO", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed

        habilitarCampos(true);

        int linha = JTCliente.getSelectedRow();
        if (linha >= 0) {
            int codigoCliente = (int) JTCliente.getValueAt(linha, 0);
            cliente = controllerCliente.controllerRetornaCliente(codigoCliente);
            txtCodigo.setText(String.valueOf(cliente.getIdcliente()));
            txtNome.setText(cliente.getNome());
            txtCpf.setText(cliente.getCpf());//Erro
            txtEmail.setText(cliente.getEmail());
            txtCelular.setText(cliente.getCelular());
            txtCep.setText(cliente.getCep());
            txtRua.setText(cliente.getLogradouro());
            txtNumero.setText(cliente.getNumero());
            txtComplemento.setText(cliente.getComplemento());
            txtBairro.setText(cliente.getBairro());
            txtCidade.setText(cliente.getLocalidade());
            jcUF.setSelectedItem(cliente.getUf());
        }

    }//GEN-LAST:event_btnAlterarActionPerformed

    private void txtCepKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCepKeyPressed

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {

            Utilitario util = new Utilitario();

            Cliente cliente = util.buscarEndereco(txtCep.getText());
            txtRua.setText(cliente.getLogradouro());
            txtBairro.setText(cliente.getBairro());
            txtCidade.setText(cliente.getLocalidade());
            jcUF.setSelectedItem(cliente.getUf());

        }

    }//GEN-LAST:event_txtCepKeyPressed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed

        limpaCampos();
        habilitarCampos(false);

    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnPesquisarCpfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarCpfActionPerformed

        String cpfPesquisa = txtPesquisaCPF.getText().trim();
        List<Cliente> listaCliente = new ArrayList<>();

        DefaultTableModel modelo = (DefaultTableModel) JTCliente.getModel();
        modelo.setNumRows(0);

        if (!cpfPesquisa.isEmpty()) {
            listaCliente = controllerCliente.controllerRetornarClientePorCpf(cpfPesquisa);
            if (listaCliente.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Nenhum cliente encontro com o CPF informado", "ATENÇÃO", JOptionPane.INFORMATION_MESSAGE);
                carregaCliente();
            } else {

                for (Cliente cliente : listaCliente) {
                    modelo.addRow(new Object[]{
                        cliente.getIdcliente(),
                        cliente.getNome(),
                        cliente.getCpf(),
                        cliente.getEmail(),
                        cliente.getCelular()
                    });
                }

            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, informe o CPF para pesquisa", "ATENÇÃO", JOptionPane.INFORMATION_MESSAGE);
        }

    }//GEN-LAST:event_btnPesquisarCpfActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed

        txtPesquisaCPF.setText("");
        carregaCliente();

    }//GEN-LAST:event_btnLimparActionPerformed

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
            java.util.logging.Logger.getLogger(JFCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFCliente().setVisible(true);
            }
        });
    }

    private void carregaCliente() {

        listaCliente = controllerCliente.controllerListaCliente();
        DefaultTableModel modelo = (DefaultTableModel) JTCliente.getModel();
        modelo.setNumRows(0);

        int cont = listaCliente.size();
        for (int i = 0; i < cont; i++) {
            modelo.addRow(new Object[]{
                listaCliente.get(i).getIdcliente(),
                listaCliente.get(i).getNome(),
                listaCliente.get(i).getCpf(),
                listaCliente.get(i).getEmail(),
                listaCliente.get(i).getCelular()
            });
        }

    }

    private void habilitarCampos(boolean condicao) {

        txtCodigo.setEnabled(condicao);
        txtNome.setEnabled(condicao);
        txtCpf.setEnabled(condicao);
        txtEmail.setEnabled(condicao);
        txtCelular.setEnabled(condicao);
        txtCep.setEnabled(condicao);
        txtRua.setEnabled(condicao);
        txtNumero.setEnabled(condicao);
        txtComplemento.setEnabled(condicao);
        txtBairro.setEnabled(condicao);
        txtCidade.setEnabled(condicao);
        jcUF.setEnabled(condicao);
        btnSalvar.setEnabled(condicao);

    }

    private void limpaCampos() {
        txtCodigo.setText("");
        txtNome.setText("");
        txtCpf.setText("");
        txtEmail.setText("");
        txtCelular.setText("");
        txtCep.setText("");
        txtRua.setText("");
        txtNumero.setText("");
        txtComplemento.setText("");
        txtBairro.setText("");
        txtCidade.setText("");
        txtPesquisaCPF.setText("");
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable JTCliente;
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnPesquisarCpf;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> jcUF;
    private javax.swing.JTextField txtBairro;
    private javax.swing.JFormattedTextField txtCelular;
    private javax.swing.JFormattedTextField txtCep;
    private javax.swing.JTextField txtCidade;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtComplemento;
    private javax.swing.JFormattedTextField txtCpf;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtNumero;
    private javax.swing.JFormattedTextField txtPesquisaCPF;
    private javax.swing.JTextField txtRua;
    // End of variables declaration//GEN-END:variables
}
