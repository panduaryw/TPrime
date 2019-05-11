package com.panduaryw.t_prime;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.LinkedList;

public class Berita extends AppCompatActivity {

    private final LinkedList<String> njudul = new LinkedList<>(); //atribut judul

    private final LinkedList<String> ndesc = new LinkedList<>(); //atribut deskripsi
    private final LinkedList<Integer> nimage = new LinkedList<>();

    private RecyclerView recycler; //atribut recyclerview
    private List_berita list; //atribut untuk menghubungkan data listair

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_berita);
        list();

        recycler= findViewById(R.id.recyclerView); //untuk implementasi recyclerview
        list = new List_berita(this,njudul,ndesc,nimage);//implementsi untuk list yaitu judul deskripsi dan image
        recycler.setAdapter(list); //untuk koneksi
        recycler.setLayoutManager(new LinearLayoutManager(this));//set untuk layout
    }

    private void list(){
        njudul.add("Cashback");
        njudul.add("Diskon 10%");
        njudul.add("Liburan Murah");


        nimage.add(R.drawable.banner);
        nimage.add(R.drawable.banner);
        nimage.add(R.drawable.banner);

    }
}
