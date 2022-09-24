package com.example.coin.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.coin.Models.CustomSpinnerItem;
import com.example.coin.R;

import java.util.ArrayList;

public class CustomSpinnerAdapter extends ArrayAdapter<CustomSpinnerItem> {

    public CustomSpinnerAdapter(@NonNull Context context, ArrayList<CustomSpinnerItem> spinneritems) {
        super(context, 0, spinneritems );
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView==null){
            convertView= LayoutInflater.from(getContext()).inflate(R.layout.custom_dropdown_layout,parent,false);

        }
        CustomSpinnerItem spinnerItem = getItem(position);
        ImageView spinnerIV = convertView.findViewById(R.id.iv_sp_item);
        TextView spinnerTV = convertView.findViewById(R.id.tv_sp_item);
        if (spinnerItem != null) {
            spinnerIV.setImageResource(spinnerItem.getItemImgs());
            spinnerTV.setText(spinnerItem.getItemName());
        }
        return convertView;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView==null){
            convertView= LayoutInflater.from(getContext()).inflate(R.layout.custom_dropdown_layout,parent,false);

        }
        CustomSpinnerItem spinnerItem = getItem(position);
        ImageView spinnerIV = convertView.findViewById(R.id.iv_sp_item);
        TextView spinnerTV = convertView.findViewById(R.id.tv_sp_item);
        if (spinnerItem != null) {
            spinnerIV.setImageResource(spinnerItem.getItemImgs());
            spinnerTV.setText(spinnerItem.getItemName());
        }
        return convertView;
    }
}
