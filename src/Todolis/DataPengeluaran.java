/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Todolis;

import java.sql.*; // mengimpor class untuk penggunaan JDBC Driver.
import javax.swing.JOptionPane; // mengimpor class untuk mengambil input, menampilkan informasi, 
//menampilkan pesan error, menampilkan dialog konfirmasi, dll.
import javax.swing.table.DefaultTableModel; //mengimpor class untuk memberikan header dan data pada kolom dan baris tabel
import java.util.Scanner; //mengimpor Scanner ke program.
import java.awt.*; //Mengimpor Class untuk perancangan user-interface dan event-handling
/**
 * @author Ravenclaw
 */
public class DataPengeluaran extends javax.swing.JFrame { //class inheritance
    DefaultTableModel tabModel; //DefaultTableModel Mendeklarasikan variabel yang digunakan 
    //untuk memberikan header dan data pada kolom dan baris tabel
    ResultSet RsPengeluaran=null; //Resulset merupakan sebuah interface dimana RsPengeluaran
    //digunakan untuk menyimpan data dari hasil query SQL.
    
    public DataPengeluaran() {  //bagian constructor
        initComponents();
        
        // fungsi untuk memposisikan JFrame di tengah layar
        setLocationRelativeTo(this);
        
        
        //fungsi Tampil data dan set edit off dijalankan saat aplikasi di run
        tampilData();
        SetEditOff();
    }
    
    //fungsi untuk menampilkan data pengeluaran ke dalam tabel
    private void tampilData(){
        try{
            Object[] judul_kolom = {"Id Pengeluaran", "Jenis Pengeluaran", "Jumlah Pengeluaran", "Deskripsi Pengeluaran","Tanggal Pengeluaran"};
            tabModel=new DefaultTableModel(null,judul_kolom);
            TabelPengeluaran.setModel(tabModel);
            
            Connection conn=(Connection)koneksi.koneksiDB(); //Deklarasi Variable Connection
            Statement stt=conn.createStatement(); //Deklarasi Variable Statement
            tabModel.getDataVector().removeAllElements();
            
            RsPengeluaran=stt.executeQuery("SELECT * from pengeluaran "); //mengambil semua data dari tabel pengeluarn.
            while(RsPengeluaran.next()){ /*perulangan While Untuk mengambil data dari objek ResultSet
                metode next() akan terus berulang sampai tidak ditemukannya baris.*/
                Object[] data={
                    /* pada kode ini metode getString() digunakan untuk mengambil satu 
                    record dari tabel database sebagai sebuah String. */
                    RsPengeluaran.getString("IDPengeluaran"),
                    RsPengeluaran.getString("Jenis_pengeluaran"),
                    RsPengeluaran.getString("Jumlah_pengeluaran"),
                    RsPengeluaran.getString("Deskripsi_pengeluaran"),
                    RsPengeluaran.getString("CreateDate")         
                };
               tabModel.addRow(data);
            }                
        } catch (Exception ex) {
        System.err.println(ex.getMessage());
        }
        // disable button
        //pengesetan pada tombol agar tombol tidak aktif.
        jButtonSave.setEnabled(false);
        jButtonUpdate.setEnabled(false);
        jButtonDelete.setEnabled(false);
        jButtonCancel.setEnabled(false);
    }
   
    //menampilkan data ke form saat data pada tabel di klik 
   void tblKeForm(){
        txtid.setText(tabModel.getValueAt(TabelPengeluaran.getSelectedRow(),0)+"");
        txtjen.setText(tabModel.getValueAt(TabelPengeluaran.getSelectedRow(),1)+"");
        txtjum.setText(tabModel.getValueAt(TabelPengeluaran.getSelectedRow(),2)+"");
        txtdes.setText(tabModel.getValueAt(TabelPengeluaran.getSelectedRow(),3)+"");
        
        //pengesetan agar tombol update, delete, cancel aktif. Dan tombol Save tidak aktif.
        jButtonUpdate.setEnabled(true);
        jButtonDelete.setEnabled(true);
        jButtonCancel.setEnabled(true);
        jButtonSave.setEnabled(false);
    }
   
   //membersihkan form
   private void BersihData(){
        txtid.setText("");
        txtjen.setText("");
        txtjum.setText("");
        txtdes.setText("");
    } 
   
   //disable form
   //pengesetan pada tombol agar tombol tidak aktif.
   private void SetEditOff(){
        txtid.setEnabled(false);
        txtjen.setEnabled(false);
        txtjum.setEnabled(false);
        txtdes.setEnabled(false);
   }
   
