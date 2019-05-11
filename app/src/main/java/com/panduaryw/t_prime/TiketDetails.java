package com.panduaryw.t_prime;

public class TiketDetails {
    private String kode_tiket;
    private String jamBerangkat;
    private String jamTiba;
    private String sisaKursi;
    private String harga;
    private String asal_tujuan;
    private String jumlah;
    private String tanggal;
    public String getAsal_tujuan() {
        return asal_tujuan;
    }

    public void setAsal_tujuan(String asal_tujuan) {
        this.asal_tujuan = asal_tujuan;
    }

    public String getJumlah() {
        return jumlah;
    }

    public void setJumlah(String jumlah) {
        this.jumlah = jumlah;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getKode_tiket() {
        return kode_tiket;
    }

    public void setKode_tiket(String kode_tiket) {
        this.kode_tiket = kode_tiket;
    }

    public String getJamBerangkat() {
        return jamBerangkat;
    }

    public void setJamBerangkat(String jamBerangkat) {
        this.jamBerangkat = jamBerangkat;
    }

    public String getJamTiba() {
        return jamTiba;
    }

    public void setJamTiba(String jamTiba) {
        this.jamTiba = jamTiba;
    }

    public String getSisaKursi() {
        return sisaKursi;
    }

    public void setSisaKursi(String sisaKursi) {
        this.sisaKursi = sisaKursi;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }
}
