package com.project.lgnscrt;

import com.project.lgnscrt.entity.Sensor;
import com.project.lgnscrt.entity.Type;
import com.project.lgnscrt.entity.Unit;
import com.project.lgnscrt.mapper.SensorDto;
import com.project.lgnscrt.mapper.SensorMapper;

public class TestStuff {

    private static SensorMapper mapper;
    private static Sensor sensor = new Sensor(123,"Sensor1","Model1",1,10,Type.HUMIDITY,
            Unit.BAR,"russia","first description" );
    private static Sensor sensor1 = new Sensor(Type.HUMIDITY, Unit.BAR);

    public TestStuff(SensorMapper mapper) {
        TestStuff.mapper = mapper;
    }
    public static void doSomething(Sensor sensor){
        SensorDto first =SensorMapper.INSTANCE.sensorToSensorDto(sensor);
        System.out.println(first);
        Sensor second = SensorMapper.INSTANCE.sensorDtoToSensor(first);
        System.out.println(second);
    }

    public static void main(String[] args) {
        doSomething(sensor );
    }
}
