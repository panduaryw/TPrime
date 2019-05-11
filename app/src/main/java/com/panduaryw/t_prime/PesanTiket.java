package com.panduaryw.t_prime;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class PesanTiket extends AppCompatActivity {
    Spinner poolAsal,poolTujuan,jumlahTiket;
    String strTglBerangkat,strAsal,strTujuan,strJmlTiket;
    EditText etTglBerangkat;
    Button cariTiket;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cari_tiket);
        poolAsal = (Spinner) findViewById(R.id.spinnerKotaAsal);
        poolTujuan = (Spinner) findViewById(R.id.spinnerKotatujuan);
        jumlahTiket = (Spinner) findViewById(R.id.spinnerJumlahTiket);
        etTglBerangkat = (EditText) findViewById(R.id.etTanggal);

        cariTiket = (Button) findViewById(R.id.btnCariTiket);
        cariTiket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                strAsal = poolAsal.getSelectedItem().toString();
                strTujuan = poolTujuan.getSelectedItem().toString();
                strTglBerangkat = etTglBerangkat.getText().toString();
                strJmlTiket = jumlahTiket.getSelectedItem().toString();
                SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(view.getContext());
                SharedPreferences.Editor editor = prefs.edit();
                editor.putString("dataTanggalBerangkat", strTglBerangkat); //InputString: from the EditText
                editor.putString("dataJumlahTiket", strJmlTiket); //InputString: from the EditText
                editor.putString("dataPoolAsal", strAsal); //InputString: from the EditText
                editor.putString("dataPoolTujuan", strTujuan); //InputString: from the EditText
                editor.commit();
                Intent i = new Intent(view.getContext(), ListTiket.class);
                i.putExtra("strAsal",strAsal);
                i.putExtra("strTujuan",strTujuan);
                i.putExtra("strTanggalBerangkat",strTglBerangkat);
                i.putExtra("strJmlTiket",strJmlTiket);
                view.getContext().startActivity(i);
            }
        });
    }
}
