package com.example.coin.Adapters;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.coin.Models.Rec_alarm_data;
import com.example.coin.R;

import java.util.List;

public class AlarmCoinzAdapter extends RecyclerView.Adapter<AlarmCoinzAdapter.ViewHolder> {

    private List<Rec_alarm_data> data;
    private onItemClickListener listener;

    public interface onItemClickListener{
        void onItemClick(int position);
    }

    public void setOnItemClickListener(onItemClickListener clickListener){
        listener = clickListener;
    }


    public AlarmCoinzAdapter(List<Rec_alarm_data> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.alarm_item,parent,false);
        return new ViewHolder(view,listener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.tv_name.setText(data.get(position).getItemName());
        holder.iv_coinz.setImageResource(data.get(position).getItemImg());
        if (data.get(position).getItemEqual().equals("اكبر من")||data.get(position).getItemEqual().equals("يساوي")){
            holder.tv_equls.setTextColor(Color.rgb(56,173,101));
            holder.tv_equls.setText(data.get(position).getItemEqual());
            holder.tv_num.setTextColor(Color.rgb(56,173,101));
            holder.tv.setTextColor(Color.rgb(56,173,101));
            holder.tv_num.setText(data.get(position).getItemNum());
        }else {
            holder.tv_equls.setTextColor(Color.rgb(231,34,34));
            holder.tv_equls.setText(data.get(position).getItemEqual());

            holder.tv_num.setTextColor(Color.rgb(231,34,34));
            holder.tv.setTextColor(Color.rgb(231,34,34));
            holder.tv_num.setText(data.get(position).getItemNum());
        }



    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView iv_coinz;
        private TextView tv_name,tv_equls,tv_num,tv;
        private ImageButton btn_delete;
        public ViewHolder(@NonNull View itemView,onItemClickListener listener) {
            super(itemView);

            iv_coinz = itemView.findViewById(R.id.iv_coinz);
            tv_name = itemView.findViewById(R.id.tv_name);
            tv_equls = itemView.findViewById(R.id.tv_equls);
            tv_num = itemView.findViewById(R.id.tv_num);
            btn_delete = itemView.findViewById(R.id.btn_delete);
            tv = itemView.findViewById(R.id.tv);

            btn_delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    listener.onItemClick(getAdapterPosition());
                }
            });
        }
    }
}
