/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Todolis;

import java.sql.*; // mengimpor class untuk penggunaan JDBC Driver.
import javax.swing.JOptionPane; /* mengimpor class untuk mengambil input, menampilkan informasi, 
menampilkan pesan error, menampilkan dialog konfirmasi, dll. */
/**
 *
 * @author Ravenclaw
 */
public class koneksi {
    private static Connection KoneksiDatabse; //pendefenisian objek KoneksiDatabase.
    public static Connection koneksiDB() throws SQLException { //deklarasi function koneksiDB() dan untuk exception handling.
        try {
            String DB ="jdbc:mysql://localhost/ravenclaw"; //pengkoneksian pada database mysql ravenclaw.
            String user="root"; // username yang digunakan untuk mengakses database
            String pass=""; //tidak ada password yang digunakan untuk mengakses database.
            DriverManager.registerDriver(new com.mysql.jdbc.Driver()); // load driver
            KoneksiDatabse = (Connection) DriverManager.getConnection(DB,user,pass); /* menghubungkan database dengan 
            method getConnection menggunakan atribut yang telah di definisikan */
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Tidak ada koneksi","Error", //pesan informasi saat tidak terkoneksi pada database.
            JOptionPane.INFORMATION_MESSAGE);
            System.err.println(e.getMessage()); //Perintah untuk menampilkan Pesan Error jika eksekusi Gagal atau ada yang salah.
            System.exit(0); //Perintah untuk keluar dari system.
        }
         return KoneksiDatabse;
    }
}