   //pengesetan pada tombol agar tombol aktif.
   private void seteditOn(){
        txtid.setEnabled(true);
        txtjen.setEnabled(true);
        txtjum.setEnabled(true);
        txtdes.setEnabled(true);
   }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelHeader = new javax.swing.JLabel();
        jLabelKodeProduk = new javax.swing.JLabel();
        txtid = new javax.swing.JTextField();
        jLabelNama = new javax.swing.JLabel();
        txtjen = new javax.swing.JTextField();
        jLabelSatuan = new javax.swing.JLabel();
        jLabelHarga = new javax.swing.JLabel();
        jButtonAdd = new javax.swing.JButton();
        jButtonSave = new javax.swing.JButton();
        jButtonUpdate = new javax.swing.JButton();
        jButtonDelete = new javax.swing.JButton();
        jButtonCancel = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabelPengeluaran = new javax.swing.JTable();
        txtjum = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtdes = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Team Ravenclaw");
        setBackground(new java.awt.Color(255, 255, 204));

        jLabelHeader.setBackground(new java.awt.Color(255, 153, 51));
        jLabelHeader.setFont(new java.awt.Font("SimSun", 1, 24)); // NOI18N
        jLabelHeader.setForeground(new java.awt.Color(255, 255, 255));
        jLabelHeader.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelHeader.setText("Catatan Pengeluaran Harian Ku");
        jLabelHeader.setOpaque(true);

        jLabelKodeProduk.setText("Id Pengeluaran");

