package com.example.coin.Models;

public class PricesCoinzData {
    int iv_item;
    String name_item , num_item, prices_item , percent;


    public PricesCoinzData(String num_item, int iv_item, String prices_item, String percent, String name_item) {
        this.num_item = num_item;
        this.iv_item = iv_item;
        this.prices_item = prices_item;
        this.percent = percent;
        this.name_item = name_item;
    }

    public PricesCoinzData() {
    }

    public String getNum_item() {
        return num_item;
    }

    public void setNum_item(String num_item) {
        this.num_item = num_item;
    }

    public int getIv_item() {
        return iv_item;
    }

    public void setIv_item(int iv_item) {
        this.iv_item = iv_item;
    }

    public String getPrices_item() {
        return prices_item;
    }

    public void setPrices_item(String prices_item) {
        this.prices_item = prices_item;
    }

    public String getPercent() {
        return percent;
    }

    public void setPercent(String percent) {
        this.percent = percent;
    }

    public String getName_item() {
        return name_item;
    }

    public void setName_item(String name_item) {
        this.name_item = name_item;
    }
}
