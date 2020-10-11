package com.project.lgnscrt.dto;

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

}
