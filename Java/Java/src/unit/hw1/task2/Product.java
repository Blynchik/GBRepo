package unit.hw1.task2;

public class Product {
    public Integer price;

    public Product(Integer price){
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "price=" + price +
                '}';
    }
}
