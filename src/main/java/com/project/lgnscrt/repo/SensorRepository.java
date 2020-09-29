package com.project.lgnscrt.repo;

import com.project.lgnscrt.entity.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SensorRepository extends JpaRepository<Sensor, Long> {

}
