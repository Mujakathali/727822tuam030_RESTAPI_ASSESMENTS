package com.example.giftshop.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "GiftShop")
public class GiftModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int GiftId;
    private String Giftcategory;
    private String Giftname;
    private int Giftprice;
    private String GiftDecription;

    public int getGiftId() {
        return GiftId;
    }

    public void setGiftId(int id) {
        this.GiftId = id;
    }

    public String getGiftcategory() {
        return Giftcategory;
    }

    public void setGiftcategory(String category) {
        this.Giftcategory = category;
    }

    public String getGiftname() {
        return Giftname;
    }

    public void setGiftname(String name) {
        this.Giftname = name;
    }

    public int getGiftprice() {
        return Giftprice;
    }

    public void setGiftprice(int price) {
        this.Giftprice = price;
    }

    public String getGiftDecription() {
        return GiftDecription;
    }

    public void setGiftDecription(String decription) {
        GiftDecription = decription;
    }

    public GiftModel(int id, String category, String name, int price, String decription) {
        this.GiftId = id;
        this.Giftcategory = category;
        this.Giftname = name;
        this.Giftprice = price;
        GiftDecription = decription;
    }

    public GiftModel() {
    }

}
