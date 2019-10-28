package com.example.demo.service;



import com.example.demo.model.Car;

import java.util.List;

public interface CarService {
    void saveCar(Long id, Car car);
    List<Car> findAllCars();
    List<Car> findCarsByYears(int sinceYear, int toYear);
    //void deleteCar(Long id);
}
