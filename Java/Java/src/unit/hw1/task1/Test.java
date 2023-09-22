package unit.hw1.task1;

import org.assertj.core.api.Assertions;

public class Test {

    public static void calcTotalTest() {
        Assertions.assertThat(Task1.calcTotal(1000, 5)).isEqualTo(950);
        Assertions.assertThatThrownBy(() -> Task1.calcTotal(-100, 5)).isInstanceOf(ArithmeticException.class);
        Assertions.assertThatThrownBy(() -> Task1.calcTotal(0, 5)).isInstanceOf(ArithmeticException.class);
        Assertions.assertThatThrownBy(() -> Task1.calcTotal(100, -1)).isInstanceOf(ArithmeticException.class);
        Assertions.assertThatThrownBy(() -> Task1.calcTotal(100, 101)).isInstanceOf(ArithmeticException.class);
    }
}
