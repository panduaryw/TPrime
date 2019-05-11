package com.panduaryw.t_prime;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.LinkedList;

/**
 * Created by asus on 4/8/2018.
 */

public class List_berita extends RecyclerView.Adapter<List_berita.beritaView> {

    private final LinkedList<String> judul; //menampung data di adaptor
    private final LinkedList<Integer> image;

    private LayoutInflater inflater;//infalter untuk java objek dari layout

    public List_berita(Berita berita, LinkedList<String> njudul, LinkedList<String> ndesc, LinkedList<Integer> nimage) {
        inflater = LayoutInflater.from(berita);
        this.judul=njudul;
        this.image=nimage;
    }

    @Override
    public beritaView onCreateViewHolder(ViewGroup parent, int viewType) {
        View listView= inflater.inflate(R.layout.list_berita,parent,false);
        return new beritaView(listView,this);
    }

    @Override
    public void onBindViewHolder(List_berita.beritaView holder, int position) {
        String Currentjudul = judul.get(position);
        Integer Currentimage = image.get(position);

        holder.juduls.setText(Currentjudul);
        holder.images.setImageResource(Currentimage);
    }

    @Override
    public int getItemCount() {
        return image.size();
    }

    public class beritaView extends RecyclerView.ViewHolder {//menyyimpan keseluruhan dari recyclerview
        private final TextView juduls;
        private final ImageView images;

        public beritaView(final View listView, List_berita listBerita) {
            super(listView);//memamnggil constarctor

            juduls = listView.findViewById(R.id.judul);
            images = listView.findViewById(R.id.gambar);

            images.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    int position = getLayoutPosition();

                    String jdl = judul.get(position);
                    Integer img = image.get(position);

                    Intent intent = new Intent(listView.getContext(),DetailBerita.class);

                    intent.putExtra("judul",jdl);
                    intent.putExtra("Gambar",img);

                    listView.getContext().startActivity(intent);


                }
            });

        }
    }
}
