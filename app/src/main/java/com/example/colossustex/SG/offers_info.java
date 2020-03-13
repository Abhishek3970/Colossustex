package com.example.colossustex.SG;

public class offers_info {

    private String Name;
    private String Content;

    public offers_info(){

    }

    public offers_info(String Content, String Name) {
        this.Content = Content;
        this.Name = Name;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String Content) {
        this.Content = Content;
    }
}
