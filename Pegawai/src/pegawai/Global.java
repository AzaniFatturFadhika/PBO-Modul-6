/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pegawai;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author DK01PC
 */
public class Global {
    
    public static String id;
    public static String sql;
 
    boolean isEmptyStr(String string) {
        return string == null || string.isEmpty();
    }
    public static int JmlRec(String sql) throws SQLException {
        int n=0;
        java.sql.Connection db = (Connection)KoneksiDB.getKoneksi();
        try (PreparedStatement q = db.prepareStatement(sql)) {
            java.sql.ResultSet rs = q.executeQuery();
            while (rs.next()) {
                n++;
            } // end while
        } // end try
        return n;
    }
} // end Class
