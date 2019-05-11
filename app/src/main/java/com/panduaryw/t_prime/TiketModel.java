package com.panduaryw.t_prime;

public class TiketModel {
    private String kodeTiket;
    private String jamBerangkat;
    private String jamTiba;
    private String sisaKursi;
    private String harga;

    public String getKodeTiket() {
        return kodeTiket;
    }

    public void setKodeTiket(String kodeTiket) {
        this.kodeTiket = kodeTiket;
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
