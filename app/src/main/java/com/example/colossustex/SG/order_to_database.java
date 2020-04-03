package com.example.colossustex.SG;

public class order_to_database {
    String Details, Number;
    public order_to_database(){}

    public order_to_database(String details, String number) {
        Details = details;
        Number = number;
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
