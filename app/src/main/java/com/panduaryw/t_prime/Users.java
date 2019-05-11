package com.panduaryw.t_prime;

/**
 * Created by Reza Effendy on 22/03/2018.
 */

public class Users {
    private String nama;
    private String username;
    private String password;
    private String alamat;
    private String noHp;
    private String noIdentitas;

    public Users(){}

    public Users(String name, String user, String pass, String alamat, String hape, String identitas) {
        this.nama = name;
        this.username = user;
        this.password = pass;
        this.alamat = alamat;
        this.noHp = hape;
        this.noIdentitas = identitas;
    }


    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNoHp() {
        return noHp;
    }

    public void setNoHp(String noHp) {
        this.noHp = noHp;
    }

    public String getNoIdentitas() {
        return noIdentitas;
    }

    public void setNoIdentitas(String noIdentitas) {
        this.noIdentitas = noIdentitas;
    }

}
