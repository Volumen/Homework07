package com.example.demo.gui;

import com.example.demo.enums.Color;
import com.example.demo.enums.CountryOfManufactured;
import com.example.demo.enums.Mark;
import com.example.demo.enums.Model;
import com.example.demo.model.Car;
import com.example.demo.repository.CarRepository;
import com.example.demo.service.CarService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.EnumSet;


@Route("")
public class CarGui extends VerticalLayout {

    private CarRepository carRepository;
    private CarService carService;
    private Button addCarButton;
    private Button filterCarsButton;
    private Button showAllCarsButton;
    private HorizontalLayout addCarHorizontalLayout;
    private HorizontalLayout filterHorizontalLayout;
    private Grid<Car> carGrid;

    private ComboBox<Mark> markComboBox;
    private ComboBox<Model> modelComboBox;
    private ComboBox<Color> colorComboBox;
    private ComboBox<CountryOfManufactured> countryOfManufacturedComboBox;

    private TextField yearTextField;
    private TextField sinceYearTextField;
    private TextField toYearTextField;
    private Notification notification;

    @Autowired
    public CarGui(CarService carService, CarRepository carRepository) {
        this.carService = carService;
        this.carRepository = carRepository;
        addCarHorizontalLayout = new HorizontalLayout();
        filterHorizontalLayout = new HorizontalLayout();

        notification = new Notification();
        notification.setDuration(2000);

        markComboBox = new ComboBox<>("Mark");
        modelComboBox = new ComboBox<>("Model");
        colorComboBox = new ComboBox<>("Color");
        countryOfManufacturedComboBox = new ComboBox<>("Country");
        yearTextField = new TextField("Year");
        sinceYearTextField = new TextField();
        sinceYearTextField.setPlaceholder("Since");
        toYearTextField = new TextField();
        toYearTextField.setPlaceholder("To");
        markComboBox.setItems(EnumSet.allOf(Mark.class));
        modelComboBox.setItems(EnumSet.allOf(Model.class));
        colorComboBox.setItems(EnumSet.allOf(Color.class));
        countryOfManufacturedComboBox.setItems(EnumSet.allOf(CountryOfManufactured.class));


        this.setAlignItems(Alignment.CENTER);
        addCarButton = new Button("Add Car");
        addCarButton.getStyle().set("margin-top","36px");
        showAllCarsButton = new Button("Show all cars");
        filterCarsButton = new Button("Show cars by date");

        carGrid = new Grid<>();
        carGrid.setItems(carService.findAllCars());
        carGrid.addColumn(Car::getId).setHeader("Id");
        carGrid.addColumn(Car::getMark).setHeader("Mark");
        carGrid.addColumn(Car::getModel).setHeader("Model");
        carGrid.addColumn(Car::getColor).setHeader("Color");
        carGrid.addColumn(Car::getCountryOfManufactured).setHeader("Country");
        carGrid.addColumn(Car::getYear).setHeader("Year");

        addCarButton.addClickListener(clickEvent -> {
            Car tempCar = new Car();
            addCar(tempCar);
            carGrid.setItems(carService.findAllCars());
        });
        filterCarsButton.addClickListener(clickEvent ->
        {
            if(checkYearsFields()) {
                carGrid.setItems(carService.findCarsByYears(Integer.parseInt(sinceYearTextField.getValue()), Integer.parseInt(toYearTextField.getValue())));
            }
        });
        showAllCarsButton.addClickListener(clickEvent ->
        {
            carGrid.setItems(carService.findAllCars());
        });

        addCarHorizontalLayout.add(markComboBox,modelComboBox,colorComboBox,countryOfManufacturedComboBox,yearTextField,addCarButton);
        filterHorizontalLayout.add(sinceYearTextField,toYearTextField,filterCarsButton);

        add(addCarHorizontalLayout,filterHorizontalLayout,showAllCarsButton,carGrid);


    }

    private boolean checkYearsFields() {
        if(!sinceYearTextField.isEmpty() && !toYearTextField.isEmpty())
        {
            return true;
        }
        else {return false;}
    }

    public void addCar(Car car)
    {
        if(checkCar(car))
        {
            Long id = carRepository.lastIndexOfCars() + 1;
            carService.saveCar(id,car);
        }

    }
    public boolean checkCar(Car car)
    {
        if(!colorComboBox.isEmpty() && !markComboBox.isEmpty() && !modelComboBox.isEmpty() && !countryOfManufacturedComboBox.isEmpty() && !yearTextField.isEmpty()) {
            car.setColor(colorComboBox.getValue());
            car.setMark(markComboBox.getValue());
            car.setModel(modelComboBox.getValue());
            car.setCountryOfManufactured(countryOfManufacturedComboBox.getValue());
            car.setYear(Integer.parseInt(yearTextField.getValue()));
            return true;
        }
        else
        {
            addNotification("You need to complete all fields to add a car!");
            return false;
        }
    }
    private void addNotification(String words)
    {
        notification.show(words);
        notification.open();
    }
}
