package entities;

public class Customer {
    private static long counter = 4536;

    //attributi
    private Long id;
    private String name;
    private Integer tier;

    //costruttori
    public Customer(String name, Integer tier) {
        this.id = ++counter;
        this.name = name;
        this.tier = tier;
    }

    //metodi

    public Integer getTier() {
        return tier;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tier=" + tier +
                '}';
    }
}
