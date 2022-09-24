package com.example.coin.Models;

public class NewsData {
    int iv_news_item;
    String title_news_item ,time_news_item ,big_text;

    public NewsData(int iv_news_item, String title_news_item, String time_news_item, String big_text) {
        this.iv_news_item = iv_news_item;
        this.title_news_item = title_news_item;
        this.time_news_item = time_news_item;
        this.big_text = big_text;
    }

    public NewsData() {
    }

    public int getIv_news_item() {
        return iv_news_item;
    }

    public void setIv_news_item(int iv_news_item) {
        this.iv_news_item = iv_news_item;
    }

    public String getTitle_news_item() {
        return title_news_item;
    }

    public void setTitle_news_item(String title_news_item) {
        this.title_news_item = title_news_item;
    }

    public String getTime_news_item() {
        return time_news_item;
    }

    public void setTime_news_item(String time_news_item) {
        this.time_news_item = time_news_item;
    }

    public String getBig_text() {
        return big_text;
    }

    public void setBig_text(String big_text) {
        this.big_text = big_text;
    }
}
