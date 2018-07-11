package com.aiub.worldcup2018androidsix.ModelClasses;

public class Team {

    private int id;
    private String icon, name, fifaCode, groupName;

    public Team(){

    }
    //ALT + Insert
    public Team(int id, String icon, String name, String fifaCode) {
        this.id = id;
        this.icon = icon;
        this.name = name;
        this.fifaCode = fifaCode;
    }

    public Team(int id, String name, String fifaCode, String groupName, String icon){
        this.id = id;
        this.name = name;
        this.fifaCode = fifaCode;
        this.groupName = groupName;
        this.icon = icon;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
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
