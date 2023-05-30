/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllerObat;

import javax.swing.JOptionPane;
import modelObat.ModelObat;
import viewObat.ViewObat;
import viewObat.ViewTambahObat;

/**
 *
 * @author M S I
 */
public class ControllerObat {
    private ModelObat MTO;
    private ViewTambahObat VTO;
    private ViewObat VO;
    
    public ControllerObat(ViewTambahObat VTO, ViewObat VO){
        this.VTO = VTO;
        this.VO = VO;
    }
    
public void tambah() {
    MTO = new ModelObat();

    String nama = VTO.getTFNama().getText();
    String jenis = VTO.getTFJenis().getText();
    String stokString = VTO.getTFStok().getText();
    String hargaString = VTO.getTFHarga().getText();

        if (nama.isEmpty() || jenis.isEmpty() || stokString.isEmpty() || hargaString.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Semua input harus diisi", "Kesalahan Input", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            int stok = Integer.parseInt(stokString);
            int harga = Integer.parseInt(hargaString);

            MTO.setNama(nama);
            MTO.setJenis(jenis);
            MTO.setStok(stok);
            MTO.setHarga(harga);

            MTO.tambahDataObat();
            bersihkan();
        } catch (NumberFormatException e) {
            // Tangani kesalahan saat parsing Integer dari input stok dan harga
            JOptionPane.showMessageDialog(null, "Input stok dan harga harus berupa angka", "Kesalahan Input", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void hapus() {
        MTO = new ModelObat();

        int selectedRow = VO.getTBObat().getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(null, "Pilih data obat yang akan dihapus", "Kesalahan", JOptionPane.ERROR_MESSAGE);
                return;
            }

        int id_obat = (int) VO.getTBObat().getValueAt(selectedRow, 0);

        int confirm = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin menghapus data obat dengan ID " + id_obat + "?", "Konfirmasi Hapus Data", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            MTO.hapusDataObat(id_obat);
            bersihkan();
        }
    }
    
    public void bersihkan(){
        new ViewObat().setVisible(true);
        VTO.dispose();
    }
    
}
