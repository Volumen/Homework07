package com.example.demo.repository;

import com.example.demo.model.Car;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CarRepository {

    private List<Car> listOfCars;

    public CarRepository() {
        this.listOfCars = new ArrayList<>();
    }
    public List<Car> findAllCars()
    {
        return listOfCars;
    }
    public Long lastIndexOfCars(){return listOfCars.get(listOfCars.size()-1).getId();}
}
