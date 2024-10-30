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
}    