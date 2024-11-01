
package Classes.Com;

import java.lang.*;
import java.util.*;
import java.io.*;
/**
 *
 * @author nmh
 */
public class Menu {
    // Phương thức lấy lựa chọn từ người dùng dựa trên danh sách các lựa chọn

    public int int_getChoice(ArrayList<String> options) {
        Scanner scanner = new Scanner(System.in);
        int response = -1;
        int N = options.size(); // Số lượng lựa chọn trong danh sách

        // Hiển thị danh sách lựa chọn cho người dùng
        for (int i = 0; i < N; i++) {
            System.out.println((i + 1) + ". " + options.get(i));
        }

        // Yêu cầu người dùng chọn một lựa chọn hợp lệ
        System.out.print("Please choose an option 1.." + N + ": ");

        // Đảm bảo rằng người dùng nhập một số hợp lệ
        boolean validInput = false;
        while (!validInput) {
            try {
                response = Integer.parseInt(scanner.nextLine());
                if (response >= 1 && response <= N) {
                    validInput = true;
                } else {
                    System.out.print("Invalid choice. Please choose an option 1.." + N + ": ");
                }
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter a number between 1 and " + N + ": ");
            }
        }

        return response;
    }
}
