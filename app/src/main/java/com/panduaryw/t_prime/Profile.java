package com.panduaryw.t_prime;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Profile extends AppCompatActivity {
    DatabaseReference databaseReference; //inisiasi variable
    RecyclerView.Adapter adapter; //inisiasi variable
    RecyclerView recyclerView; //inisiasi variable
    List<Users> komenList = new ArrayList<>();
    ProgressDialog progressDialog;
    FirebaseAuth firebaseAuth ; //inisiasi variable
    FirebaseUser firebaseUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        //super.onCreate(savedInstanceState);
        progressDialog = new ProgressDialog(Profile.this);
        recyclerView = (RecyclerView) findViewById(R.id.profileRV); //referensi variable
        progressDialog.setMessage("Loading Data...");
        progressDialog.show();
        // Setting RecyclerView size true.
        recyclerView.setHasFixedSize(true); //referensi variable
        firebaseAuth = FirebaseAuth.getInstance(); //referensi variable
        firebaseUser = firebaseAuth.getCurrentUser();
        // Setting RecyclerView layout as LinearLayout.
        recyclerView.setLayoutManager(new LinearLayoutManager(Profile.this));
        databaseReference = FirebaseDatabase.getInstance().getReference("user");
        showData();

    }
    private void showData() {
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                komenList.clear();
                for (DataSnapshot postSnapshot : snapshot.getChildren()) { //foreach memanggil data

                    Users imageUploadInfo = postSnapshot.getValue(Users.class); //get data dari firebase
                    //Toast.makeText(DetailGambar.this, imageUploadInfo.getUserKomen(), Toast.LENGTH_LONG).show();
                    if(imageUploadInfo.getUsername().equals(firebaseUser.getEmail().toString())){
                        komenList.add(imageUploadInfo); //add data ke listviews
                    }

                }
                adapter = new ProfileAdapter(Profile.this, komenList);//set adapter

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
