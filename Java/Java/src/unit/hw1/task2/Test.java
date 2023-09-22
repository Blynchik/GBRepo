package unit.hw1.task2;

import org.assertj.core.api.Assertions;

import java.util.Comparator;

public class Test {

    public static void shopContentTest() {
        Shop shop = new Shop();
        Assertions.assertThat(shop.products.size()).isEqualTo(10);
        Assertions.assertThat(shop.products.stream()
                        .allMatch(p -> p.price < 1000))
                .isTrue();
    }

    public static void getMostExpensiveProductTest() {
        Shop shop = new Shop();
        Assertions.assertThat(shop.products.stream()
                        .allMatch(p -> p.price <= shop.getMostExpensiveProduct().price))
                .isTrue();
    }

    public static void sortProductsByPriceTest() {
        Shop shop = new Shop();
        Assertions.assertThat(shop.sortProductsByPrice())
                .isSortedAccordingTo(Comparator.comparingInt(p -> p.price));
    }
}
