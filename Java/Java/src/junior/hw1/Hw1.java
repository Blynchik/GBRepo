package junior.hw1;

import java.util.List;

public class Hw1 {

    public static void main(String[] args) {
        List<Integer> nums = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        method(nums);

    }

    public static void method(List<Integer> nums) {
        System.out.println(nums.stream()
                .filter(num -> num % 2 == 0)
                .mapToInt(Integer::intValue).average());
    }
}
