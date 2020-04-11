package com.example.colossustex.SG;

public class req_card {

    private String Details, Number;

    public req_card(){

    }

    public req_card(String Details, String Number){
        this.Details = Details;
        this.Number = Number;
    }

    public String getDetails() {
        return Details;
    }

    public void setDetails(String details) {
        Details = details;
    }

    public String getNumber() {
        return Number;
    }

    public void setNumber(String number) {
        Number = number;
    }
}
