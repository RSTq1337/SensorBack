package com.project.lgnscrt.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "sensors")
public class Sensor  {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @NotNull
    private String name;

    @NotNull
    private String model;
    private int rangeFrom;
    private int rangeTo;

    @NotNull
    private Type type;

    @NotNull
    private Unit unit;

    @Size(max = 40)
    private String location;

    @Size(max = 200)
    private String description;

    public Sensor(@NotNull String name, @NotNull String model,
                  int rangeFrom, int rangeTo, @NotNull Type type,
                  @NotNull Unit unit, @Size(max = 40) String location,
                  @Size(max = 200) String description) {
        this.name = name;
        this.model = model;
        this.rangeFrom = rangeFrom;
        this.rangeTo = rangeTo;
        this.type = type;
        this.unit = unit;
        this.location = location;
        this.description = description;
    }

    public Sensor(@NotNull String name, @Size(max = 200) String description, @NotNull Type type ) {
        this.name = name;
        this.description = description;
        this.type = type;
    }

    public Sensor(@NotNull Type type, @NotNull Unit unit){
        this.type=type;
        this.unit=unit;
    }
}
