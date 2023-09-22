package unit.hw1.task2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Shop {
    public List<Product> products;

    public Shop() {
        products = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            products.add(new Product((int) (Math.random() * 1000)));
        }
    }

    public List<Product> sortProductsByPrice() {
        return products.stream()
                .sorted(Comparator.comparingInt((p) -> p.price)).toList();
    }

    public Product getMostExpensiveProduct() {
        List<Product> sorted = sortProductsByPrice();
        return sorted.get(sorted.size() - 1);
    }
}
