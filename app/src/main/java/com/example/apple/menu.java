package com.example.apple;

public class menu {
    private int img;
    private String text1;
    private String text2;

    public menu(int img, String text1, String text2) {
        this.img = img;
        this.text1 = text1;
        this.text2 = text2;
    }

    public menu(int img, String text1) {
        this.img = img;
        this.text1 = text1;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getText1() {
        return text1;
    }

    public void setText1(String text1) {
        this.text1 = text1;
    }

    public String getText2() {
        return text2;
    }

    public void setText2(String text2) {
        this.text2 = text2;
    }

    @Override
    public String toString() {
        return "you selected:" + getText1() + " and the price is :" + getText2() + "LE";
    }
}
