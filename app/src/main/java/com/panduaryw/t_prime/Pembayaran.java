package com.panduaryw.t_prime;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Random;

/**
 * Created by Ganteng on 4/17/2018.
 */

public class Pembayaran extends AppCompatActivity{
    String kodeTiket,asalTujuan,jamBerangkat,jamTiba,jumlahTiket,tglBerangkat,key,user,totalTagihan;
    int totalHarga;
    FirebaseAuth firebaseAuth ; //inisiasi variable
    FirebaseUser firebaseUser;
    DatabaseReference databaseReferences;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.metode_pembayaran);
        firebaseAuth = FirebaseAuth.getInstance(); //referensi variable
        firebaseUser = firebaseAuth.getCurrentUser(); //referensi variable
        databaseReferences = FirebaseDatabase.getInstance().getReference("pemesanan");
    }
    public void generateKey(){
        this.key = generateRandomChars(
                "1234567890", 9);
    }

    public static String generateRandomChars(String candidateChars, int length) {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            sb.append(candidateChars.charAt(random.nextInt(candidateChars
                    .length())));
        }

        return sb.toString();
    }
    public void bni(View view) {
        generateKey();
        user = firebaseUser.getEmail().toString();
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(view.getContext());
        kodeTiket = prefs.getString("kodeTiket", "1"); //no id: default value
        asalTujuan = prefs.getString("asalTujuan", "1"); //no id: default value
        tglBerangkat = prefs.getString("tglBerangkat", "1"); //no id: default value
        jamBerangkat = prefs.getString("jamBerangkat", "1"); //no id: default value
        jamTiba = prefs.getString("jamTiba", "1"); //no id: default value
        jumlahTiket = prefs.getString("jumlahTiket", "1"); //no id: default value
        totalHarga = prefs.getInt("hargaTotal",1);
        totalTagihan = String.valueOf(totalHarga);
        PembayaranModel pembayaranModel = new PembayaranModel(user,kodeTiket,asalTujuan,tglBerangkat,jamBerangkat,jamTiba,jumlahTiket,totalTagihan,key,"BELUM LUNAS");
        databaseReferences.child(key).setValue(pembayaranModel);
        Intent intent = new Intent(Pembayaran.this, Tagihan.class);
        intent.putExtra("user",this.user);
        intent.putExtra("kodeTiket",this.kodeTiket);
        intent.putExtra("asalTujuan",this.asalTujuan);
        intent.putExtra("tglBerangkat",this.tglBerangkat);
        intent.putExtra("jamBerangkat",this.jamBerangkat);
        intent.putExtra("metode","BNI");
        intent.putExtra("jamTiba",this.jamTiba);
        intent.putExtra("jumlahTiket",this.jumlahTiket);
        intent.putExtra("hargaTotal",this.totalTagihan);
        intent.putExtra("kodeBooking",this.key);
        startActivity(intent);
    }

    public void mandiri(View view) {
        generateKey();
        user = firebaseUser.getEmail().toString();
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(view.getContext());
        kodeTiket = prefs.getString("kodeTiket", "1"); //no id: default value
        asalTujuan = prefs.getString("asalTujuan", "1"); //no id: default value
        tglBerangkat = prefs.getString("tglBerangkat", "1"); //no id: default value
        jamBerangkat = prefs.getString("jamBerangkat", "1"); //no id: default value
        jamTiba = prefs.getString("jamTiba", "1"); //no id: default value
        jumlahTiket = prefs.getString("jumlahTiket", "1"); //no id: default value
        totalHarga = prefs.getInt("hargaTotal",1);
        totalTagihan = String.valueOf(totalHarga);
        PembayaranModel pembayaranModel = new PembayaranModel(user,kodeTiket,asalTujuan,tglBerangkat,jamBerangkat,jamTiba,jumlahTiket,totalTagihan,key,"BELUM LUNAS");
        databaseReferences.child(key).setValue(pembayaranModel);
        Intent intent = new Intent(Pembayaran.this, Tagihan.class);
        intent.putExtra("user",this.user);
        intent.putExtra("kodeTiket",this.kodeTiket);
        intent.putExtra("asalTujuan",this.asalTujuan);
        intent.putExtra("tglBerangkat",this.tglBerangkat);
        intent.putExtra("jamBerangkat",this.jamBerangkat);
        intent.putExtra("metode","MANDIRI");
        intent.putExtra("jamTiba",this.jamTiba);
        intent.putExtra("jumlahTiket",this.jumlahTiket);
        intent.putExtra("hargaTotal",this.totalTagihan);
        intent.putExtra("kodeBooking",this.key);
        startActivity(intent);
    }

    public void bca(View view) {
        generateKey();
        user = firebaseUser.getEmail().toString();
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(view.getContext());
        kodeTiket = prefs.getString("kodeTiket", "1"); //no id: default value
        asalTujuan = prefs.getString("asalTujuan", "1"); //no id: default value
        tglBerangkat = prefs.getString("tglBerangkat", "1"); //no id: default value
        jamBerangkat = prefs.getString("jamBerangkat", "1"); //no id: default value
        jamTiba = prefs.getString("jamTiba", "1"); //no id: default value
        jumlahTiket = prefs.getString("jumlahTiket", "1"); //no id: default value
        totalHarga = prefs.getInt("hargaTotal",1);
        totalTagihan = String.valueOf(totalHarga);
        PembayaranModel pembayaranModel = new PembayaranModel(user,kodeTiket,asalTujuan,tglBerangkat,jamBerangkat,jamTiba,jumlahTiket,totalTagihan,key,"BELUM LUNAS");
        databaseReferences.child(key).setValue(pembayaranModel);
        Intent intent = new Intent(Pembayaran.this, Tagihan.class);
        intent.putExtra("user",this.user);
        intent.putExtra("kodeTiket",this.kodeTiket);
        intent.putExtra("asalTujuan",this.asalTujuan);
        intent.putExtra("tglBerangkat",this.tglBerangkat);
        intent.putExtra("jamBerangkat",this.jamBerangkat);
        intent.putExtra("metode","BCA");
        intent.putExtra("jamTiba",this.jamTiba);
        intent.putExtra("jumlahTiket",this.jumlahTiket);
        intent.putExtra("hargaTotal",this.totalTagihan);
        intent.putExtra("kodeBooking",this.key);
        startActivity(intent);
    }

    public void indomaret(View view) {
        generateKey();
        user = firebaseUser.getEmail().toString();
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(view.getContext());
        kodeTiket = prefs.getString("kodeTiket", "1"); //no id: default value
        asalTujuan = prefs.getString("asalTujuan", "1"); //no id: default value
        tglBerangkat = prefs.getString("tglBerangkat", "1"); //no id: default value
        jamBerangkat = prefs.getString("jamBerangkat", "1"); //no id: default value
        jamTiba = prefs.getString("jamTiba", "1"); //no id: default value
        jumlahTiket = prefs.getString("jumlahTiket", "1"); //no id: default value
        totalHarga = prefs.getInt("hargaTotal",1);
        totalTagihan = String.valueOf(totalHarga);
        PembayaranModel pembayaranModel = new PembayaranModel(user,kodeTiket,asalTujuan,tglBerangkat,jamBerangkat,jamTiba,jumlahTiket,totalTagihan,key,"BELUM LUNAS");
        databaseReferences.child(key).setValue(pembayaranModel);
        Intent intent = new Intent(Pembayaran.this, Tagihan.class);
        intent.putExtra("user",this.user);
        intent.putExtra("kodeTiket",this.kodeTiket);
        intent.putExtra("asalTujuan",this.asalTujuan);
        intent.putExtra("tglBerangkat",this.tglBerangkat);
        intent.putExtra("jamBerangkat",this.jamBerangkat);
        intent.putExtra("metode","S");
        intent.putExtra("jamTiba",this.jamTiba);
        intent.putExtra("jumlahTiket",this.jumlahTiket);
        intent.putExtra("hargaTotal",this.totalTagihan);
        intent.putExtra("kodeBooking",this.key);
        startActivity(intent);
    }

    public void alfa(View view) {
        generateKey();
        user = firebaseUser.getEmail().toString();
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(view.getContext());
        kodeTiket = prefs.getString("kodeTiket", "1"); //no id: default value
        asalTujuan = prefs.getString("asalTujuan", "1"); //no id: default value
        tglBerangkat = prefs.getString("tglBerangkat", "1"); //no id: default value
        jamBerangkat = prefs.getString("jamBerangkat", "1"); //no id: default value
        jamTiba = prefs.getString("jamTiba", "1"); //no id: default value
        jumlahTiket = prefs.getString("jumlahTiket", "1"); //no id: default value
        totalHarga = prefs.getInt("hargaTotal",1);
        totalTagihan = String.valueOf(totalHarga);
        PembayaranModel pembayaranModel = new PembayaranModel(user,kodeTiket,asalTujuan,tglBerangkat,jamBerangkat,jamTiba,jumlahTiket,totalTagihan,key,"BELUM LUNAS");
        databaseReferences.child(key).setValue(pembayaranModel);
        Intent intent = new Intent(Pembayaran.this, Tagihan.class);
        intent.putExtra("user",this.user);
        intent.putExtra("kodeTiket",this.kodeTiket);
        intent.putExtra("asalTujuan",this.asalTujuan);
        intent.putExtra("tglBerangkat",this.tglBerangkat);
        intent.putExtra("jamBerangkat",this.jamBerangkat);
        intent.putExtra("metode","Alfamart");
        intent.putExtra("jamTiba",this.jamTiba);
        intent.putExtra("jumlahTiket",this.jumlahTiket);
        intent.putExtra("hargaTotal",this.totalTagihan);
        intent.putExtra("kodeBooking",this.key);
        startActivity(intent);
    }
}
