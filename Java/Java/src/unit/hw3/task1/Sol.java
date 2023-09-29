package unit.hw3.task1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Sol {
    /**
     * Напишите тесты, покрывающие на 100% метод evenOddNumber,
     * который проверяет, является ли
     * переданное число четным или нечетным:
     **/
    public boolean evenOddNumber(int n) {
        if (n % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }

    @Test
    void evenOddNumber_oddTest(){
        Assertions.assertThat(this.evenOddNumber(18)).isTrue();
    }

    @Test
    void evenOddNumber_notOddTest(){
        Assertions.assertThat(this.evenOddNumber(19)).isFalse();
    }
}
