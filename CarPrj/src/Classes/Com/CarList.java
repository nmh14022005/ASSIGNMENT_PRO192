package Classes.Com;

import java.lang.*;
import java.util.*;
import java.io.*;
/**
 *
 * @author NguyenVietThangHe190928
 */
class CarList {
    private ArrayList<Car> cars = new ArrayList<>();
    private BrandList brandList; 

    public CarList(BrandList brandList) {
        this.brandList = brandList;
    }

    public boolean loadFromFile(String filename) {
        // Implement reading from cars.txt
        return true;
    }

    public boolean saveToFile(String filename) {
        // Implement saving to cars.txt
        return true;
    }

    public int searchID(String carID) {
        for (int i = 0; i < cars.size(); i++) {
            if (cars.get(i).getCarID().equals(carID)) {
                return i;
            }
        }
        return -1; 
    }

    public int searchFrame(String frameID) {
        for (int i = 0; i < cars.size(); i++) {
            if (cars.get(i).getFrameID().equals(frameID)) {
                return i;
            }
        }
        return -1; 
    }

    public int searchEngine(String engineID) {
        for (int i = 0; i < cars.size(); i++) {
            if (cars.get(i).getEngineID().equals(engineID)) {
                return i;
            }
        }
        return -1; 
    }
    
    public void addCar(String carID, String brandID, String color, String frameID, String engineID) {
        if (searchID(carID) != -1 || searchFrame(frameID) != -1 || searchEngine(engineID) != -1) {
            System.out.println("Error: Car ID, frame ID, or engine ID is duplicated.");
            return;
        }
        if (color.isEmpty()|| !frameID.matches("F\\d{5}") || !engineID.matches("E\\d{5}")) {
            System.out.println("Error: Invalid car details.");
            return;
        }
        Brand brand = brandList.getBrandByID(brandID);
        if (brand == null) {
            System.out.println("Error: Brand ID does not exist.");
            return;
        }
        cars.add(new Car(carID, brand, color, frameID, engineID));
        System.out.println("Car added successfully.");
    }

    public boolean removeCar(String carID) {
        int pos = searchID(carID);
        if (pos == -1) {
            System.out.println("Car not found.");
            return false;
        }
        cars.remove(pos);
        System.out.println("Car removed successfully.");
        return true;
    }

    public boolean updateCar(String carID, String newBrandID, String newColor, String newFrameID, String newEngineID) {
        int pos = searchID(carID);
        if (pos == -1) {
            System.out.println("Car not found.");
            return false;
        }
        Car car = cars.get(pos);
        if (searchFrame(newFrameID) != -1 || searchEngine(newEngineID) != -1) {
            System.out.println("Error: Frame ID or engine ID is duplicated.");
            return false;
        }
        Brand brand = brandList.getBrandByID(newBrandID);
        if (brand == null) {
            System.out.println("Error: Brand ID does not exist.");
            return false;
        }
        car.setBrand(brand);
        car.setColor(newColor);
        car.setFrameID(newFrameID);
        car.setEngineID(newEngineID);
        System.out.println("Car updated successfully.");
        return true;
    }

    public void listCars() {
        cars.sort(Comparator.comparing(car -> car.getBrand().getBrandName()));
        for (Car car : cars) {
            System.out.println(car.screenString());
        }
    }

    public void printBasedBrandName(String partOfBrandName) {
        int count = 0;
        for (Car car : cars) {
            if (car.getBrand().getBrandName().contains(partOfBrandName)) {
                System.out.println(car.screenString());
                count++;
            }
        }
        if (count == 0) {
            System.out.println("No car found with the specified brand name part.");
        }
    }
}    