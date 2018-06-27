package com.aiub.worldcup2018androidsix.ModelClasses;

public class Team {

    private int id;
    private String icon, name, country;

    //ALT + Insert
    public Team(int id, String icon, String name, String country) {
        this.id = id;
        this.icon = icon;
        this.name = name;
        this.country = country;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
