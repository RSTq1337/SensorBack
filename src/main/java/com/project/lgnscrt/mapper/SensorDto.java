package com.project.lgnscrt.mapper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.bytebuddy.implementation.bind.annotation.Default;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class SensorDto {

    public long id;
    public String name;
    public String model;
    public int rangeFrom;
    public int rangeTo;
    public String type;
    public String unit;
    public String location;
    public String description;

    public SensorDto(String name,  String model,
                  int rangeFrom, int rangeTo, String type,
                  String unit,  String location,
                  String description) {
        this.name = name;
        this.model = model;
        this.rangeFrom = rangeFrom;
        this.rangeTo = rangeTo;
        this.type = type;
        this.unit = unit;
        this.location = location;
        this.description = description;
    }

    public SensorDto( long id, String name, String description, String type) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.type = type;
    }

    public SensorDto(String type,  String unit){
        this.type=type;
        this.unit=unit;
    }
}
