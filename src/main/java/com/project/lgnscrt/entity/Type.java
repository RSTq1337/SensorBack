package com.project.lgnscrt.entity;

public enum Type {
    PRESSURE("Pressure"),
    VOLTAGE("Voltage"),
    TEMPERATURE("Temperature"),
    HUMIDITY("Humidity");

    private String code;

    Type(String code) {
        this.code = code;
    }
    public String getCode(){ return code;}
}
