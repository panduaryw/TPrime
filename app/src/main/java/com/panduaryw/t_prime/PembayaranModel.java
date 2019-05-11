package com.panduaryw.t_prime;

public class PembayaranModel {
    public String user;
    public String kodeTiket;
    public String asalTujuan;
    public PembayaranModel(){}
    public PembayaranModel(String user, String kodeTiket, String asalTujuan, String tglBerangkat, String jamBerangkat, String jamTiba, String jumlahTiket, String hargaTotal, String kodeBooking, String status) {
        this.user = user;
        this.kodeTiket = kodeTiket;
        this.asalTujuan = asalTujuan;
        this.tglBerangkat = tglBerangkat;
        this.jamBerangkat = jamBerangkat;
        this.jamTiba = jamTiba;
        this.jumlahTiket = jumlahTiket;
        this.hargaTotal = hargaTotal;
        this.kodeBooking = kodeBooking;
        this.status = status;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getKodeTiket() {
        return kodeTiket;
    }

    public void setKodeTiket(String kodeTiket) {
        this.kodeTiket = kodeTiket;
    }

    public String getAsalTujuan() {
        return asalTujuan;
    }

    public void setAsalTujuan(String asalTujuan) {
        this.asalTujuan = asalTujuan;
    }

    public String getTglBerangkat() {
        return tglBerangkat;
    }

    public void setTglBerangkat(String tglBerangkat) {
        this.tglBerangkat = tglBerangkat;
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

    public String getJumlahTiket() {
        return jumlahTiket;
    }

    public void setJumlahTiket(String jumlahTiket) {
        this.jumlahTiket = jumlahTiket;
    }

    public String getHargaTotal() {
        return hargaTotal;
    }

    public void setHargaTotal(String hargaTotal) {
        this.hargaTotal = hargaTotal;
    }

    public String getKodeBooking() {
        return kodeBooking;
    }

    public void setKodeBooking(String kodeBooking) {
        this.kodeBooking = kodeBooking;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String tglBerangkat;
    public String jamBerangkat;
    public String jamTiba;
    public String jumlahTiket;
    public String hargaTotal;
    public String kodeBooking;
    public String status;

}
