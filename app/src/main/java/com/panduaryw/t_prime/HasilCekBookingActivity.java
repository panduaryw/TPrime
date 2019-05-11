package com.panduaryw.t_prime;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class HasilCekBookingActivity extends AppCompatActivity {
    PembayaranModel studentDetails;
    DatabaseReference databaseReference; //inisiasi variable
    RecyclerView.Adapter adapter; //inisiasi variable
    RecyclerView recyclerView; //inisiasi variable
    List<PembayaranModel> pembayaranModelList = new ArrayList<>();
    String kodeBooking;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil_cek_booking);
        recyclerView = (RecyclerView) findViewById(R.id.cekBookingRV);
        recyclerView.setLayoutManager(new LinearLayoutManager(HasilCekBookingActivity.this));
        Intent intent = getIntent();
        kodeBooking = intent.getStringExtra("kodeBooking");
        pembayaranModelList.clear();
        databaseReference = FirebaseDatabase.getInstance().getReference("pemesanan");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {

                    studentDetails = dataSnapshot.getValue(PembayaranModel.class);

                    if(studentDetails.getKodeBooking().equals(kodeBooking)){
                        pembayaranModelList.add(studentDetails); //add data ke listviews
                    }

                }
                adapter = new HistoryAdapter(HasilCekBookingActivity.this, pembayaranModelList);//set adapter
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
