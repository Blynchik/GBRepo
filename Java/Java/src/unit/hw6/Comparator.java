package unit.hw6;

import java.util.List;

public class Comparator {

    public void compare(List<Integer> list1, List<Integer> list2) {
        if (getAvg(list1) > getAvg(list2)) {
            System.out.println("Первый список имеет большее среднее значение");
        } else if (getAvg(list1) < getAvg(list2)) {
            System.out.println("Второй список имеет большее среднее значение");
        } else {
            System.out.println("Средние значения равны");
        }
    }

    public Double getAvg(List<Integer> list) {
        if (list == null) {
            return 0.0;
        }
        return list.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0);
    }
}
