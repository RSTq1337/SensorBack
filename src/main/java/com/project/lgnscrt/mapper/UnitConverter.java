package com.project.lgnscrt.mapper;

import com.project.lgnscrt.entity.enums.Unit;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class UnitConverter implements AttributeConverter<Unit, String > {
    @Override
    public String convertToDatabaseColumn(Unit unit) {
        if (unit == null) {
            return null;
        }
        return unit.getCode();
    }

    @Override
    public Unit convertToEntityAttribute(String code) {
        if (code == null) {
            return null;
        }

        return Stream.of(Unit.values())
                .filter(c -> c.getCode().equals(code))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
