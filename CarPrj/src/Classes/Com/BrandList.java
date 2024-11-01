package Classes.Com;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

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

    // Phương thức để lấy lựa chọn của người dùng từ menu
    public Brand getUserChoice() {
        Menu mnu = new Menu();
        return (Brand) mnu.getChoice();
    }

    // Phương thức để thêm thương hiệu mới vào danh sách
    public void addBrand() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Brand ID: ");
        String id = scanner.nextLine();
        if (searchID(id) >= 0) {
            System.out.println("Brand ID already exists.");
            return;
        }

        System.out.print("Enter Brand Name: ");
        String brandName = scanner.nextLine();
        if (brandName.isBlank()) {
            System.out.println("Brand name cannot be blank.");
            return;
        }

        System.out.print("Enter Sound Brand: ");
        String soundBrand = scanner.nextLine();
        if (soundBrand.isBlank()) {
            System.out.println("Sound brand cannot be blank.");
            return;
        }

        System.out.print("Enter Price: ");
        double price = scanner.nextDouble();
        if (price <= 0) {
            System.out.println("Price must be greater than 0.");
            return;
        }

        Brand newBrand = new Brand(id, brandName, soundBrand, price);
        brands.add(newBrand);
        System.out.println("Brand added successfully.");
    }

    // Phương thức để cập nhật thương hiệu hiện có
    public void updateBrand() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Brand ID to update: ");
        String id = scanner.nextLine();
        int pos = searchID(id);

        if (pos < 0) {
            System.out.println("Not found!");
            return;
        }

        System.out.print("Enter new Brand Name: ");
        String brandName = scanner.nextLine();
        if (brandName.isBlank()) {
            System.out.println("Brand name cannot be blank.");
            return;
        }

        System.out.print("Enter new Sound Brand: ");
        String soundBrand = scanner.nextLine();
        if (soundBrand.isBlank()) {
            System.out.println("Sound brand cannot be blank.");
            return;
        }

        System.out.print("Enter new Price: ");
        double price = scanner.nextDouble();
        if (price <= 0) {
            System.out.println("Price must be greater than 0.");
            return;
        }

        Brand brandToUpdate = brands.get(pos);
        brandToUpdate.setBrandName(brandName);
        brandToUpdate.setSoundBrand(soundBrand);
        brandToUpdate.setPrice(price);
        System.out.println("Brand updated successfully.");
    }

    // Phương thức để liệt kê tất cả các thương hiệu
    public void listBrands() {
        int n = brands.size();
        for (int i = 0; i < n; i++) {
            System.out.println(brands.get(i));
        }
    }

}
