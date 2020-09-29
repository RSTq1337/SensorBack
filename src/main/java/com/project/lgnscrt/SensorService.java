package com.project.lgnscrt;

import com.project.lgnscrt.entity.Sensor;
import com.project.lgnscrt.mapper.SensorDto;
import com.project.lgnscrt.repo.SensorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SensorService {

    private final SensorRepository repository;

    public SensorService(SensorRepository repository) {
        this.repository = repository;
    }

    public List<Sensor> listAll() {
        return repository.findAll();
    }

    public void save(Sensor sensor) {
        repository.save(sensor);
    }

    public Sensor get(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
