/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package pegawai;

import com.stripbandunk.jwidget.model.DefaultPaginationModel;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DK01PC
 */
public class PegawaiView extends javax.swing.JFrame {

    int kol, baris;
    String ascdes,order;
    private DefaultPaginationModel paginationModel;
    private DefaultTableModel tb = new DefaultTableModel();
    
    /**
     * Creates new form NewJFrame
     */
    public PegawaiView() {
        initComponents();
        tb.addColumn("Id");
        tb.addColumn("NIP");  
        tb.addColumn("Nama");
        tb.addColumn("Jenis Kelamin");         
        tb.addColumn("Jabatan");  
        tb.addColumn("No. Telp"); 
        tb.addColumn("Alamat");
        tb.addColumn("Kota");
        tbData.setModel(tb);
        ascdes =" ASC";
        cbKol.removeAllItems();
        cbKol.addItem("id");
        cbKol.addItem("nama");
        cbKol.addItem("alamat");
 
        cbTampil.removeAllItems();
        cbTampil.addItem("10");
        cbTampil.addItem("20");
        cbTampil.addItem("50");
        cbTampil.addItem("70");
        cbTampil.addItem("100");
        try{
            IsiTabel();
        }catch(SQLException e) {
            System.err.println("koneksi gagal "+ e.getMessage()); //perintah menampilkan error pada koneksi
        }
    }
    
    private void IsiTabel() throws SQLException {
        String tampil = (String)cbTampil.getSelectedItem();
        String f = (String)cbKol.getSelectedItem();
        order = " ORDER BY " + f + ascdes ;
        Global.sql="Select * FROM r_pegawai WHERE id <> '' ";
        KosongTabel();
        String cari = txtCari.getText();
        String sql =Global.sql;
        if (!cari.isEmpty()) {
            sql = sql + " AND ( id like '%" + cari + "%' ";
            sql = sql + " OR nip like '%" + cari + "%' ";
            sql = sql + " OR nama like '%" + cari + "%' ";
            sql = sql + " OR sex like '%" + cari + "%' ";
            sql = sql + " OR jabatan like '%" + cari + "%' ";
            sql = sql + " OR hp like '%" + cari + "%' ";
            sql = sql + " OR alamat like '%" + cari + "%' ";
            sql = sql + " OR kota like '%" + cari + "%' ) ";
        }
        Global.sql = sql + order;
        paginationModel = new DefaultPaginationModel();
        paginationModel.setTotalItem(Global.JmlRec(Global.sql));
        //Mengeset jumlah record untuk satu halaman
        int n = Integer.parseInt(tampil);        
        paginationModel.setPageSize(n);
        Halaman.setModel(paginationModel); 
 
        sql = Global.sql + " limit " + n;
        Pegawai.baca_data(tb,Global.sql + " limit " + n);
        System.out.println(sql);

    }
        
    private void KosongTabel(){
        baris = tb.getRowCount();
        for (int i=0; i < baris; i++ ) {
            tb.removeRow(0);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbData = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnTampil = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtCari = new javax.swing.JTextField();
        btnCari = new javax.swing.JButton();
        Halaman = new com.stripbandunk.jwidget.JPagination();
        btnDelete = new javax.swing.JButton();
        cbKol = new javax.swing.JComboBox<>();
        btnAsc = new javax.swing.JButton();
        btnDesc = new javax.swing.JButton();
        cbTampil = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tbData.setModel(new javax.swing.table.DefaultTableModel(
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
        tbData.setName(""); // NOI18N
        tbData.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbDataMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbData);

        jLabel1.setText("Tampil");

        btnTampil.setText("Go!");
        btnTampil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTampilActionPerformed(evt);
            }
        });

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        jLabel2.setText("Cari");

        btnCari.setText("Go!");
        btnCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariActionPerformed(evt);
            }
        });

        Halaman.addPaginationListener(new com.stripbandunk.jwidget.listener.PaginationListener() {
            public void onPageChange(com.stripbandunk.jwidget.event.PaginationEvent evt) {
                HalamanOnPageChange(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnAsc.setText("Acs");
        btnAsc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAscActionPerformed(evt);
            }
        });

        btnDesc.setText("Desc");
        btnDesc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDescActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 663, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnAdd)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnEdit)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnDelete))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(18, 18, 18)
                                        .addComponent(cbTampil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnTampil)
                                        .addGap(0, 0, 0)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2)
                                .addGap(12, 12, 12)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(cbKol, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnAsc))
                                    .addComponent(txtCari))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnDesc)
                                    .addComponent(btnCari))))
                        .addGap(19, 19, 19))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(Halaman, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(229, 229, 229))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(btnTampil)
                            .addComponent(cbTampil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnAsc)
                                .addComponent(btnDesc))
                            .addComponent(cbKol, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnEdit)
                    .addComponent(jLabel2)
                    .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCari)
                    .addComponent(btnDelete))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Halaman, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTampilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTampilActionPerformed
        // TODO add your handling code here:
        try {
            IsiTabel();
        } catch (SQLException ex) {
            //
        }
    }//GEN-LAST:event_btnTampilActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        new AddPegawai().setVisible(true);
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // TODO add your handling code here:
        new EditPegawai().setVisible(true);
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariActionPerformed
        // TODO add your handling code here:
        try {
            IsiTabel();
        } catch (SQLException ex) {
            //
        }
    }//GEN-LAST:event_btnCariActionPerformed

    private void HalamanOnPageChange(com.stripbandunk.jwidget.event.PaginationEvent evt) {//GEN-FIRST:event_HalamanOnPageChange
        // TODO add your handling code here:
        // digunakan untuk mengeset limit pada query DB
        int limit = (evt.getCurrentPage() - 1) * evt.getPageSize();
        //contoh query
        String sql ="SELECT * FROM r_pegawai LIMIT " + limit + ", " + evt.getPageSize();
        System.out.println(sql);
        try {
            KosongTabel();
            Pegawai.baca_data(tb,sql);
        } catch (SQLException ex) {
        }
    }//GEN-LAST:event_HalamanOnPageChange

    
    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        new DeletePegawai().setVisible(true);
        
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void tbDataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbDataMouseClicked
        // TODO add your handling code here:
        int klik = evt.getClickCount();
        baris = tbData.getSelectedRow();
        kol = tbData.getSelectedColumn();
 
        Object id = tbData.getValueAt(baris, 0);
        Global.id = id.toString();
    }//GEN-LAST:event_tbDataMouseClicked

    private void btnAscActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAscActionPerformed
        // TODO add your handling code here:
        ascdes = " ASC";
        try {
            IsiTabel();
        } catch (SQLException ex) {
            //
        }
    }//GEN-LAST:event_btnAscActionPerformed

    private void btnDescActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDescActionPerformed
        // TODO add your handling code here:
        ascdes = " DESC";
        try {
            IsiTabel();
        } catch (SQLException ex) {
            //
        }
    }//GEN-LAST:event_btnDescActionPerformed

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PegawaiView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PegawaiView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PegawaiView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PegawaiView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PegawaiView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.stripbandunk.jwidget.JPagination Halaman;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnAsc;
    private javax.swing.JButton btnCari;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnDesc;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnTampil;
    private javax.swing.JComboBox<String> cbKol;
    private javax.swing.JComboBox<String> cbTampil;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbData;
    private javax.swing.JTextField txtCari;
    // End of variables declaration//GEN-END:variables
}
