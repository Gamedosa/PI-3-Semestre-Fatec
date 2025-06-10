package view;

import controller.ControllerOrcamento;
import controller.ControllerOrcamentoProduto;
import controller.ControllerProduto;
import controller.ControllerUsuario;
import interfaces.ClienteListener;
import interfaces.ProdutoListener;
import java.security.SecureRandom;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Cliente;
import model.Orcamento;
import model.OrcamentoProduto;
import model.Produto;
import model.StatusOrcamento;
import model.Usuario;
import util.Utilitario;

public class JFOrcamento extends javax.swing.JFrame implements ClienteListener, ProdutoListener {

    ControllerOrcamento corc = new ControllerOrcamento();
    Orcamento orc = new Orcamento();
    ArrayList<Orcamento> listaOrc = new ArrayList<>();

    Produto produto = new Produto();
    ControllerProduto controllerProduto = new ControllerProduto();
    ArrayList<Produto> listaProduto = new ArrayList<>();

    Cliente cliente = new Cliente();

    Usuario usuario = new Usuario();
    ControllerUsuario controllerUsuario = new ControllerUsuario();

    OrcamentoProduto orcProduto = new OrcamentoProduto();
    ControllerOrcamentoProduto controllerOP = new ControllerOrcamentoProduto();
    ArrayList<OrcamentoProduto> listaOP = new ArrayList<>();

    private JFSelecaoCliente selecaoClienteFrame;
    private JFSelecaoProduto selecaoProdutoFrame;

    private String nome;

    //Informações do cliente
    private int codigoCliente;

    //Informações do produto
    private int codigoProduto;
    private String nomeProduto;
    private double precoProduto;

    public JFOrcamento(String nomeUsuario) {
        initComponents();
        this.nome = nomeUsuario;
        txtNomeAtendente.setText(nome);
        habilitarCampos(false);
        carregaOrcamento();

        this.selecaoClienteFrame = new JFSelecaoCliente();
        this.selecaoClienteFrame.setClienteListener(this);

        this.selecaoProdutoFrame = new JFSelecaoProduto();
        this.selecaoProdutoFrame.setProdutoListener(this);

        //Código para popular o Jcombobox com informação do Status
        for (StatusOrcamento status : StatusOrcamento.values()) {
            jcStatus.addItem(status.toString());

        }
        Utilitario.adicionarIcone(this);

    }

