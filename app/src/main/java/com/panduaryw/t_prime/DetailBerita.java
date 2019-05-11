package com.panduaryw.t_prime;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailBerita extends AppCompatActivity {

    ImageView mImgL;
    TextView mTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_berita);

        Intent intent = getIntent();

        mImgL = findViewById(R.id.detailPhoto);
        mTitle = findViewById(R.id.textTitle);

        int image = intent.getIntExtra("Gambar", 0);
        mImgL.setImageResource(image);
        mTitle.setText(intent.getStringExtra("judul"));
    }
}
