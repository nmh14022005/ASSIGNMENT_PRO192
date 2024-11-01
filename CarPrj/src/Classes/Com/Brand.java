package Classes.Com;

import java.lang.*;
import java.util.*;
import java.io.*;

public class Brand {

    private String brandID;
    private String brandName;
    private String soundBrand;
    private double price;

    public Brand() {
    }
// khởi tạo Brand

    public Brand(String brandID, String brandName, String soundBrand, double price) {
        this.brandID = brandID;
        this.brandName = brandName;
        this.soundBrand = soundBrand;
        this.price = price;
    }
// getter và setter cho từng thuộc tính

    public String getBrandID() {
        return brandID;
    }

    public void setBrandID(String brandID) {
        this.brandID = brandID;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getSoundBrand() {
        return soundBrand;
    }

    public void setSoundBrand(String soundBrand) {
        this.soundBrand = soundBrand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // trả về chuỗi gồm ID name sound và price
    @Override
    public String toString() {
        return "<" + brandID + "," + brandName + "," + soundBrand + "," + price + ">";
    }
}
