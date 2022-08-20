package com.example.apple;

import java.util.ArrayList;

public class ToDataBase {

    private String Address;
    private float fullPrice;
    private ArrayList<String> list = new ArrayList<>();


    public ToDataBase() {
    }


    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public float getFullPrice() {
        return fullPrice;
    }

    public void setFullPrice(float fullPrice) {
        this.fullPrice = fullPrice;
    }

    public ArrayList<String> getList() {
        return list;
    }

    public void setList(ArrayList<String> list) {
        this.list = list;
    }

    public void setData(ArrayList<com.example.apple.menu> menuArrayList) {
        com.example.apple.menu stringList;
        list.clear();
        for (int i = 0; i < menuArrayList.size(); i++) {
            stringList = menuArrayList.get(i);
            String name = stringList.getText1();
            list.add(name);
            float price = Float.parseFloat(stringList.getText2().trim());
            fullPrice += price;
        }
        setFullPrice(fullPrice);
        setList(list);
    }


}

