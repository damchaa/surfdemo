package com.example.surfdemo.pojo;

public class CalcRequest {
    private String s;

    @Override
    public String toString() {
        return "CalcRequest{" +
                "s='" + s + '\'' +
                '}';
    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }
}
