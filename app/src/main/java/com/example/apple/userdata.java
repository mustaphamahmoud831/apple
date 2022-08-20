package com.example.apple;

public class userdata {
    private int ID;
    private String NAME;
    private String MAIL;
    private String PASSWORD;
    private int PHONE;

    public userdata(int anInt, String string) {
    }

    public userdata(int ID, String NAME, String MAIL, String PASSWORD, int PHONE) {
        this.ID = ID;
        this.NAME = NAME;
        this.MAIL = MAIL;
        this.PASSWORD = PASSWORD;
        this.PHONE = PHONE;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public String getMAIL() {
        return MAIL;
    }

    public void setMAIL(String MAIL) {
        this.MAIL = MAIL;
    }

    public String getPASSWORD() {
        return PASSWORD;
    }

    public void setPASSWORD(String PASSWORD) {
        this.PASSWORD = PASSWORD;
    }

    public int getPHONE() {
        return PHONE;
    }

    public void setPHONE(int PHONE) {
        this.PHONE = PHONE;
    }

    @Override
    public String toString() {
        return "userdata is:" + NAME + MAIL + PASSWORD + PHONE;
    }
}
