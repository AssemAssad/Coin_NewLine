package com.example.coin.Models;

public class Rec_alarm_data {
    private String itemName , itemEqual,itemNum;
    private int itemImg;

    public Rec_alarm_data() {
    }

    public Rec_alarm_data(String itemName, String itemEqual, String itemNum, int itemImg) {
        this.itemName = itemName;
        this.itemEqual = itemEqual;
        this.itemNum = itemNum;
        this.itemImg = itemImg;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemEqual() {
        return itemEqual;
    }

    public void setItemEqual(String itemEqual) {
        this.itemEqual = itemEqual;
    }

    public String getItemNum() {
        return itemNum;
    }

    public void setItemNum(String itemNum) {
        this.itemNum = itemNum;
    }

    public int getItemImg() {
        return itemImg;
    }

    public void setItemImg(int itemImg) {
        this.itemImg = itemImg;
    }
}
