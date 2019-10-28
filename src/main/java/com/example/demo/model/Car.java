package com.example.demo.model;

import com.example.demo.enums.Color;
import com.example.demo.enums.CountryOfManufactured;
import com.example.demo.enums.Mark;
import com.example.demo.enums.Model;

public class Car {

    private long id;
    private Mark mark;
    private Model model;
    private Color color;
    private CountryOfManufactured countryOfManufactured;
    private int year;

    public Car(long id, Mark mark, Model model, Color color, CountryOfManufactured countryOfManufactured, int year) {
        this.id = id;
        this.mark = mark;
        this.model = model;
        this.color = color;
        this.countryOfManufactured = countryOfManufactured;
        this.year = year;
    }

    public Car() {
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", mark=" + mark +
                ", model=" + model +
                ", color=" + color +
                ", countryOfManufactured=" + countryOfManufactured +
                ", year=" + year +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Mark getMark() {
        return mark;
    }

    public void setMark(Mark mark) {
        this.mark = mark;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public CountryOfManufactured getCountryOfManufactured() {
        return countryOfManufactured;
    }

    public void setCountryOfManufactured(CountryOfManufactured countryOfManufactured) {
        this.countryOfManufactured = countryOfManufactured;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
