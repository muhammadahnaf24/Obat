/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllerObat;

import modelObat.ModelTambahObat;
import viewObat.ViewObat;
import viewObat.ViewTambahObat;

/**
 *
 * @author M S I
 */
public class ControllerTambahObat {
    private ModelTambahObat MTO;
    private ViewTambahObat VTO;
    
    public ControllerTambahObat (ViewTambahObat VTO){
        this.VTO = VTO;
    }
    
    public void tambah(){
        MTO = new ModelTambahObat();
        MTO.setNama(VTO.getTFNama().getText());
        MTO.setJenis(VTO.getTFJenis().getText());
        MTO.setStok(Integer.parseInt(VTO.getTFStok().getText()));
        MTO.setHarga(Integer.parseInt(VTO.getTFHarga().getText()));
        
        MTO.tambahDataObat();
        bersihkan();
    }
    
    public void bersihkan(){
        new ViewObat().setVisible(true);
        VTO.dispose();
    }
    
}
