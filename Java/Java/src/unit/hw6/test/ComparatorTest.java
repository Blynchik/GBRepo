package unit.hw6.test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import unit.hw6.Comparator;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ComparatorTest {
    Comparator comparator;

    List<Integer> list1;
    List<Integer> list2;
    ByteArrayOutputStream toShow;
    PrintStream originalOut;

    @BeforeEach
    void setUp() {
        comparator = new Comparator();
        list1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 0));
        list2 = new ArrayList<>(Arrays.asList(7, 8, 9, 10, 11, 12, 13));
        toShow = new ByteArrayOutputStream();
        originalOut = System.out;
        System.setOut(new PrintStream(toShow));
    }

    @AfterEach
    void afterEach() {
        System.setOut(originalOut);
    }

    @Test
    void test_getAvg_NotEmptyList() {
        //given
        Double expected = 3.0;

        //when
        Double actual = comparator.getAvg(list1);

        //then
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void test_getAvg_EmptyList() {
        //given
        Double expected = 0.0;

        //when
        Double actual = comparator.getAvg(Collections.emptyList());

        //then
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void test_getAvg_NullList() {
        //given
        Double expected = 0.0;

        //when
        Double actual = comparator.getAvg(null);

        //then
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void test_compare_avg1More() {
        //given
        String expected = "Первый список имеет большее среднее значение";

        //when
        comparator.compare(list2, list1);
        String actual = toShow.toString().trim();

        //then
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void test_compare_avg2More() {
        //given
        String expected = "Второй список имеет большее среднее значение";

        //when
        comparator.compare(list1, list2);
        String actual = toShow.toString().trim();

        //then
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void test_compare_avgEquals() {
        //given
        String expected = "Средние значения равны";

        //when
        comparator.compare(list1, list1);
        String actual = toShow.toString().trim();

        //then
        Assertions.assertEquals(expected, actual);
    }
}
