package com.panduaryw.t_prime;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class ProfileAdapter extends RecyclerView.Adapter<ProfileAdapter.ViewHolder> {
    Context context; //inisiasi variable
    List<Users> pembayaranList; //

    public ProfileAdapter(Context context, List<Users> TempList) {

        this.pembayaranList = TempList; //refrensi variable

        this.context = context;
    }

    @Override
    public ProfileAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_profile, parent, false);  //refrensi variable

        ViewHolder viewHolder = new ViewHolder(view); //refrensi variable ke holder

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ProfileAdapter.ViewHolder holder, int position) {
        Users l = pembayaranList.get(position);
        holder.tvNama.setText(l.getNama());
        holder.tvAlamat.setText(l.getAlamat());
        holder.tvIdentitas.setText(l.getNoIdentitas());
        holder.tvNoHp.setText(l.getNoHp());
        holder.tvUsername.setText(l.getUsername());

    }

    @Override
    public int getItemCount() {
        return pembayaranList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
       public TextView tvNama,tvUsername,tvNoHp,tvIdentitas,tvAlamat;


        public ViewHolder(View itemView) {
            super(itemView);
            tvNama = (TextView) itemView.findViewById(R.id.textNama);
            tvUsername = (TextView) itemView.findViewById(R.id.textUsername);
            tvNoHp = (TextView) itemView.findViewById(R.id.textNoHp);
            tvIdentitas = (TextView) itemView.findViewById(R.id.textNoIdentitas);
            tvAlamat = (TextView) itemView.findViewById(R.id.textAlamat);


        }


    }
}
