/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pegawai;

import java.sql.ResultSet;
import java.sql.* ;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DK01PC
 */

public class Pegawai extends Data{
    private String id;
    private String nip;
    private String hp;
    private String jabatan;

    public Pegawai(String id, String nip, String nama, String sex, String hp, String jabatan, String alamat, String kota) {
        super(nama, nip, alamat, sex, kota);
        this.id = id;
        this.hp = hp;
        this.nip = nip;
        this.jabatan = jabatan;
    }

    @Override 
    public void info() {
        System.out.println("ID " + getId());
        System.out.println("Nama " + getNama());
        System.out.println("Alamat " + getAlamat());
        System.out.println("Kota " + getKota());
    }
    
    public static void view_data(Pegawai pegawai, String id) throws SQLException {
        java.sql.Connection db=(Connection)KoneksiDB.getKoneksi();
        String sql = "SELECT * FROM r_pegawai Where id = '" + id + "' " ;
        try (PreparedStatement q = db.prepareStatement(sql)) {
            ResultSet rs = q.executeQuery();
            while (rs.next()) {
                pegawai.setId(id);
                pegawai.setNip(rs.getString("nip"));
                pegawai.setNama(rs.getString("nama"));
                pegawai.setSex(rs.getString("sex"));
                pegawai.setHp(rs.getString("hp"));                
                pegawai.setJabatan(rs.getString("jabatan"));
                pegawai.setAlamat(rs.getString("alamat"));
                pegawai.setKota(rs.getString("kota"));
            } // end while
        } // end try // end try
    }

    public static void baca_data(DefaultTableModel tb, String sql) throws SQLException {
        java.sql.Connection db=(Connection)KoneksiDB.getKoneksi();
        try (PreparedStatement q = db.prepareStatement(sql)) {
            ResultSet rs = q.executeQuery();
            while (rs.next()) {
                tb.addRow(new Object[]{
                    rs.getString("id"),
                    rs.getString("nip"),
                    rs.getString("nama"),
                    rs.getString("sex"),
                    rs.getString("hp"),
                    rs.getString("jabatan"),
                    rs.getString("alamat"),
                    rs.getString("kota"),
                });
            } // end while
        }// end try 
    }// end baca_data
 
    public static void Add(Pegawai pegawai) throws SQLException {
        java.sql.Connection db=(Connection)KoneksiDB.getKoneksi();
        String sql = "INSERT INTO r_pegawai (id, nip, nama, sex, hp, jabatan, alamat, kota) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement q = db.prepareStatement(sql)) {
            q.setString(1, pegawai.getId());           
            q.setString(2, pegawai.getNip());
            q.setString(3, pegawai.getNama());
            q.setString(4, pegawai.getSex());
            q.setString(5, pegawai.getHp());
            q.setString(6, pegawai.getJabatan());
            q.setString(7, pegawai.getAlamat());
            q.setString(8, pegawai.getKota());
            
            q.executeUpdate();
        }
    } 
    
    public static void Edit(Pegawai pegawai) throws SQLException {
        java.sql.Connection db=(Connection)KoneksiDB.getKoneksi();
        String sqledit = "UPDATE r_pegawai SET nip = ?, nama = ?, sex = ?, hp = ?, jabatan = ?, alamat = ?, kota = ? WHERE id ='" + pegawai.getId()+"'";
        try (PreparedStatement q = db.prepareStatement(sqledit)) {
            q.setString(1, pegawai.getNip());
            q.setString(2, pegawai.getNama());            
            q.setString(3, pegawai.getSex());
            q.setString(4, pegawai.getHp());
            q.setString(5, pegawai.getJabatan());
            q.setString(6, pegawai.getAlamat());
            q.setString(7, pegawai.getKota());
            q.executeUpdate();
        }
    } 
    
    public static boolean Del(String id) throws SQLException {
        java.sql.Connection db=(Connection)KoneksiDB.getKoneksi();
        boolean tf;
        String sql = "DELETE FROM r_pegawai WHERE id = '" + id + "' ";
        try (PreparedStatement q = db.prepareStatement(sql)) {
            int efek = q.executeUpdate();
            if (efek > 0) {
                tf=true;
            } else {
                tf=false;
            }
        }
        return tf;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the nip
     */
    public String getNip() {
        return nip;
    }

    /**
     * @param nip the nip to set
     */
    public void setNip(String nip) {
        this.nip = nip;
    }

    /**
     * @return the hp
     */
    public String getHp() {
        return hp;
    }

    /**
     * @param hp the hp to set
     */
    public void setHp(String hp) {
        this.hp = hp;
    }

    /**
     * @return the jabatan
     */
    public String getJabatan() {
        return jabatan;
    }

    /**
     * @param jabatan the jabatan to set
     */
    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
    }

}

