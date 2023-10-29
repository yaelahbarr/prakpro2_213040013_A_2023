/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pertemuan7;

/**
 *
 * @author wdead
 */
public class Latihan7TableModel{
    
    // Mendeklarasikan variabel-variabel 
    private String nama;
    private String jenisKelamin;
    private String noHp;
    private String alamat;

    // Konstruktor
    public Latihan7TableModel(String nama, String jenisKelamin, String noHp, String alamat) {
        // Nilai-nilai yang diterima dari parameter diatributkan ke variabel anggota objek
        this.nama = nama;
        this.jenisKelamin = jenisKelamin;
        this.noHp = noHp;
        this.alamat = alamat;
    }

    // Metode getNama()
    public String getNama() {
        return nama;
    }

    // Metode getJenisKelamin()
    public String getJenisKelamin() {
        return jenisKelamin;
    }

    // Metode getNoHp()
    public String getNoHp() {
        return noHp;
    }

    // Metode getAlamat()
    public String getAlamat() {
        return alamat;
    }

    // Metode setNama(String nama)
    public void setNama(String nama) {
        this.nama = nama;
    }

    // Metode setJenisKelamin(String jenisKelamin)
    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    // Metode setNoHp(String noHp)
    public void setNoHp(String noHp) {
        this.noHp = noHp;
    }

    // Metode setAlamat(String alamat)
    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
    
}
