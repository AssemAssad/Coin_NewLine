package com.example.coin.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.coin.Models.PricesCoinzData;
import com.example.coin.R;

import java.util.List;

public class PricesCoinzAdapter extends RecyclerView.Adapter<PricesCoinzAdapter.ViewHolder> {

    private List<PricesCoinzData> pricesCoinzData;

    public PricesCoinzAdapter(List<PricesCoinzData> pricesCoinzData) {
        this.pricesCoinzData = pricesCoinzData;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.coinz_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.tv_num_item.setText(pricesCoinzData.get(position).getNum_item());
        holder.tv_name_item.setText(pricesCoinzData.get(position).getName_item());
        holder.tv_prices_item.setText(pricesCoinzData.get(position).getPrices_item());
        holder.tv_percent.setText(pricesCoinzData.get(position).getPercent());
        holder.iv_item.setImageResource(pricesCoinzData.get(position).getIv_item());
    }

    @Override
    public int getItemCount() {
        return pricesCoinzData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tv_num_item,tv_name_item,tv_prices_item,tv_percent;
        ImageView iv_item;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_num_item = itemView.findViewById(R.id.tv_num_item);
            tv_name_item = itemView.findViewById(R.id.tv_name_item);
            tv_prices_item = itemView.findViewById(R.id.tv_prices_item);
            tv_percent = itemView.findViewById(R.id.tv_percent);
            iv_item = itemView.findViewById(R.id.iv_item);

        }


    }
}
