package com.panduaryw.t_prime;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.ViewHolder> {
    Context context; //inisiasi variable
    List<PembayaranModel> pembayaranList; //

    public HistoryAdapter(Context context, List<PembayaranModel> TempList) {

        this.pembayaranList = TempList; //refrensi variable

        this.context = context;
    }

    @Override
    public HistoryAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_riwayat, parent, false);  //refrensi variable

        ViewHolder viewHolder = new ViewHolder(view); //refrensi variable ke holder

        return viewHolder;
    }


    @Override
    public void onBindViewHolder(HistoryAdapter.ViewHolder holder, int position) {
        PembayaranModel l = pembayaranList.get(position);
        holder.textViewAsalTujuan.setText(l.getAsalTujuan());
        holder.textViewKodeBooking.setText(l.getKodeBooking());
        holder.textViewPemesan.setText(l.getUser());
        holder.textViewStatusBooking.setText(l.getStatus());
        holder.textViewTotalHarga.setText(l.getHargaTotal());
        if(holder.textViewStatusBooking.getText().equals("BELUM LUNAS")){
            holder.textViewStatusBooking.setBackgroundColor(context.getResources().getColor(R.color.cardview_shadow_end_color));}
        if(holder.textViewStatusBooking.getText().equals("LUNAS")){
            holder.textViewStatusBooking.setBackgroundColor(context.getResources().getColor(R.color.cardview_shadow_start_color));}
    }

    @Override
    public int getItemCount() {
        return pembayaranList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewKodeBooking,textViewAsalTujuan,textViewPemesan,textViewStatusBooking,textViewTotalHarga;


        public ViewHolder(View itemView) {
            super(itemView);
            textViewAsalTujuan = (TextView) itemView.findViewById(R.id.tv_asal_tujuan);
            textViewKodeBooking = (TextView) itemView.findViewById(R.id.tv_kode_booking);
            textViewPemesan = (TextView) itemView.findViewById(R.id.tv_email_pemesan);
            textViewStatusBooking = (TextView) itemView.findViewById(R.id.tv_status_booking);
            textViewTotalHarga = (TextView) itemView.findViewById(R.id.tv_total_harga);


        }


    }
}
