package com.panduaryw.t_prime;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Tagihan extends AppCompatActivity {
    String kodeTiket,jamBerangkat,jamTiba,key,totalTagihan,metode,pemesan;
    TextView tvKodeTiket,tvKodeBooking,tvTotalTagihan,tvMetode,tvPemesan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tagihan);
        tvKodeTiket = (TextView) findViewById(R.id.tvKodeTiket);
        tvKodeBooking = (TextView) findViewById(R.id.tvKodeBooking);
        tvTotalTagihan = (TextView) findViewById(R.id.tvJumlahTagihan);
        tvMetode = (TextView) findViewById(R.id.tvMetodeBayar);
        tvPemesan = (TextView) findViewById(R.id.pemesanTiket);
        Intent i = getIntent();
        key = i.getStringExtra("kodeBooking");
        totalTagihan = i.getStringExtra("hargaTotal");
        metode = i.getStringExtra("metode");
        kodeTiket = i.getStringExtra("kodeTiket");
        pemesan = i.getStringExtra("user");
        tvKodeTiket.setText(kodeTiket);
        tvKodeBooking.setText(key);
        tvPemesan.setText(pemesan);
        tvMetode.setText(metode);
        tvTotalTagihan.setText(totalTagihan);
        finish();

    }
}
