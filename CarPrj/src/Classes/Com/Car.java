package Classes.Com;

import java.lang.*;
import java.util.*;
import java.io.*;

public class Car {
    private String carID;
    Brand brand;
    private String color;
    private String frameID;
    private String engineID;

    public Car() {
    }

    public Car(String carID, String color, String frameID, String engineID) {
        this.carID = carID;
        this.color = color;
        this.frameID = frameID;
        this.engineID = engineID;
    }

    public String getCarID() {
        return carID;
    }

    public void setCarID(String carID) {
        this.carID = carID;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getFrameID() {
        return frameID;
    }

    public void setFrameID(String frameID) {
        this.frameID = frameID;
    }

    public String getEngineID() {
        return engineID;
    }

    public void setEngineID(String engineID) {
        this.engineID = engineID;
    }
    
    @Override
    public String toString() {
        return carID + ", " + brand.getBrandID() + ", " + color + ", " + frameID + ", " + engineID;
    }

    public String screenString() {
        return "Brand: " + brand.getBrandName() + "\nCar ID: " + carID + ", Color: " + color + ", Frame ID: " + frameID + ", Engine ID: " + engineID;
    }
    
}