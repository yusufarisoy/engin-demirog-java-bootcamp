package Sale;

public class Game
{
    private final Long id;
    private double price;
    private String name;
    private double discount;

    public Game(Long id, double price, String name, double discount)
    {
        this.id = id;
        this.price = price;
        this.name = name;
        this.discount = discount;
    }

    public Long getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}
