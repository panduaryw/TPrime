package com.panduaryw.t_prime;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class TiketViewHolder extends RecyclerView.ViewHolder {
    public TextView textViewKodeTiket;
    public TextView textViewJamBerangkat;
    public TextView textViewJamTiba;
    public TextView textViewSisaKursi;
    public TextView textViewHarga;

    public TiketViewHolder(View itemView) {
        super(itemView);
        textViewKodeTiket = (TextView) itemView.findViewById(R.id.kodeTiket);
        textViewJamBerangkat = (TextView) itemView.findViewById(R.id.jamBerangkat);
        textViewJamTiba = (TextView) itemView.findViewById(R.id.jamTiba);
        textViewSisaKursi = (TextView) itemView.findViewById(R.id.sisaKursi);
        textViewHarga = (TextView) itemView.findViewById(R.id.hargaTiket);
    }
}

