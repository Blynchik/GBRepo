import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HW3 {
    static List<Integer> numbers;

    public static void main(String[] args) {
        HW3 hw3 = new HW3();
        hw3.fillList();

        System.out.print("Начальный список: ");
        System.out.println(numbers);

        //Пусть дан произвольный список целых чисел, удалить из него четные числа
        System.out.print("Нечетные: ");
        System.out.println(hw3.getOdds(numbers));

        //Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее арифметическое из этого списка. Collections.max()
        System.out.print("Максимальное: ");
        System.out.println(Collections.max(numbers));
        System.out.print("Минимальное: ");
        System.out.println(Collections.min(numbers));
        System.out.print("Среднее арифметическое:");
        System.out.println(numbers.stream().mapToInt(Integer::intValue).sum() / (double)numbers.size());
    }

    public void fillList() {
        numbers = new ArrayList<>();
        int amount = (int) (Math.random() * 20);

        for (int i = 0; i < amount; i++) {
            numbers.add((int) (Math.random() * 1000));
        }
    }

    public List<Integer> getOdds(List<Integer> numbers) {
        numbers.removeIf(number -> number % 2 == 0);
        return numbers;
    }
}