        txtid.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidActionPerformed(evt);
            }
        });

        jLabelNama.setText("Jenis Pengeluaran");

        txtjen.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabelSatuan.setText("Jumlah Pengeluaran");

        jLabelHarga.setText("Deskripsi Pengeluaran");

        jButtonAdd.setBackground(new java.awt.Color(0, 153, 51));
        jButtonAdd.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButtonAdd.setForeground(new java.awt.Color(255, 255, 255));
        jButtonAdd.setText("AddNew");
        jButtonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddActionPerformed(evt);
            }
        });

        jButtonSave.setBackground(new java.awt.Color(0, 153, 51));
        jButtonSave.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButtonSave.setForeground(new java.awt.Color(255, 255, 255));
        jButtonSave.setText("Save");
        jButtonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveActionPerformed(evt);
            }
        });

        jButtonUpdate.setBackground(new java.awt.Color(0, 153, 51));
        jButtonUpdate.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButtonUpdate.setForeground(new java.awt.Color(255, 255, 255));
        jButtonUpdate.setText("Update");
        jButtonUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUpdateActionPerformed(evt);
            }
        });

        jButtonDelete.setBackground(new java.awt.Color(204, 0, 0));
        jButtonDelete.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButtonDelete.setForeground(new java.awt.Color(255, 255, 255));
        jButtonDelete.setText("Delete");
        jButtonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteActionPerformed(evt);
            }
        });

        jButtonCancel.setBackground(new java.awt.Color(204, 0, 0));
        jButtonCancel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButtonCancel.setForeground(new java.awt.Color(255, 255, 255));
        jButtonCancel.setText("Reset");
        jButtonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelActionPerformed(evt);
            }
        });

        TabelPengeluaran.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        TabelPengeluaran.setModel(new javax.swing.table.DefaultTableModel(
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
        TabelPengeluaran.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabelPengeluaranMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TabelPengeluaran);

        txtjum.setText("Rp. ");
        txtjum.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtjum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtjumActionPerformed(evt);
            }
        });

        txtdes.setColumns(20);
        txtdes.setRows(5);
        txtdes.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jScrollPane2.setViewportView(txtdes);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabelNama, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabelHarga)
                                .addComponent(jLabelKodeProduk)
                                .addComponent(jLabelSatuan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jButtonAdd))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtjen, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtjum, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jButtonSave)
                                .addGap(32, 32, 32)
                                .addComponent(jButtonUpdate)
                                .addGap(30, 30, 30)
                                .addComponent(jButtonDelete)
                                .addGap(30, 30, 30)
                                .addComponent(jButtonCancel)))
                        .addGap(0, 300, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabelHeader, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelKodeProduk))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtjen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelNama))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelSatuan)
                    .addComponent(txtjum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabelHarga))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAdd)
                    .addComponent(jButtonSave)
                    .addComponent(jButtonUpdate)
                    .addComponent(jButtonDelete)
                    .addComponent(jButtonCancel))
                .addGap(49, 49, 49))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    //menangani proses saat button add di klik
    private void jButtonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddActionPerformed
        // TODO add your handling code here:
        BersihData();
        txtid.requestFocus(); //fungsi agar pada saat form data tampil, cursor di posisi text input id.
        jButtonSave.setEnabled(true); //pengesetan agar tombol save aktif.
        jButtonUpdate.setEnabled(false); //pengesetan agar tombol update tidak aktif. 
        jButtonDelete.setEnabled(false); //pengesetan agar tombol delete tidak aktif.
        seteditOn();
    }//GEN-LAST:event_jButtonAddActionPerformed

    //menangani proses saat button save di klik
    private void jButtonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveActionPerformed
        // TODO add your handling code here:
        String IDPengeluaran=txtid.getText();
        String Jenis_pengeluaran=txtjen.getText();
        String Jumlah_pengeluaran=txtjum.getText();
        String Deskripsi_pengeluaran=txtdes.getText();

        java.util.Date tanggal = new java.util.Date();
        java.text.SimpleDateFormat TanggalFormat= new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String CreateDate=TanggalFormat.format(tanggal);

        if (IDPengeluaran.isEmpty() ) {
            JOptionPane.showMessageDialog(null,"ID Pengeluaran tidak boleh kosong");
            txtid.requestFocus(); //fungsi agar cursor dapat di arahkan pada posisi text input id.
        }else if (Jenis_pengeluaran.isEmpty()) {
            JOptionPane.showMessageDialog(null,"Jenis Pengeluaran tidak boleh kosong");
            txtjen.requestFocus(); //fungsi agar cursor dapat di arahkan pada posisi text input jenis pengeluaran.
        }else if (Jumlah_pengeluaran.isEmpty()) {
            JOptionPane.showMessageDialog(null,"Jumlah Pengeluaran tidak boleh kosong");
            txtjum.requestFocus(); //fungsi agar cursor dapat di arahkan pada posisi text input jumlah pengeluaran.
       }else if (!(new Scanner(Jumlah_pengeluaran).hasNextInt())) {
            JOptionPane.showMessageDialog(null,"Jumlah Pengeluaran harus angka");
            txtjum.requestFocus(); //fungsi agar cursor dapat di arahkan pada posisi text input jumlah pengeluaran.
        }else{
            try{
                Connection conn=(Connection)koneksi.koneksiDB(); //pengkoneksian database dari java class koneksi.
                Statement stt=conn.createStatement(); //Object createStatement digunakan untuk pengiriman statement SQL dengan atau tanpa parameter.
                stt.executeUpdate("insert into pengeluaran(IDPengeluaran,Jenis_pengeluaran,Jumlah_pengeluaran,Deskripsi_pengeluaran,CreateDate)"+
                    "VALUES('"+IDPengeluaran+"','"+Jenis_pengeluaran+"','"+Jumlah_pengeluaran+"','"+Deskripsi_pengeluaran+"','"+CreateDate+"')");
                BersihData();
                tampilData();
                SetEditOff();
                JOptionPane.showMessageDialog(this,"Data berhasil disimpan","Success",JOptionPane.INFORMATION_MESSAGE);
            } catch(SQLException e){
                JOptionPane.showMessageDialog(this,"Simpan data gagal\n"+e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
            }
        }

    }//GEN-LAST:event_jButtonSaveActionPerformed

    //menangani proses saat button Update di klik
    private void jButtonUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUpdateActionPerformed
        // TODO add your handling code here:
        String IDPengeluaran=txtid.getText();
        String Jenis_pengeluaran=txtjen.getText();
        String Jumlah_pengeluaran=txtjum.getText();
        String Deskripsi_pengeluaran=txtdes.getText();
        java.util.Date tanggal = new java.util.Date(); //penerapan fungsi penanggalan.
        java.text.SimpleDateFormat TanggalFormat= new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String CreateDate=TanggalFormat.format(tanggal);

       if (IDPengeluaran.isEmpty() ) {
            JOptionPane.showMessageDialog(null,"ID Pengeluaran tidak boleh kosong");
            txtid.requestFocus(); //fungsi agar cursor dapat di arahkan pada posisi text input id.
        }else if (Jenis_pengeluaran.isEmpty()) {
            JOptionPane.showMessageDialog(null,"Jenis Pengeluaran tidak boleh kosong");
            txtjen.requestFocus(); // fungsi agar cursor dapat di arahkan pada posisi text input jenis pengeluaran.
        }else if (Jumlah_pengeluaran.isEmpty()) {
            JOptionPane.showMessageDialog(null,"Jumlah Pengeluaran tidak boleh kosong");
            txtjum.requestFocus(); //fungsi agar cursor dapat di arahkan pada posisi text input jumlah pengeluaran.
        }else if (Deskripsi_pengeluaran.isEmpty()) {
            JOptionPane.showMessageDialog(null,"Deskripsi Pengeluaran tidak boleh kosong");
            txtdes.requestFocus(); //fungsi agar cursor dapat di arahkan pada posisi text input deskripsi pengeluaran.
        }else if (!(new Scanner(Jumlah_pengeluaran).hasNextInt())) {
            JOptionPane.showMessageDialog(null,"Jumlah Pengeluaran harus angka");
            txtjum.requestFocus(); //fungsi agar cursor dapat di arahkan pada posisi text input jumlah pengeluaran.
        }else{
            try{
                Connection conn=(Connection)koneksi.koneksiDB(); //pengkoneksian database dari java class koneksi.
                Statement stt=conn.createStatement(); //Object createStatement digunakan untuk pengiriman statement SQL dengan atau tanpa parameter.
                stt.executeUpdate("UPDATE pengeluaran SET Jenis_pengeluaran='"+Jenis_pengeluaran+"', Jumlah_pengeluaran='"+Jumlah_pengeluaran+"', Deskripsi_pengeluaran='"+Deskripsi_pengeluaran+"' WHERE IDPengeluaran='"+IDPengeluaran+"'");
                BersihData();
                tampilData();
                SetEditOff();
                JOptionPane.showMessageDialog(this,"Data berhasil diubah","Success",JOptionPane.INFORMATION_MESSAGE);
            } catch(SQLException e){
                JOptionPane.showMessageDialog(this,"Ubah data gagal\n"+e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
            }
        }

    }//GEN-LAST:event_jButtonUpdateActionPerformed

    //menangani proses saat button delete di klik
    private void jButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteActionPerformed
        // TODO add your handling code here:
        String IDPengeluaran=txtid.getText();

        if (IDPengeluaran.isEmpty() ) {
            JOptionPane.showMessageDialog(null,"ID Pengeluaran tidak boleh kosong");
            txtid.requestFocus(); // fungsi agar cursor dapat di arahkan pada posisi text input id.
        }else if(JOptionPane.showConfirmDialog(null,"Apakah anda yakin akan menghapus data ini?",
            "Informasi",JOptionPane.OK_CANCEL_OPTION,JOptionPane.INFORMATION_MESSAGE)==JOptionPane.OK_OPTION){
        try{
            Connection conn=(Connection)koneksi.koneksiDB(); //pengkoneksian database dari java class koneksi.
            Statement stt=conn.createStatement(); //Object createStatement digunakan untuk pengiriman statement SQL dengan atau tanpa parameter.
            stt.executeUpdate("DELETE FROM pengeluaran WHERE IDPengeluaran='"+IDPengeluaran+"'");
            BersihData();
            tampilData();
            SetEditOff();
            JOptionPane.showMessageDialog(this,"Data berhasil di hapus","Success",JOptionPane.INFORMATION_MESSAGE);
        } catch(SQLException e){
            JOptionPane.showMessageDialog(this,"Delete data gagal\n"+e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
        }
    }//GEN-LAST:event_jButtonDeleteActionPerformed

    //menangani proses saat button cancel di klik
    private void jButtonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelActionPerformed
        // TODO add your handling code here:
        BersihData();
        jButtonSave.setEnabled(false); //pengesetan agar tombol save tidak aktif.
        jButtonUpdate.setEnabled(false); //pengesetan agar tombol udate tidak aktif.
        jButtonDelete.setEnabled(false); //pengesetan agar tombol delete tidak aktif.
        SetEditOff();
    }//GEN-LAST:event_jButtonCancelActionPerformed

    //menangani proses saat tabel pengeluaran di klik
    private void TabelPengeluaranMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelPengeluaranMouseClicked
        // TODO add your handling code here:
        seteditOn();
        txtid.setEnabled(false); //pengesetan agar id tidak dapat diisi.
        tblKeForm();
    }//GEN-LAST:event_TabelPengeluaranMouseClicked

    private void txtjumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtjumActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtjumActionPerformed

    private void txtidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) { /*   String[]args merupakan parameter berupa array dengan 
        tipe data String yang digunakan agar fungsi main() dikenali dan dapat dieksekusi.  */
        
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
            java.util.logging.Logger.getLogger(DataPengeluaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DataPengeluaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DataPengeluaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DataPengeluaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DataPengeluaran().setVisible(true); //setVisible(true) untuk mengatur Class menjadi Terlihat
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TabelPengeluaran;
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JButton jButtonCancel;
    private javax.swing.JButton jButtonDelete;
    private javax.swing.JButton jButtonSave;
    private javax.swing.JButton jButtonUpdate;
    private javax.swing.JLabel jLabelHarga;
    private javax.swing.JLabel jLabelHeader;
    private javax.swing.JLabel jLabelKodeProduk;
    private javax.swing.JLabel jLabelNama;
    private javax.swing.JLabel jLabelSatuan;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea txtdes;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtjen;
    private javax.swing.JTextField txtjum;
    // End of variables declaration//GEN-END:variables
}
