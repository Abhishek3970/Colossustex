package com.example.colossustex.SG;

class sub_sensex_info {

    String sub_heading, sub_price, sub_time, sub_title, sub_change, sub_ultimate_change;

    public sub_sensex_info(String sub_heading, String sub_price, String sub_time, String sub_title, String sub_change, String sub_ultimate_change) {
        this.sub_heading = sub_heading;
        this.sub_price = sub_price;
        this.sub_time = sub_time;
        this.sub_title = sub_title;
        this.sub_change = sub_change;
        this.sub_ultimate_change = sub_ultimate_change;
    }

    public String getSub_heading() {
        return sub_heading;
    }

    public void setSub_heading(String sub_heading) {
        this.sub_heading = sub_heading;
    }

    public String getSub_price() {
        return sub_price;
    }

    public void setSub_price(String sub_price) {
        this.sub_price = sub_price;
    }

    public String getSub_time() {
        return sub_time;
    }

    public void setSub_time(String sub_time) {
        this.sub_time = sub_time;
    }

    public String getSub_title() {
        return sub_title;
    }

    public void setSub_title(String sub_title) {
        this.sub_title = sub_title;
    }

    public String getSub_change() {
        return sub_change;
    }

    public void setSub_change(String sub_change) {
        this.sub_change = sub_change;
    }

    public String getSub_ultimate_change() {
        return sub_ultimate_change;
    }

    public void setSub_ultimate_change(String sub_ultimate_change) {
        this.sub_ultimate_change = sub_ultimate_change;
    }
}
