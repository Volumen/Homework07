package com.example.demo.enums;

public enum Mark {
    Opel("Opel"),
    Mercedes("Mercedes"),
    Fiat("Fiat"),
    Skoda("Skoda"),
    Porsche("Porsche"),
    Tesla("TESLA"),
    Toyota("Toyota"),
    Volkswagen("Volkswagen");

    private String mark;
    Mark(String mark) {
        this.mark = mark;
    }
    public String getMark()
    {
        return mark;
    }


}
