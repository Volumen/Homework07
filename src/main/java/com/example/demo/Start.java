package com.example.demo;

import com.example.demo.service.CarService;
import org.springframework.stereotype.Component;

@Component
public class Start {
    private CarService carService;

    public Start(CarService carService) {
        this.carService = carService;


//        carService.saveCar(3L,Mark.Fiat,Model.Tipo,Color.Green,CountryOfManufactured.Poland,2017);
//        carService.saveCar(4L,Mark.Porsche,Model.Cayman,Color.Black,CountryOfManufactured.Germany,2019);
//        carService.saveCar(5L,Mark.Tesla,Model.Model_S,Color.Blue,CountryOfManufactured.China,2016);

//        carService.deleteCar(10L);

        //carService.findCarsByYears(2002,2012).forEach(System.out::println);

    //    carService.findAllCars().forEach(System.out::println);

    }
}
