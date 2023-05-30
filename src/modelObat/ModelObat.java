/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelObat;

import databaseObat.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author M S I
 */
public class ModelObat {
    private int idObat;
    private String nama;
    private String jenis;
    private int stok;
    private int harga;
    
    Connection connect = new Connection();

    public int getIDObat() {
        return idObat;
    }

    public void setIObat(int idObat) {
        this.idObat = idObat;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }
    
    public void tambahDataObat() {
        String sql = "INSERT INTO obat(nama, jenis, stok, harga) VALUES(?, ?, ?, ?)";

        try (PreparedStatement eksekusi = connect.getConnection().prepareStatement(sql)) {
            eksekusi.setString(1, getNama());
            eksekusi.setString(2, getJenis());
            eksekusi.setInt(3, getStok());
            eksekusi.setInt(4, getHarga());
            eksekusi.execute();
            JOptionPane.showMessageDialog(null, "Data Obat Berhasil Ditambah");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Data Obat Gagal Ditambah \n" + ex);
        }
    }
    public void hapusDataObat(int id_obat) {
        String sql = "DELETE FROM obat WHERE id_obat = ?";

        try (PreparedStatement eksekusi = connect.getConnection().prepareStatement(sql)) {
            eksekusi.setInt(1, id_obat);
            eksekusi.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Obat Berhasil Dihapus");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Data Obat Gagal Dihapus \n" + ex);
        }
    }
}
