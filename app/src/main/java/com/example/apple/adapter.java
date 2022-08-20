package com.example.apple;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

public class adapter extends ArrayAdapter<menu> {
    public adapter(Context context, List<menu> menus) {
        super(context, 0, menus);
    }

    @NonNull
    @Override









    /*                             get view                       */
    public View getView(int position, View convertView, ViewGroup parent) {
        View current_items = convertView;
        if (current_items == null) {
            current_items = LayoutInflater.from(getContext()).inflate(R.layout.menu_row, parent, false);

        }
        menu current = getItem(position);
        TextView t_v_1 = current_items.findViewById(R.id.row_main_text);
        t_v_1.setText(current.getText1());
        TextView t_v_2 = current_items.findViewById(R.id.row_price);
        t_v_1.setText(current.getText1());


        return current_items;
    }
}
