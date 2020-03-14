package com.example.colossustex.SG.model;

import java.util.ArrayList;

public class ItemGroup {
    private String headTitle;
    private String livesensex;
    private ArrayList<ItemData> listelements;

    public ItemGroup(){

    }

    public ItemGroup(String headTitle, ArrayList<ItemData> listelements, String livesensex) {
        this.headTitle = headTitle;
        this.listelements = listelements;
        this.livesensex = livesensex;
    }

    public String getHeadTitle() {
        return headTitle;
    }

    public void setHeadTitle(String headTitle) {
        this.headTitle = headTitle;
    }

    public ArrayList<ItemData> getListelements() {
        return listelements;
    }

    public void setListelements(ArrayList<ItemData> listelements) {
        this.listelements = listelements;
    }

    public String getLivesensex() {
        return livesensex;
    }

    public void setLivesensex(String livesensex) {
        this.livesensex = livesensex;
    }
}
