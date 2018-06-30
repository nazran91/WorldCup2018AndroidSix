package com.aiub.worldcup2018androidsix.ModelClasses;

public class Team {

    private int id;
    private String icon, name, fifaCode;

    //ALT + Insert
    public Team(int id, String icon, String name, String fifaCode) {
        this.id = id;
        this.icon = icon;
        this.name = name;
        this.fifaCode = fifaCode;
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

    public String getfifaCode() {
        return fifaCode;
    }

    public void setfifaCode(String fifaCode) {
        this.fifaCode = fifaCode;
    }
}
