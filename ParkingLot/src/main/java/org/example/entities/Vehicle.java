package org.example.entities;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Vehicle {

    public static enum Type {
        CAR, MOTORBIKE
    }

    String regNumber;
    Type type;
    Color color;
    String brand;
    String model;

}
