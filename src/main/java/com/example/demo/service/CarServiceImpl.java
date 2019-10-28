package com.example.demo.service;

import com.example.demo.enums.Color;
import com.example.demo.enums.CountryOfManufactured;
import com.example.demo.enums.Mark;
import com.example.demo.enums.Model;
import com.example.demo.model.Car;
import com.example.demo.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CarServiceImpl implements CarService {

    private CarRepository carRepository;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public CarServiceImpl(CarRepository carRepository, JdbcTemplate jdbcTemplate) {
        this.carRepository = carRepository;
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void saveCar(Long id, Car car) {
        //Car car = new Car(id,mark,model,color,countryOfManufactured,year);

        String sql = "INSERT INTO cars VALUES (?,?,?,?,?,?)";
        jdbcTemplate.update(sql,id,car.getMark().toString(),car.getModel().toString(),car.getColor().toString(),car.getCountryOfManufactured().toString(),car.getYear());

    }

    @Override
    public List<Car> findAllCars() {
        carRepository.findAllCars().removeAll(carRepository.findAllCars());
        String sql = "SELECT * FROM cars";
        parseValuesFromDb(sql);
        return carRepository.findAllCars();
    }

    @Override
    public List<Car> findCarsByYears(int sinceYear, int toYear) {
        carRepository.findAllCars().removeAll(carRepository.findAllCars());
        String sql = "SELECT * FROM cars WHERE year BETWEEN "+sinceYear+" AND "+toYear;
//        jdbcTemplate.queryForList(sql);
        parseValuesFromDb(sql);
        return carRepository.findAllCars();
    }

    private void parseValuesFromDb(String sql) {
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        maps.stream().forEach(element -> carRepository.findAllCars().add(new Car(
                Long.parseLong(String.valueOf(element.get("car_id"))),
                Mark.valueOf(String.valueOf(element.get("mark"))),
                Model.valueOf(String.valueOf(element.get("model"))),
                Color.valueOf(String.valueOf(element.get("color"))),
                CountryOfManufactured.valueOf(String.valueOf(element.get("countryOfManufactured"))),
                Integer.parseInt(String.valueOf(element.get("year")))
        )));
    }

//    @Override
//    public void deleteCar(Long id) {
//        String sql = "DELETE FROM cars WHERE car_id = ?";
//        jdbcTemplate.update(sql, id);
//    }

}
