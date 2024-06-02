/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pegawai;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author DK01PC
 */

public class KoneksiDB {
    private static Connection koneksi;
 
    public static Connection getKoneksi(){
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver()); 
            String url="jdbc:mysql://localhost:3306/pegawai"; //url database
            String user="root"; //user database
            String pass=""; //password database
            koneksi=DriverManager.getConnection(url, user, pass); 
            System.out.println("Berhasil Koneksi");
        } catch (SQLException e) {
            System.err.println("koneksi gagal "+ e.getMessage()); //perintah menampilkan error pada koneksi
        }
        return koneksi;
    } 

}
