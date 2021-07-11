package com.personapp.personapi.enums;

public enum Type {
    HOME("home"),
    MOBILE("mobile"),
    COMMERCIAL("commercial");
    private String type;
    Type(String type){
        this.type=type;
    }
    public String getType(){
        return this.type;
    }
}
