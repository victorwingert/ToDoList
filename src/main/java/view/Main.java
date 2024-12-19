package view;

import controller.GerenciavelController;
import controller.EditController;
import controller.TableController;
import controller.VerController;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Main extends javax.swing.JFrame {

    private TableController tableController = new TableController();
    private GerenciavelController gerenciavelController;
    private EditController editController;
    private VerController verController;
    private AddPessoal addDialogPessoal;
    private AddProfissional addDialogProfissional;
    private EditPessoal editDialogPessoal;
    private EditProfissional editDialogProfissional;
    private TipoTarefa tipoTarefa;
    private VerPessoal verPessoal;
    private VerProfissional verProfissional;

    public Main() {
        initComponents();
        configureTable();
        updateTable();

        tipoTarefa = new TipoTarefa(this, true);

        gerenciavelController = new GerenciavelController(this);
        addDialogPessoal = new AddPessoal(this, true, gerenciavelController);
        addDialogProfissional = new AddProfissional(this, true, gerenciavelController);

        editController = new EditController(this);
        editDialogPessoal = new EditPessoal(this, true, editController);
        editDialogProfissional = new EditProfissional(this, true, editController);

        verController = new VerController(this);
        verPessoal = new VerPessoal(this, true, verController);
        verProfissional = new VerProfissional(this, true, verController);
    }

    public VerPessoal getVerPessoal() {
        return verPessoal;
    }

    public VerProfissional getVerProfissional() {
        return verProfissional;
    }

    public void configureTable() {
        DefaultTableModel model = new DefaultTableModel(
                new Object[][]{},
                new String[]{"ID", "Nome", "Categoria", "Prioridade", "Status"}
        );
        jTable.setModel(model);
    }

    public void updateTable() {
        DefaultTableModel model = (DefaultTableModel) jTable.getModel();
        model.setRowCount(0);
        tableController.populateTable("tarefas_base.csv", model);
    }

    public JTable getjTable() {
        return jTable;
    }

    public EditPessoal getEditDialog() {
        return editDialogPessoal;
    }

    public void addBase() {
        addDialogPessoal.setLocationRelativeTo(this);
        addDialogPessoal.setVisible(true);
    }

    public void addProfissional() {
        addDialogProfissional.setLocationRelativeTo(this);
        addDialogProfissional.setVisible(true);
    }

    public TipoTarefa getTipoTarefa() {
        return tipoTarefa;
    }

    private void ver() {
        int selectedRow = jTable.getSelectedRow();

        if (selectedRow != -1) {
            DefaultTableModel model = (DefaultTableModel) jTable.getModel();
            String categoria = model.getValueAt(selectedRow, 2).toString();

            if (categoria.equals("Pessoal")) {
                verPessoal.setLocationRelativeTo(this);
                verPessoal.getVerController().fillLabelsPessoal();
            } else {
                verProfissional.setLocationRelativeTo(this);
                verProfissional.getVerController().fillLabelsProfissional();
            }
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "Nenhuma linha selecionada!", "Erro", javax.swing.JOptionPane.ERROR_MESSAGE);

        }
    }

    private void editar() {
        int selectedRow = jTable.getSelectedRow();

        if (selectedRow != -1) {
            DefaultTableModel model = (DefaultTableModel) jTable.getModel();
            String categoria = model.getValueAt(selectedRow, 2).toString();

            if (categoria.equals("Pessoal")) {
                editDialogPessoal.setLocationRelativeTo(this);
                editDialogPessoal.getEditController().fillFieldsFromSelectedRowPessoal(editDialogPessoal);
            } else {
                editDialogProfissional.setLocationRelativeTo(this);
                editDialogProfissional.getEditController().fillFieldsFromSelectedRowProfissional(editDialogProfissional);
            }
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "Nenhuma linha selecionada!", "Erro", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }

    public EditProfissional getEditDialogProfissional() {
        return editDialogProfissional;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        botoes = new javax.swing.JPanel();
        add = new javax.swing.JButton();
        remove = new javax.swing.JButton();
        edit = new javax.swing.JButton();
        ver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane.setViewportView(jTable);

        botoes.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 40, 5));

        add.setText("Adicionar");
        add.setPreferredSize(new java.awt.Dimension(90, 30));
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });
        botoes.add(add);

        remove.setText("Remover");
        remove.setPreferredSize(new java.awt.Dimension(90, 30));
        remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeActionPerformed(evt);
            }
        });
        botoes.add(remove);

        edit.setText("Editar");
        edit.setPreferredSize(new java.awt.Dimension(90, 30));
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
            }
        });
        botoes.add(edit);

        ver.setText("Ver");
        ver.setPreferredSize(new java.awt.Dimension(90, 30));
        ver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verActionPerformed(evt);
            }
        });
        botoes.add(ver);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(100, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
                    .addComponent(botoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(100, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(botoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(100, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        tipoTarefa.setLocationRelativeTo(this);
        tipoTarefa.setVisible(true);
        if (tipoTarefa.getTipoTarefa() == 1) {
            addBase();
        }
        if (tipoTarefa.getTipoTarefa() == 2)
            addProfissional();
        else
            tipoTarefa.dispose();
    }//GEN-LAST:event_addActionPerformed

    private void removeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeActionPerformed
        gerenciavelController.remover();
    }//GEN-LAST:event_removeActionPerformed

    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed
        editar();
    }//GEN-LAST:event_editActionPerformed

    private void verActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verActionPerformed
        ver();
    }//GEN-LAST:event_verActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Main mainFrame = new Main();
                mainFrame.setVisible(true);
                mainFrame.setLocationRelativeTo(null);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private javax.swing.JPanel botoes;
    private javax.swing.JButton edit;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JTable jTable;
    private javax.swing.JButton remove;
    private javax.swing.JButton ver;
    // End of variables declaration//GEN-END:variables
}
