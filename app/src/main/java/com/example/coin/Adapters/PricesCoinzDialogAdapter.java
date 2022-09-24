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

public class PricesCoinzDialogAdapter extends RecyclerView.Adapter<PricesCoinzDialogAdapter.ViewHolder> {

    private List<PricesCoinzData> pricesCoinzData;
    private onItemClickListener listener;

    public interface onItemClickListener{
        void onItemClick(int position);
    }
    public PricesCoinzDialogAdapter(List<PricesCoinzData> pricesCoinzData) {
        this.pricesCoinzData = pricesCoinzData;
    }
    public void onItemClickListener(onItemClickListener clickListener){
        listener = clickListener;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.coinz_item_dialog,parent,false);
        return new ViewHolder(view,listener);
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
        public ViewHolder(@NonNull View itemView , onItemClickListener listener) {
            super(itemView);

            tv_num_item = itemView.findViewById(R.id.tv_num_item1);
            tv_name_item = itemView.findViewById(R.id.tv_name_item1);
            tv_prices_item = itemView.findViewById(R.id.tv_prices_item1);
            tv_percent = itemView.findViewById(R.id.tv_percent1);
            iv_item = itemView.findViewById(R.id.iv_item1);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onItemClick(getAdapterPosition());

                }
            });
        }


    }
}
