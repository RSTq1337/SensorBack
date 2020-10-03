package com.project.lgnscrt.controller;


import com.project.lgnscrt.SensorService;
import com.project.lgnscrt.entity.Sensor;
import com.project.lgnscrt.mapper.SensorDto;
import com.project.lgnscrt.mapper.SensorMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/api")
public class SensorController {

    final SensorService sensorService;
//    final HibernateSearchService searchService;

    public SensorController(SensorService sensorService
//                            HibernateSearchService searchService
    ) {
        this.sensorService = sensorService;
//        this.searchService = searchService;
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

//    @GetMapping("/sensor-list/search")
//    public List<SensorDto> search(@RequestParam(value = "search", required = false) String q) {
//        List<Sensor> searchResults = null;
//        try {
//            searchResults = searchService.fuzzySearch(q);
//
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//        assert searchResults != null;
//        return searchResults.stream()
//                .map(SensorMapper.INSTANCE::sensorToSensorDto)
//                .collect(Collectors.toList());
//    }
}
