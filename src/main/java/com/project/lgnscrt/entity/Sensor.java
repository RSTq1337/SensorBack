package com.project.lgnscrt.entity;

import com.project.lgnscrt.entity.enums.Type;
import com.project.lgnscrt.entity.enums.Unit;
import lombok.*;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.FieldBridge;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Store;
import org.hibernate.search.bridge.builtin.EnumBridge;

import javax.persistence.*;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

@Entity
@Indexed
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "sensors")
public class Sensor  {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @NotNull
    @Field(store = Store.YES)
    private String name;

    @NotNull
    @Field(store = Store.YES)
    private String model;
    @Field(store = Store.YES)
    private int rangeFrom;
    @Field(store = Store.YES)
    private int rangeTo;

    @NotNull
    @Field(bridge=@FieldBridge(impl=EnumBridge.class), store = Store.YES)
    private Type type;

    @NotNull
    @Field(bridge=@FieldBridge(impl= EnumBridge.class), store = Store.YES)
    private Unit unit;

    @Size(max = 40)
    @Field(store = Store.YES)
    private String location;

    @Size(max = 200)
    @Field(store = Store.YES)
    private String description;

}
