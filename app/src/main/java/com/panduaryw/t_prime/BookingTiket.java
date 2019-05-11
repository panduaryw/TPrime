package com.panduaryw.t_prime;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

/**
 * Created by Ganteng on 4/17/2018.
 */

public class BookingTiket extends AppCompatActivity {
    Button bookingTiket;
    TextView tvKodeTiket,tvAsalTujuan,tvJamBerangkat,tvJamTiba,tvJumlahTiket,tvHargaTotal,tvTanggal,tvJumlah;
    CheckBox checkBoxPemesanan;
    String kodeTiket ;
    String asalTujuan;
    String jamBerangkat ;
    String jamTiba ;
    String harga;
    String jumlahTiket;
    String tglBerangkat;
    int totalHarga;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pesan_tiket);
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        jumlahTiket = prefs.getString("dataJumlahTiket", "1"); //no id: default value
        tglBerangkat = prefs.getString("dataTanggalBerangkat", "1"); //no id: default value
        tvKodeTiket = (TextView) findViewById(R.id.kode_tiket);
        tvAsalTujuan = (TextView) findViewById(R.id.asal_tujuan);
        tvJamBerangkat = (TextView) findViewById(R.id.descJamBerangkat);
        tvJamTiba = (TextView) findViewById(R.id.descJamTiba);
        tvJumlahTiket = (TextView) findViewById(R.id.descJumlahTiket);
        tvHargaTotal = (TextView) findViewById(R.id.descHargaTiket);
        tvTanggal = (TextView) findViewById(R.id.tgl_berangkat);
        checkBoxPemesanan = (CheckBox) findViewById(R.id.checkBoxAgreement);
        Intent i = getIntent();
        kodeTiket = i.getStringExtra("kodeTiket");
        asalTujuan = i.getStringExtra("asalTujuan");
        jamBerangkat = i.getStringExtra("jamBerangkat");
        jamTiba = i.getStringExtra("jamTiba");
        harga = i.getStringExtra("harga");
        totalHarga = Integer.valueOf(harga)*Integer.valueOf(jumlahTiket);
        tvTanggal.setText(tglBerangkat);
        tvJumlahTiket.setText(jumlahTiket);
        tvKodeTiket.setText(kodeTiket);
        tvAsalTujuan.setText(asalTujuan);
        tvJamBerangkat.setText(jamBerangkat);
        tvJamTiba.setText(jamTiba);
        tvHargaTotal.setText(String.valueOf(totalHarga));
        bookingTiket = (Button) findViewById(R.id.btnBooking) ;
        bookingTiket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getDataPemesanan();
                startActivity(new Intent(BookingTiket.this,Pembayaran.class));
            }
        });
    }
    public void getDataPemesanan(){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor pemesanan = prefs.edit();
        pemesanan.putString("kodeTiket",kodeTiket ); //InputString: from the EditText
        pemesanan.putString("asalTujuan", asalTujuan); //InputString: from the EditText
        pemesanan.putString("tglBerangkat", tglBerangkat); //InputString: from the EditText
        pemesanan.putString("jamBerangkat", jamBerangkat); //InputString: from the EditText
        pemesanan.putString("jamTiba", jamTiba); //InputString: from the EditText
        pemesanan.putString("jumlahTiket", jumlahTiket); //InputString: from the EditText
        pemesanan.putInt("hargaTotal", totalHarga); //InputString: from the EditText
        pemesanan.commit();
    }
}
