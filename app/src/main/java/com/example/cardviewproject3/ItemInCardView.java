package com.example.cardviewproject3;

public class ItemInCardView {
    private int img;
    private String title;

    public ItemInCardView(int img, String title){
        this.img = img;
        this.title = title;
    }

    public String getTitle(){
        return title;
    }

    public int getImg(){
        return img;
    }

}
