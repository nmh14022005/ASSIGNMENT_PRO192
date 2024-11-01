
package Classes.Com;

import java.lang.*;
import java.util.*;
import java.io.*;
/**
 * 
 * @author NDT
 */
public class BrandList {
  private ArrayList<Brand> brands;

    //khởi tạo BrandList
    public BrandList() {
        brands = new ArrayList<>();
    }

    // tải dữ liệu từ file vào list
    public boolean loadFromFile(String filename) {
        File file = new File(filename);
        
        // kiểm tra sự tồn tại
        if (!file.exists()) {
            System.out.println("File not found.");
            return false;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;

            while ((line = br.readLine()) != null) {
                // chia làm các phần
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    String brandID = parts[0];
                    String brandName = parts[1];
                    String soundBrand = parts[2];
                    double price = Double.parseDouble(parts[3]);

                    // tạo một đối tượng brand mới và thêm vào danh sách
                    Brand brand = new Brand(brandID, brandName, soundBrand, price);
                    brands.add(brand);
                }
            }
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    // lưu danh sách các thương hiệu vào file
    public boolean saveToFile(String filename) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            // ghi thương hiệu trong danh sách vào file
            for (Brand brand : brands) {
                bw.write(brand.toString());
                bw.newLine();
            }
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }


    public int searchID(String brandID) {
        int n = brands.size();
        // kiểm tra danh sách thương hiệu ứng với ID
        for (int i = 0; i < n; i++) {
            if (brands.get(i).getBrandID().equals(brandID)) {
                return i;  // trả kết quả về nếu thấy
            }
        }
        return -1;  // trả về kết quả -1 nếu không tìm thấy
    }
}
