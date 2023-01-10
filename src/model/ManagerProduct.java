package model;

import Manager.ReadandWrite;

import java.util.*;

public class ManagerProduct {
    Scanner scanner = new Scanner(System.in);
    List<Product> listProduct;
    ReadandWrite readandWrite = new ReadandWrite();
    int id = 0;

    public ManagerProduct() {
        listProduct = new ArrayList<>();
        listProduct = readandWrite.read();
    }

    public Product creatProduct() {
        id++;
        System.out.println("nhập tên sản phẩm");
        String name = scanner.nextLine();
        System.out.println(" nhập giá sản phẩm");
        double price = Double.parseDouble(scanner.nextLine());
        System.out.println(" nhập số lượng sản phẩm");
        int quantity = Integer.parseInt(scanner.nextLine());
        Product product = new Product(id, name, price, quantity);
        return product;
    }

    public void showProduct() {
        for (int i = 0; i < listProduct.size(); i++) {
            System.out.println(listProduct.get(i).toString());

        }
    }

    public void add() {
        Product products = creatProduct();
        listProduct.add(products);
        readandWrite.writefile(listProduct);
    }

    public int findByID() {
        showProduct();
        System.out.println(" nhập id muốn tìm");
        do {
            try {
                int id = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println(" nhập số");
            }
        } while (true);


        for (int i = 0; i < listProduct.size(); i++) {
            if (listProduct.get(i).getMasp() == id) {
                return i;
            }

        }
        return -1;

    }

    public void deleteProduct() {

        System.out.println(" nhập mã muốn xóa");
        int index = findByID();
        if (index == -1) {
            System.out.println(" không tìm thấy sản phẩm");
        } else {
            listProduct.remove(index);
            readandWrite.writefile(listProduct);
        }
    }

    public void editProduct() {
        int index = findByID();
        if (index == -1) {
            System.out.println(" sản phẩm không tồn tại");
        } else {
            System.out.println("muốn sửa gì?????");
            System.out.println("1:  sửa tên");
            System.out.println("2: sửa số lượng");
            System.out.println("3: sửa giá sp");
            int choi = Integer.parseInt(scanner.nextLine());
            switch (choi) {
                case 1:
                    System.out.println("Nhập tên muốn sửa");
                    String newname = scanner.nextLine();
                    listProduct.get(index).setName(newname);
                    readandWrite.writefile(listProduct);

                    break;
                case 2:
                    int newquantity;
                    System.out.println(" nhập số lượng");
                    do {
                        try {
                            newquantity = Integer.parseInt(scanner.nextLine());
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println(" vui  lòng nhập số");
                        }
                    } while (true);
                    listProduct.get(index).setQuantity(newquantity);
                    readandWrite.writefile(listProduct);

                    break;
                case 3:
                    double newprice;
                    System.out.println(" nhập giá");
                    do {
                        try {
                            newprice = Double.parseDouble(scanner.nextLine());
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println(" vui lòng nhập số");
                        }
                    } while (true);
                    listProduct.get(index).setPrice(newprice);
                    readandWrite.writefile(listProduct);

                    break;
            }
        }


    }

    public void sort() {
        Collections.sort(listProduct, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return (int) (o1.getPrice() - o2.getPrice());
            }
        });
        System.out.println(listProduct );
        System.out.println("sản phẩm có giá cao nhất là:");
        for (Product p:listProduct) {
            if(p.getPrice()==listProduct.get(listProduct.size()-1).getPrice()){
                System.out.println(p);
            }
        }
        readandWrite.writefile(listProduct);
    }
}
