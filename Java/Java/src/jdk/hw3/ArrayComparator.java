package jdk.hw3;

public class ArrayComparator {
    /**
     * Напишите обобщенный метод compareArrays(), который принимает два
     * массива и возвращает true, если они одинаковые, и false в противном
     * случае. Массивы могут быть любого типа данных, но должны иметь
     * одинаковую длину и содержать элементы одного типа.
     */
    public static <T> Boolean compareArrays(T[] array1, T[] array2) {
        if (array1.length != array2.length) {
            return false;
        }
        for (T t : array1) {
            for (T value : array2) {
                if (!t.getClass().equals(value.getClass())) {
                    return false;
                }
            }
        }
        return true;
    }
}
