package entities;

public class Product {

    private static long counter = 453;

    //attributi
    private Long id;
    private String name;
    private String category;
    private double price;

    //costruttori
    public Product(String name, String category, double price) {
        this.id = ++counter;
        this.name = name;
        this.category = category;
        this.price = price;

    }

    //metodi

    public Long getId() {
        return id;
    }

    public String getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }


    @Override
    public String toString() {
        return "Product{" +
                "category='" + category + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
