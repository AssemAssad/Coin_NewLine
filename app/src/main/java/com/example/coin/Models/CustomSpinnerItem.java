package com.example.coin.Models;

public class CustomSpinnerItem {
    private String itemName;
    private int itemImgs;

    public CustomSpinnerItem() {
    }

    public CustomSpinnerItem(String itemName, int itemImg) {
        this.itemName = itemName;
        this.itemImgs = itemImg;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setItemImgs(int itemImg) {
        this.itemImgs = itemImg;
    }

    public String getItemName() {
        return itemName;
    }

    public int getItemImgs() {
        return itemImgs;
    }

}
