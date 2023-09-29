package unit.hw3.task2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class Sol {
    /**
     * Разработайте и протестируйте метод numberInInterval,
     * который проверяет, попадает ли
     * переданное число в интервал (25;100)
     */

    public boolean numberInInterval(int n) {
        return n > 25 && n < 100;
    }

    @Test
    void numberInInterval_trueTest(){
        Assertions.assertTrue(numberInInterval(50));
    }

    @ParameterizedTest
    @ValueSource(ints = {25, 100})
    void numberInInterval_falseTest(int i){
        Assertions.assertFalse(numberInInterval(i));
    }
}