    private JFOrcamento() {

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnSalvar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        txtN_orcamento = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNomeAtendente = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtNomeCliente = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtNomeProduto = new javax.swing.JTextField();
        dataInicio = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        dataTermino = new com.toedter.calendar.JDateChooser();
        jLabel9 = new javax.swing.JLabel();
        txtQuantidade = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jcStatus = new javax.swing.JComboBox<>();
        btnIncluir = new javax.swing.JButton();
        btnPesquisarProduto = new javax.swing.JButton();
        btnPesquiarCliente = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTOrcamento = new javax.swing.JTable();
        txtValorLiquido = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtPeriodo = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtDesconto = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtValorTotal = new javax.swing.JTextField();
        btnRemoverLinha = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        JTOrcamentoRealizado = new javax.swing.JTable();
        btnNovo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(74, 126, 88));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Gestão de Orçamento");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, -1, -1));

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
        jPanel1.add(btnSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 730, -1, 56));

        btnExcluir.setBackground(new java.awt.Color(51, 51, 51));
        btnExcluir.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnExcluir.setForeground(new java.awt.Color(255, 255, 255));
        btnExcluir.setText("EXCLUIR");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });
        jPanel1.add(btnExcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 730, -1, 56));

        btnAlterar.setBackground(new java.awt.Color(51, 51, 51));
        btnAlterar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnAlterar.setForeground(new java.awt.Color(255, 255, 255));
        btnAlterar.setText("ALTERAR");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAlterar, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 730, 110, 56));

        btnCancelar.setBackground(new java.awt.Color(51, 51, 51));
        btnCancelar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setText("CANCELAR");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 730, -1, 56));

        jTabbedPane1.setForeground(new java.awt.Color(0, 0, 0));
        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jPanel2.setBackground(new java.awt.Color(74, 126, 88));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(74, 126, 88));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Dados do Orçamento:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Código:");
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        txtCodigo.setEditable(false);
        txtCodigo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtCodigo.setEnabled(false);
        jPanel4.add(txtCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, 60, -1));

        txtN_orcamento.setEditable(false);
        txtN_orcamento.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtN_orcamento.setEnabled(false);
        jPanel4.add(txtN_orcamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 30, 90, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Status:");
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 30, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Nome do Atendente:");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        txtNomeAtendente.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtNomeAtendente.setEnabled(false);
        jPanel4.add(txtNomeAtendente, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 70, 380, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Nome do Cliente:");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        txtNomeCliente.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtNomeCliente.setEnabled(false);
        jPanel4.add(txtNomeCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 110, 380, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Data Inicio:");
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, -1, 30));

        txtNomeProduto.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtNomeProduto.setEnabled(false);
        jPanel4.add(txtNomeProduto, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 150, 380, -1));

        dataInicio.setEnabled(false);
        dataInicio.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel4.add(dataInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 190, 130, 30));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Nome do Produto:");
        jPanel4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Data Término:");
        jPanel4.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 190, -1, 30));

        dataTermino.setEnabled(false);
        dataTermino.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel4.add(dataTermino, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 190, 130, 30));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Quantidade:");
        jPanel4.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 200, -1, -1));

        txtQuantidade.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtQuantidade.setEnabled(false);
        jPanel4.add(txtQuantidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 200, 70, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Nº do Orçamento:");
        jPanel4.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 30, -1, -1));

        jcStatus.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jcStatus.setEnabled(false);
        jPanel4.add(jcStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 30, 250, -1));

        btnIncluir.setBackground(new java.awt.Color(51, 51, 51));
        btnIncluir.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnIncluir.setForeground(new java.awt.Color(255, 255, 255));
        btnIncluir.setText("Incluir");
        btnIncluir.setEnabled(false);
        btnIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIncluirActionPerformed(evt);
            }
        });
        jPanel4.add(btnIncluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 80, -1, 80));

        btnPesquisarProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/search.png"))); // NOI18N
        btnPesquisarProduto.setEnabled(false);
        btnPesquisarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarProdutoActionPerformed(evt);
            }
        });
        jPanel4.add(btnPesquisarProduto, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 150, 30, 30));

        btnPesquiarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/search.png"))); // NOI18N
        btnPesquiarCliente.setEnabled(false);
        btnPesquiarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquiarClienteActionPerformed(evt);
            }
        });
        jPanel4.add(btnPesquiarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 110, 30, 30));

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 6, 750, 260));

        JTOrcamento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome", "Preço Unit.", "Quantidade", "Valor Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Double.class, java.lang.Integer.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(JTOrcamento);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 580, 280));

        txtValorLiquido.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel2.add(txtValorLiquido, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 310, 110, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Valor Liquido:");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 280, -1, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Periodo:");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 350, 110, -1));

        txtPeriodo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtPeriodo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPeriodoFocusLost(evt);
            }
        });
        jPanel2.add(txtPeriodo, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 380, 110, -1));

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Desconto:");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 420, 110, -1));

        txtDesconto.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtDesconto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtDescontoFocusLost(evt);
            }
        });
        jPanel2.add(txtDesconto, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 450, 110, -1));

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Valor Total:");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 490, 110, -1));

        txtValorTotal.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jPanel2.add(txtValorTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 520, 110, -1));

        btnRemoverLinha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/delete.png"))); // NOI18N
        btnRemoverLinha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverLinhaActionPerformed(evt);
            }
        });
        jPanel2.add(btnRemoverLinha, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 520, 30, 30));

        jTabbedPane1.addTab("Orçamento", jPanel2);

        jPanel3.setBackground(new java.awt.Color(74, 126, 88));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        JTOrcamentoRealizado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nº do Orçamento", "Nome Cliente", "Nome Atendente", "Valor Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(JTOrcamentoRealizado);

        jPanel3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 750, -1));

        jTabbedPane1.addTab("Lista de Orçamento", jPanel3);

        jPanel1.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 770, 610));

        btnNovo.setBackground(new java.awt.Color(51, 51, 51));
        btnNovo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnNovo.setForeground(new java.awt.Color(255, 255, 255));
        btnNovo.setText("NOVO");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });
        jPanel1.add(btnNovo, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 730, -1, 56));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 790, 810));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed

        habilitarCampos(false);
        limpaCampos();

    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed

        habilitarCampos(true);
        txtN_orcamento.setText(generaCodigo());

    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnPesquiarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquiarClienteActionPerformed

        this.selecaoClienteFrame.setVisible(true);

    }//GEN-LAST:event_btnPesquiarClienteActionPerformed

    private void btnPesquisarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarProdutoActionPerformed

        this.selecaoProdutoFrame.setVisible(true);

    }//GEN-LAST:event_btnPesquisarProdutoActionPerformed

    private void btnIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIncluirActionPerformed

        if (txtQuantidade.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Você deve preencher o campo quantidade", "ATENÇÃO", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        if (produto == null) {
            JOptionPane.showMessageDialog(this, "Selecione um produto antes de incluir no orçamento", "ATENÇÃO", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        DefaultTableModel modelo = (DefaultTableModel) JTOrcamento.getModel();
        double quantidade = Double.parseDouble(txtQuantidade.getText());
        modelo.addRow(new Object[]{
            codigoProduto,
            nomeProduto,
            precoProduto,
            txtQuantidade.getText(),
            quantidade * precoProduto
        });

        somaValorLiquidoProduto();
        calcularTotal();

        txtNomeProduto.setText("");
        txtQuantidade.setText("");

    }//GEN-LAST:event_btnIncluirActionPerformed

    private void txtPeriodoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPeriodoFocusLost

        try {

            txtPeriodo.setText(String.valueOf(calcularPeriodoEmDias(dataInicio.getDate(), dataTermino.getDate())));
            calcularTotal();

        } catch (Exception e) {

            JOptionPane.showMessageDialog(this, "Você deve selecionar as datas.");

        }

    }//GEN-LAST:event_txtPeriodoFocusLost

    private void txtDescontoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDescontoFocusLost

        aplicarDesconto();

    }//GEN-LAST:event_txtDescontoFocusLost

    private void btnRemoverLinhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverLinhaActionPerformed

        int linha = JTOrcamento.getSelectedRow();
        DefaultTableModel modelo = (DefaultTableModel) JTOrcamento.getModel();
        modelo.removeRow(linha);

        somaValorLiquidoProduto();
        calcularTotal();

    }//GEN-LAST:event_btnRemoverLinhaActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed

        int linha = JTOrcamentoRealizado.getSelectedRow();//1 JTOrcamento
        if (linha == -1) {
            JOptionPane.showMessageDialog(this, "Selecione um orçamento para excluir");
            return;
        }

        int idOrcamento = (int) JTOrcamentoRealizado.getValueAt(linha, 0);

        if (corc.controllerExcluirOrcamento(idOrcamento)) {
            JOptionPane.showMessageDialog(this, "Orçamento e produtos associados excluidos com sucesso!");
            carregaOrcamento();//3 esqueci de recarregar a tabela
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao excluir o orçamento e produtos associado. Por favor, tente novamente.");
        }

    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed

        try {
            // Cria um novo objeto de Orcamento
            Orcamento orc = new Orcamento();

            // Configuração das informações do usuário
            String nomeUsuario = txtNomeAtendente.getText();
            Usuario usuario = controllerUsuario.ControllerRetornaUsuarioPeloNome(nomeUsuario);
            orc.setUsuario(usuario);

            // Configuração das informações do cliente
            Cliente cliente = new Cliente();
            cliente.setIdcliente(codigoCliente);
            orc.setCliente(cliente);

            // Obtenção da lista de produtos
            DefaultTableModel modelo = (DefaultTableModel) JTOrcamento.getModel();
            List<Produto> listaProdutos = new ArrayList<>();
            for (int i = 0; i < modelo.getRowCount(); i++) {
                Produto produto = new Produto();

                // Obtendo o ID do produto
                Object idProdutoObj = modelo.getValueAt(i, 0);
                int idProduto = idProdutoObj instanceof Integer ? (int) idProdutoObj : 0;
                produto.setIdproduto(idProduto);

                // Obtendo o preço do produto
                Object precoObj = modelo.getValueAt(i, 2);
                double preco = precoObj instanceof Double ? (double) precoObj : 0.0;
                produto.setPreco(preco);

                //Obtendo a quantidade do produto //Corrigindo Erro do campo quantidade
                Object quantidadeObj = modelo.getValueAt(i, 3);
                int quantidade;
                if (quantidadeObj instanceof Integer) {
                    quantidade = (int) quantidadeObj;
                } else if (quantidadeObj instanceof String) {
                    quantidade = Integer.parseInt((String) quantidadeObj);
                } else {
                    quantidade = 0;
                }
                produto.setQuantidade(quantidade);

                listaProdutos.add(produto);
            }

            orc.setProdutos(listaProdutos);

            // Configuração dos demais campos do orçamento
            orc.setCodigo_orcamento(txtN_orcamento.getText());
            orc.setDataInicio(dataInicio.getDate());
            orc.setDataTermino(dataTermino.getDate());
            orc.setPeriodo(Integer.parseInt(txtPeriodo.getText()));
            orc.setValorLiquido(Double.parseDouble(txtValorLiquido.getText()));
            orc.setValorTotal(Double.parseDouble(txtValorTotal.getText()));
            orc.setDesconto(Double.parseDouble(txtDesconto.getText()));

            // Obtenção do status do orçamento
            String statusSelecionado = (String) jcStatus.getSelectedItem();
            StatusOrcamento status = StatusOrcamento.valueOf(statusSelecionado.toUpperCase());
            orc.setStatus(status);

            // Verifica se é uma inserção ou uma atualização
            boolean sucesso;
            if (txtCodigo.getText().isEmpty()) {
                // Inserção
                sucesso = corc.controllerCadastrarOrcamento(orc);
            } else {
                // Atualização
                orc.setIdorcamento(Integer.parseInt(txtCodigo.getText()));
                sucesso = corc.controllerAtualizarOrcamento(orc);
            }

            // Verificar se o orçamento foi salvo ou atualizado com sucesso
            if (sucesso) {
                JOptionPane.showMessageDialog(this, "Orçamento salvo/atualizado com sucesso!");
                limpaCampos();
                carregaOrcamento();
                habilitarCampos(false);
            } else {
                JOptionPane.showMessageDialog(this, "Erro ao salvar/atualizar o orçamento.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao salvar/atualizar o orçamento. Certifique-se de preencher todos os campos corretamente.", "Erro", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed

        habilitarCampos(true);

        int linha = JTOrcamentoRealizado.getSelectedRow();
        if (linha >= 0) {
            int idOrcamento = (int) JTOrcamentoRealizado.getValueAt(linha, 0);
            Orcamento orcSelecionado = corc.controllerRetornaOrcamento(idOrcamento);

            if (orcSelecionado != null) {

                txtCodigo.setText(String.valueOf(orcSelecionado.getIdorcamento()));
                txtN_orcamento.setText(String.valueOf(orcSelecionado.getCodigo_orcamento()));
                txtNomeAtendente.setText(orcSelecionado.getUsuario().getNome());
                txtNomeCliente.setText(orcSelecionado.getCliente().getNome());

                txtValorLiquido.setText(String.valueOf(orcSelecionado.getValorLiquido()));
                txtValorTotal.setText(String.valueOf(orcSelecionado.getValorTotal()));
                dataInicio.setDate(orcSelecionado.getDataInicio());
                dataTermino.setDate(orcSelecionado.getDataTermino());
                txtPeriodo.setText(String.valueOf(orcSelecionado.getPeriodo()));
                txtDesconto.setText(String.valueOf(orcSelecionado.getDesconto()));

                jcStatus.setSelectedItem(orcSelecionado.getStatus().toString());

                DefaultTableModel modelo = (DefaultTableModel) JTOrcamento.getModel();
                modelo.setNumRows(0);

                List<OrcamentoProduto> listaOP = controllerOP.controllerRetornaOrcamento(orcSelecionado.getIdorcamento());
                for (OrcamentoProduto orcProd : listaOP) {
                    Produto produto = controllerProduto.controllerRetonaProduto(orcProd.getIdproduto());
                    if (produto != null) {
                        double total = orcProd.getProdutoValor() * orcProd.getQuantidade();//aqui
                        modelo.addRow(new Object[]{
                            produto.getIdproduto(),
                            produto.getNome(),
                            orcProd.getProdutoValor(),
                            orcProd.getQuantidade(),
                            total//aqui
                        });
                    }
                }

                somaValorLiquidoProduto();

                jTabbedPane1.setSelectedIndex(0);

            } else {
                JOptionPane.showMessageDialog(this, "Erro ao carregar informações do orçamento");
            }

        } else {
            JOptionPane.showMessageDialog(this, "Selecione um orçamento para alterar");
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
            java.util.logging.Logger.getLogger(JFOrcamento.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFOrcamento.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFOrcamento.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFOrcamento.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFOrcamento().setVisible(true);
            }
        });
    }

    private void carregaOrcamento() {

        listaOrc = corc.listarOrcamento();
        DefaultTableModel modelo = (DefaultTableModel) JTOrcamentoRealizado.getModel();
        modelo.setNumRows(0);

        for (Orcamento orcamento : listaOrc) {
            modelo.addRow(new Object[]{
                orcamento.getIdorcamento(),
                orcamento.getCodigo_orcamento(),
                orcamento.getCliente().getNome(),
                orcamento.getUsuario().getNome(),
                orcamento.getValorTotal()
            });
        }

    }

    private void habilitarCampos(boolean condicao) {

        txtCodigo.setEnabled(condicao);
        txtN_orcamento.setEnabled(condicao);
        txtNomeAtendente.setEnabled(condicao);
        txtNomeCliente.setEnabled(condicao);
        txtNomeProduto.setEnabled(condicao);
        dataInicio.setEnabled(condicao);
        dataTermino.setEnabled(condicao);
        txtQuantidade.setEnabled(condicao);
        txtValorLiquido.setEnabled(condicao);
        txtDesconto.setEnabled(condicao);
        txtValorTotal.setEnabled(condicao);
        txtPeriodo.setEnabled(condicao);
        btnIncluir.setEnabled(condicao);
        btnRemoverLinha.setEnabled(condicao);
        btnPesquiarCliente.setEnabled(condicao);
        btnPesquisarProduto.setEnabled(condicao);
        jcStatus.setEnabled(condicao);
        btnSalvar.setEnabled(condicao);

    }

    private void limpaCampos() {
        txtCodigo.setText("");
        txtN_orcamento.setText("");
        txtNomeCliente.setText("");
        txtNomeProduto.setText("");
        dataInicio.setDate(null);
        dataTermino.setDate(null);
        txtQuantidade.setText("");
        txtValorLiquido.setText("");
        txtDesconto.setText("");
        txtPeriodo.setText("");
        txtValorTotal.setText("");

        DefaultTableModel modelo = (DefaultTableModel) JTOrcamento.getModel();
        modelo.setNumRows(0);
    }

    public static String generaCodigo() {

        String caractere = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        int tamanho_codigo = 6;

        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder(tamanho_codigo);

        for (int i = 0; i < tamanho_codigo; i++) {
            int index = random.nextInt(caractere.length());
            sb.append(caractere.charAt(index));
        }

        return sb.toString();
    }

    private void somaValorLiquidoProduto() {

        double soma = 0;
        int cont = JTOrcamento.getRowCount();
        for (int i = 0; i < cont; i++) {
            Object valorObjeto = JTOrcamento.getValueAt(i, 4);
            if (valorObjeto instanceof Number) { // Verifica se o valor é um número
                soma += ((Number) valorObjeto).doubleValue(); // Converte para double
            }
        }

        txtValorLiquido.setText(String.valueOf(soma));
        aplicarDesconto(); //1
        System.out.println(soma);

    }

    private void aplicarDesconto() {

        try {

            txtValorTotal.setText(String.valueOf(Double.parseDouble(txtValorTotal.getText()) - Double.parseDouble(txtDesconto.getText())));

        } catch (NumberFormatException e) {
        }

    }

    private void calcularTotal() {

        double valor = 0;
        int periodo = 0;

        try {

            valor = Double.parseDouble(txtValorLiquido.getText().trim());

            if (!txtPeriodo.getText().trim().isEmpty()) {
                periodo = Integer.parseInt(txtPeriodo.getText().trim());
            }

            double total = valor * periodo;
            txtValorTotal.setText(String.valueOf(total));

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Entrada invalida.");
        }

    }

    private static long calcularPeriodoEmDias(Date dataInicio, Date dataTermino) {

        //Converter os objetos Date para LocalDate
        LocalDate dataInicioLocal = dataInicio.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate dataTerminoLocal = dataTermino.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        //calular o periodo em dias entre as duas datas
        return ChronoUnit.DAYS.between(dataInicioLocal, dataTerminoLocal);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable JTOrcamento;
    private javax.swing.JTable JTOrcamentoRealizado;
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnIncluir;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnPesquiarCliente;
    private javax.swing.JButton btnPesquisarProduto;
    private javax.swing.JButton btnRemoverLinha;
    private javax.swing.JButton btnSalvar;
    private com.toedter.calendar.JDateChooser dataInicio;
    private com.toedter.calendar.JDateChooser dataTermino;
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
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JComboBox<String> jcStatus;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtDesconto;
    private javax.swing.JTextField txtN_orcamento;
    private javax.swing.JTextField txtNomeAtendente;
    private javax.swing.JTextField txtNomeCliente;
    private javax.swing.JTextField txtNomeProduto;
    private javax.swing.JTextField txtPeriodo;
    private javax.swing.JTextField txtQuantidade;
    private javax.swing.JTextField txtValorLiquido;
    private javax.swing.JTextField txtValorTotal;
    // End of variables declaration//GEN-END:variables

    @Override
    public void clienteSelecionado(Cliente cliente) {

        txtNomeCliente.setText(cliente.getNome());
        codigoCliente = cliente.getIdcliente();

        this.selecaoClienteFrame.setVisible(false);

    }

    @Override
    public void produtoSelecionado(Produto produto) {

        txtNomeProduto.setText(produto.getNome());
        precoProduto = produto.getPreco();
        codigoProduto = produto.getIdproduto();

        nomeProduto = txtNomeProduto.getText();

        this.selecaoProdutoFrame.setVisible(false);

    }
}
