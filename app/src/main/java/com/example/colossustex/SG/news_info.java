package com.example.colossustex.SG;

public class news_info {

    String Name, News, Place, Time;

    public news_info(){

    }

    public news_info(String name, String news, String place, String time) {
        Name = name;
        News = news;
        Place = place;
        Time = time;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getNews() {
        return News;
    }

    public void setNews(String News) {
        this.News = News;
    }

    public String getPlace() {
        return Place;
    }

    public void setPlace(String Place) {
        this.Place = Place;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String Time) {
        this.Time = Time;
    }
}
