package model;

public class Product {
    private int masp;
    private String name;
    private double price;
    private int quantity;

    public Product() {
    }

    public Product(int masp, String name, double price, int quantity) {
        this.masp = masp;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public int getMasp() {
        return masp;
    }

    public void setMasp(int masp) {
        this.masp = masp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Product{" +
                "masp=" + masp +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                "}\n";
    }
}
