package com.example.springecosystem.json;

public class Shape {

    private ShapeType type;

    private String color;

    public Shape(ShapeType type, String color){
        this.type = type;
        this.color = color;
    }

    public Shape(){
        this.type = null;
        this.color = null;
    }

    public ShapeType getType() {
        return type;
    }

    public void setType(ShapeType type) {
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
