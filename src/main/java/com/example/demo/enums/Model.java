package com.example.demo.enums;

public enum Model {
    Polo("Polo"),
    Avensis("Avensis"),
    Tipo("Tipo"),
    Cayman("Cayman"),
    Model_S("MODEL S");


    private String model;
    Model(String model) {
        this.model = model;
    }
    public String getMark()
    {
        return model;
    }
}
