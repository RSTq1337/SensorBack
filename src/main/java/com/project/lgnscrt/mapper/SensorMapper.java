package com.project.lgnscrt.mapper;

import com.project.lgnscrt.dto.SensorDto;
import com.project.lgnscrt.entity.Sensor;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SensorMapper {

    SensorMapper INSTANCE = Mappers.getMapper(SensorMapper.class);

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "model", target = "model"),
            @Mapping(source = "rangeFrom",target = "rangeFrom"),
            @Mapping(source = "rangeTo", target = "rangeTo"),
            @Mapping(source = "location", target = "location"),
            @Mapping(source = "description", target = "description")
    })
    @ValueMappings({
            @ValueMapping(source = "type",target = "type"),
            @ValueMapping(source = "unit",target = "unit")
    })
    SensorDto sensorToSensorDto(Sensor sensor);

    @InheritInverseConfiguration
    Sensor sensorDtoToSensor(SensorDto sensorDto);
}
