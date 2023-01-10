package model;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ManagerProduct managerProduct = new ManagerProduct();
        while (true) {
            System.out.println("1:Hiển thị sản phẩm");
            System.out.println(" 2: Thêm sản phẩm");
            System.out.println("3: Edit sản phẩm");
            System.out.println("4 xóa sản phẩm");
            System.out.println("5 : sắp xếp sản phẩm");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    managerProduct.showProduct();
                    break;
                case 2:
                    managerProduct.add();
                    break;
                case 3:
                    managerProduct.editProduct();
                    break;
                case 4:
                    managerProduct.deleteProduct();
                    break;
                case 5:
                    managerProduct.sort();
                    break;
                default:
                    return;
            }
        }
    }
}
