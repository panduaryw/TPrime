package com.panduaryw.t_prime;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class TiketAdapter extends RecyclerView.Adapter<TiketAdapter.ViewHolder>{
    Context context;
    public String jumlahTiket;
    List<TiketDetails> MainImageUploadInfoList;

    public TiketAdapter(Context context, List<TiketDetails> TempList) {

        this.MainImageUploadInfoList = TempList;

        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_tiket, parent, false);

        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        TiketDetails studentDetails = MainImageUploadInfoList.get(position);

        holder.jamBerangkatTextView.setText(studentDetails.getJamBerangkat());

        holder.jamTibaTextView.setText(studentDetails.getJamTiba());

        holder.sisaKursiTextView.setText(studentDetails.getJumlah());

        holder.hargaTextView.setText(studentDetails.getHarga());

        holder.kodeTiketTextView.setText(studentDetails.getKode_tiket());

        holder.asalTujuanTextView.setText(studentDetails.getAsal_tujuan());

    }

    @Override
    public int getItemCount() {

        return MainImageUploadInfoList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView jamBerangkatTextView;
        public TextView jamTibaTextView;
        public TextView sisaKursiTextView;
        public TextView hargaTextView;
        public TextView kodeTiketTextView;
        public TextView asalTujuanTextView;

        public ViewHolder(View itemView) {

            super(itemView);

            jamBerangkatTextView = (TextView) itemView.findViewById(R.id.tvJamBerangkat);

            jamTibaTextView = (TextView) itemView.findViewById(R.id.tvJamTiba);

            sisaKursiTextView = (TextView) itemView.findViewById(R.id.tvSisaKursi);

            hargaTextView = (TextView) itemView.findViewById(R.id.tvHargaTiket);

            kodeTiketTextView = (TextView) itemView.findViewById(R.id.tvKodeTiket);

            asalTujuanTextView = (TextView) itemView.findViewById(R.id.tvAsalTujuan);

            itemView.setOnClickListener(this);


        }

        @Override
        public void onClick(View view) {
            int mPosition = getLayoutPosition();
            String elemen = MainImageUploadInfoList.get(mPosition).toString();
            String kodeTiket = MainImageUploadInfoList.get(mPosition).getKode_tiket();
            String asalTujuan = MainImageUploadInfoList.get(mPosition).getAsal_tujuan();
            String berangkat = MainImageUploadInfoList.get(mPosition).getJamBerangkat();
            String tiba = MainImageUploadInfoList.get(mPosition).getJamTiba();
            String harga = MainImageUploadInfoList.get(mPosition).getHarga();
            Intent i = new Intent(view.getContext(), BookingTiket.class);
            i.putExtra("kodeTiket",kodeTiket);
            i.putExtra("asalTujuan",asalTujuan);
            i.putExtra("jamBerangkat",berangkat);
            i.putExtra("jamTiba",tiba);
            i.putExtra("harga",harga);
            view.getContext().startActivity(i);
        }
    }

}
