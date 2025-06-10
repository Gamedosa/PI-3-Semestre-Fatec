package view;

import controller.ControllerCliente;
import interfaces.ClienteListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Cliente;
import util.Utilitario;

public class JFSelecaoCliente extends javax.swing.JFrame {

    ControllerCliente controllerCliente = new ControllerCliente();
    Cliente cliente = new Cliente();
    ArrayList<Cliente> listaCliente = new ArrayList<>();

    private ClienteListener clienteListener;

    public JFSelecaoCliente() {
        initComponents();

        txtPesquisaCPF.setText("");

        carregaCliente();

        Utilitario.adicionarIcone(this);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTCliente = new javax.swing.JTable();
        btnLimpar = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        btnPesquisarCpf = new javax.swing.JButton();
        txtPesquisaCPF = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(74, 126, 88));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        JTCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTClienteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(JTCliente);
        if (JTCliente.getColumnModel().getColumnCount() > 0) {
            JTCliente.getColumnModel().getColumn(0).setMinWidth(30);
            JTCliente.getColumnModel().getColumn(0).setPreferredWidth(30);
            JTCliente.getColumnModel().getColumn(0).setMaxWidth(30);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 640, 330));

        btnLimpar.setBackground(new java.awt.Color(51, 51, 51));
        btnLimpar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnLimpar.setForeground(new java.awt.Color(255, 255, 255));
        btnLimpar.setText("Limpar");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });
        jPanel1.add(btnLimpar, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 30, -1, 56));

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Pesquisar pelo CPF:");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, -1, -1));

        btnPesquisarCpf.setBackground(new java.awt.Color(51, 51, 51));
        btnPesquisarCpf.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnPesquisarCpf.setForeground(new java.awt.Color(255, 255, 255));
        btnPesquisarCpf.setText("Pesquisar");
        btnPesquisarCpf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarCpfActionPerformed(evt);
            }
        });
        jPanel1.add(btnPesquisarCpf, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 30, -1, 56));

        try {
            txtPesquisaCPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtPesquisaCPF.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel1.add(txtPesquisaCPF, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 50, 190, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 660, 560));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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

    private void JTClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTClienteMouseClicked

        int linha = JTCliente.getSelectedRow();
        if (linha != -1 && clienteListener != null) {
            cliente = new Cliente();
            cliente = listaCliente.get(linha);
            clienteListener.clienteSelecionado(cliente);
        }

    }//GEN-LAST:event_JTClienteMouseClicked

    public void setClienteListener(ClienteListener Listener) {
        this.clienteListener = Listener;
    }

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
            java.util.logging.Logger.getLogger(JFSelecaoCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFSelecaoCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFSelecaoCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFSelecaoCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFSelecaoCliente().setVisible(true);
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable JTCliente;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnPesquisarCpf;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JFormattedTextField txtPesquisaCPF;
    // End of variables declaration//GEN-END:variables
}
