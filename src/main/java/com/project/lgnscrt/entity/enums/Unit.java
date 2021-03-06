package com.project.lgnscrt.entity.enums;

public enum Unit {
    BAR("bar"),
    VOLTAGE("voltage"),
    CELSIUS("°C"),
    PERCENT("%");

    private String code;

    Unit(String code ) {
        this.code = code;
    }

    public String getCode(){
        return code;
    }
}
