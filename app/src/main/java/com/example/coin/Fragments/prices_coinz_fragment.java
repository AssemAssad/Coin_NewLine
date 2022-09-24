package com.example.coin.Fragments;

import android.app.Dialog;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.coin.Adapters.PricesCoinzAdapter;
import com.example.coin.Adapters.PricesCoinzDialogAdapter;
import com.example.coin.Models.PricesCoinzData;
import com.example.coin.R;

import java.util.ArrayList;


public class prices_coinz_fragment extends Fragment{

    public prices_coinz_fragment() {
        // Required empty public constructor
    }


    PricesCoinzData pricesCoinzData ;
    ArrayList<PricesCoinzData> dataArrayList;
    RecyclerView recyclerView,recyclerView_dialog;
    PricesCoinzAdapter adapter;
    PricesCoinzDialogAdapter dialogAdapter;
    CardView add_card ;
    ConstraintLayout const_layout;
    TextView add_tv_name_card,add_tv_prices_card;
    ImageView add_iv_card;
    int img;
    String name , num;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_prices_coinz, container, false);
        pricesCoinzData = new PricesCoinzData();
        recyclerView = view.findViewById(R.id.rec_prices_coinz);

        add_card = view.findViewById(R.id.add_card);
        add_tv_name_card = view.findViewById(R.id.add_tv_name_card);
        add_tv_prices_card = view.findViewById(R.id.add_tv_prices_card);
        add_iv_card = view.findViewById(R.id.add_iv_card);
        const_layout = view.findViewById(R.id.const_layout);

        add_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showCustomDialog();
            }
        });




        dataArrayList = getCustomList();
        adapter = new PricesCoinzAdapter(dataArrayList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);

        return view;

    }

    private void showCustomDialog() {
        final Dialog dialog = new Dialog(getContext());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(true);
        dialog.setContentView(R.layout.layout_dialog);
        pricesCoinzData = new PricesCoinzData();
        recyclerView_dialog = dialog.findViewById(R.id.rec_dialog);
        dataArrayList = getCustomList();
        dialogAdapter = new PricesCoinzDialogAdapter(dataArrayList);
        recyclerView_dialog.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView_dialog.setAdapter(dialogAdapter);
        dialogAdapter.onItemClickListener(new PricesCoinzDialogAdapter.onItemClickListener() {
            @Override
            public void onItemClick(int position) {
                img = dataArrayList.get(position).getIv_item();
                name = dataArrayList.get(position).getName_item();
                num = dataArrayList.get(position).getPrices_item();
                populateInfoTv(img,name,num);
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    private void populateInfoTv(int img, String name, String num) {
            add_iv_card.setImageResource(img);
            add_tv_name_card.setText(name);
            add_tv_name_card.setTextColor(Color.WHITE);
            add_tv_prices_card.setVisibility(View.VISIBLE);
            add_tv_prices_card.setText(num);
            add_tv_prices_card.setTextColor(Color.WHITE);
            const_layout.setBackground(getResources().getDrawable(R.drawable.color2,null));
    }


    private ArrayList<PricesCoinzData> getCustomList() {
        dataArrayList = new ArrayList<>();
        dataArrayList.add(new PricesCoinzData("1", R.drawable.btcc,"100,815,1","20%","Bitcoin بيتكوين"));
        dataArrayList.add(new PricesCoinzData("2", R.drawable.eth,"100,815,1","20%","Bitcoin بيتكوين"));
        dataArrayList.add(new PricesCoinzData("3", R.drawable.xrp,"100,815,1","20%","Bitcoin بيتكوين"));
        dataArrayList.add(new PricesCoinzData("4", R.drawable.ada,"100,815,1","20%","Bitcoin بيتكوين"));
        dataArrayList.add(new PricesCoinzData("5", R.drawable.ltc,"100,815,1","20%","Bitcoin بيتكوين"));
        dataArrayList.add(new PricesCoinzData("6", R.drawable.neo,"100,815,1","20%","Bitcoin بيتكوين"));
        dataArrayList.add(new PricesCoinzData("7", R.drawable.xem,"100,815,1","20%","Bitcoin بيتكوين"));
        dataArrayList.add(new PricesCoinzData("8", R.drawable.miota,"100,815,1","20%","Bitcoin بيتكوين"));
        dataArrayList.add(new PricesCoinzData("9", R.drawable.btc,"100,815,1","20%","Bitcoin بيتكوين"));
        dataArrayList.add(new PricesCoinzData("10", R.drawable.xrp,"100,815,1","20%","Bitcoin بيتكوين"));
        return dataArrayList;
    }


}