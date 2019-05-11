package com.panduaryw.t_prime;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class customList extends ArrayAdapter<String> {
    private final Activity context;
    private final String[] item;
    private final String [] subitem;
    public customList(Activity context,
                      String[] item, String[] subitem) {
        super(context, R.layout.list_item, item);
        this.context = context;
        this.item = item;
        this.subitem = subitem;

    }
    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView= inflater.inflate(R.layout.list_item, null, true);

        TextView txtItem = (TextView) rowView.findViewById(R.id.item);
        TextView txtsubitem = (TextView) rowView.findViewById(R.id.subitem);

        txtItem.setText(item[position]);
        txtsubitem.setText(subitem[position]);
        return rowView;
    }
}
