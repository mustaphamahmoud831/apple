package com.example.apple;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class drinks extends BaseAdapter {

    private final Context c;
    private final int resource;
    private final ArrayList<drink> drinks;

    public drinks(Context c, int resource, ArrayList<drink> drinks) {
        this.c = c;
        this.drinks = drinks;
        this.resource = resource;
    }

    @Override
    public int getCount() {
        return drinks.size();
    }

    @Override
    public drink getItem(int i) {
        return drinks.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = view;
        if (view == null) {
            v = LayoutInflater.from(c).inflate(resource, null, false);
        }

        TextView tv1 = v.findViewById(R.id.row_main_text);
        TextView tv2 = v.findViewById(R.id.row_price);
        ImageView img = v.findViewById(R.id.row_image);


        drink d = getItem(i);
        tv1.setText(d.getText1());
        tv2.setText(d.getText2());
        img.setImageResource(d.getImg());


        return v;
    }
}
