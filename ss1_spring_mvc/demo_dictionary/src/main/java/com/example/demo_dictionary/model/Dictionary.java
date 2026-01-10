package com.example.demo_dictionary.model;

public class Dictionary {
    private String viet;
    private String eng;

    public Dictionary() {
    }

    public Dictionary(String viet, String eng) {
        this.viet = viet;
        this.eng = eng;
    }

    public String getViet() {
        return viet;
    }

    public void setViet(String viet) {
        this.viet = viet;
    }

    public String getEng() {
        return eng;
    }

    public void setEng(String eng) {
        this.eng = eng;
    }
}
