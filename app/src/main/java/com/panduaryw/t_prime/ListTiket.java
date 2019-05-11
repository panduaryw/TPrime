package com.panduaryw.t_prime;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ganteng on 4/17/2018.
 */

public class ListTiket extends AppCompatActivity{

    DatabaseReference databaseReference;

    ProgressDialog progressDialog;

    List<TiketDetails> list = new ArrayList<>();

    RecyclerView recyclerView;

    RecyclerView.Adapter adapter ;
    protected String strJumlahTiket,strTanggal,poolAsal,poolTujuan,asalTujuan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tiket);

        recyclerView = (RecyclerView) findViewById(R.id.tiketRV);

        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(ListTiket.this));

        progressDialog = new ProgressDialog(ListTiket.this);

        progressDialog.setMessage("Loading Data from Firebase Database");

        progressDialog.show();
        Intent iCari = getIntent();
        strJumlahTiket = iCari.getStringExtra("strJmlTiket");
        strTanggal = iCari.getStringExtra("strTanggalBerangkat");
        asalTujuan = iCari.getStringExtra("strAsal")+"-"+iCari.getStringExtra("strTujuan");
        Intent i = new Intent(ListTiket.this,BookingTiket.class);
        i.putExtra("strJmlTiket",strJumlahTiket);
        i.putExtra("strTanggalBerangkat",strTanggal);
        databaseReference = FirebaseDatabase.getInstance().getReference("tiket");

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {

                    TiketDetails studentDetails = dataSnapshot.getValue(TiketDetails.class);

                    if(studentDetails.getAsal_tujuan().equals(asalTujuan)&&studentDetails.getTanggal().equals(strTanggal)){
                        list.add(studentDetails); //add data ke listviews
                    }
                }

                adapter = new TiketAdapter(ListTiket.this, list);

                recyclerView.setAdapter(adapter);

                progressDialog.dismiss();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

                progressDialog.dismiss();

            }
        });

    }

}
