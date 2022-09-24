package com.example.coin.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.coin.Models.NewsData;
import com.example.coin.R;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {

    private List<NewsData> newsData;
    private onItemClickListener listener;

    public interface onItemClickListener{
        void onItemClick(int position);
    }

    public NewsAdapter(List<NewsData> newsData) {
        this.newsData = newsData;
    }

    public void onItemClickListener(onItemClickListener clickListener){
        listener = clickListener;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_item,parent,false);

        return new ViewHolder(view,listener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.iv_news_item.setImageResource(newsData.get(position).getIv_news_item());
        holder.tv_title_news_item.setText(newsData.get(position).getTitle_news_item());
        holder.tv_time_news_item.setText(newsData.get(position).getTime_news_item());
    }

    @Override
    public int getItemCount() {
        return newsData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView iv_news_item;
        TextView tv_title_news_item, tv_time_news_item;

        public ViewHolder(@NonNull View itemView , onItemClickListener listener) {
            super(itemView);
            iv_news_item = itemView.findViewById(R.id.iv_news_item);
            tv_title_news_item = itemView.findViewById(R.id.tv_title_news_item);
            tv_time_news_item = itemView.findViewById(R.id.tv_time_news_item);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onItemClick(getAdapterPosition());
                }
            });
        }
    }
}
