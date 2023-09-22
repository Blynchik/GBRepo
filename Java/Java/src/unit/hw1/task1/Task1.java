package unit.hw1.task1;

public class Task1 {
    public static void main(String[] args) {
        Test.calcTotalTest();
    }

    public static Integer calcTotal(Integer sum, Integer discPercent) {
        if (sum <= 0 || discPercent < 0 || discPercent > 100) {
            throw new ArithmeticException("Incorrect input");
        }
        return sum - sum * discPercent / 100;
    }
}

