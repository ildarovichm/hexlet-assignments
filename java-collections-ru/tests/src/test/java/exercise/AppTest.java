package exercise;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AppTest {
    List<Integer> numbers1;
    List<Integer> numbers2;
    List<Integer> numbers3;
    List<Integer> numbers4;

    void numbersForTests(){
        this.numbers1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        this.numbers2 = new ArrayList<>(Arrays.asList(7, 3, 10));
        this.numbers3 = new ArrayList<>(Arrays.asList(11, 11, 12, 15));
        this.numbers4 = new ArrayList<>(Arrays.asList(2, 2, 9, 4));
    }
    @Test
    void testTake1() {
        // BEGIN
        numbersForTests();
        List<Integer> resultList = App.take(numbers1, 2);
        List<Integer> expected = new ArrayList<>(List.of(1, 2));
        assertThat(resultList).isEqualTo(expected);
        // END
    }
    @Test
    void testTake2() {
        // BEGIN
        numbersForTests();
        List<Integer> resultList = App.take(numbers2, 4);
        List<Integer> expected = new ArrayList<>(List.of(7, 3, 10));
        assertThat(resultList).isEqualTo(expected);
        // END
    }
    @Test
    void testTake3() {
        // BEGIN
        numbersForTests();
        List<Integer> resultList = App.take(numbers3, 1);
        List<Integer> expected = new ArrayList<>(List.of(11));
        assertThat(resultList).isEqualTo(expected);
        // END
    }
    @Test
    void testTake4() {
        // BEGIN
        numbersForTests();
        List<Integer> resultList = App.take(numbers4, 9);
        List<Integer> expected = new ArrayList<>(List.of(2, 2, 9, 4));
        assertThat(resultList).isEqualTo(expected);
        // END
    }
}
