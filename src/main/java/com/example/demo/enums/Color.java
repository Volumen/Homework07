package com.example.demo.enums;


public enum Color {
    Green("green"),
    Black("black"),
    Red("red"),
    Blue("blue"),
    White("white"),
    Yellow("yellow"),
    Silver("silver");

    private String color;


    Color(String color)
    {
        this.color = color;
    }
    public String getColor()
    {
        return color;
    }

}
