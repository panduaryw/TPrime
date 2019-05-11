package com.panduaryw.t_prime;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SearchView;

public class CekBooking extends AppCompatActivity {
    Button btnCekBooking;
    String kodeBooking,jamBerangkat,jamTiba,totalHarga;
    SearchView svBooking;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cek_booking);
        svBooking = (SearchView) findViewById(R.id.searchViewBooking);
        btnCekBooking = (Button) findViewById(R.id.btn_caribooking);
        btnCekBooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                kodeBooking = svBooking.getQuery().toString();
                Intent i = new Intent(CekBooking.this,HasilCekBookingActivity.class);
                i.putExtra("kodeBooking",kodeBooking);
                startActivity(i);
            }
        });
    }
}
