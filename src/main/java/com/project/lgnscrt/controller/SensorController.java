package com.project.lgnscrt.controller;

import com.project.lgnscrt.SensorService;
import com.project.lgnscrt.entity.Sensor;
import com.project.lgnscrt.mapper.SensorDto;
import com.project.lgnscrt.mapper.SensorMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/api")
public class SensorController {

    final SensorService sensorService;

    public SensorController(SensorService sensorService) {
        this.sensorService = sensorService;
    }

    @PostMapping("/save-sensor")
    public void createSensor(@RequestBody SensorDto sensorDto) {
        sensorService.save(SensorMapper.INSTANCE.sensorDtoToSensor(sensorDto));
    }

    @GetMapping("/sensor-list")
    public List<SensorDto> getSensors(){
       return sensorService.listAll().stream()
               .map(SensorMapper.INSTANCE::sensorToSensorDto)
               .collect(Collectors.toList());

    }

    @DeleteMapping("/delete-sensor/{id}")
    public void deleteSensor(@PathVariable("id") String id){
        sensorService.delete(Long.parseLong(id));
    }

    @PostMapping("/update-sensor/{id}")
    private void change(@PathVariable("id") String id,
                        @RequestBody SensorDto sensorDto){
        sensorDto.setId(Long.parseLong(id));
        sensorService.save(SensorMapper.INSTANCE.sensorDtoToSensor(sensorDto));
    }

    @GetMapping("/sensor/{id}")
    private SensorDto sensorById(@PathVariable("id") String id){
        return SensorMapper.INSTANCE.sensorToSensorDto(sensorService.get(Long.parseLong(id)));
    }
}
