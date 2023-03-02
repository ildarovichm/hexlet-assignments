package exercise;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
public class ReversedSequenceTest  {

    CharSequence text = new ReversedSequence("abcdef");
    @Test
    void testReversedSequence() {
        String expected = "fedcba";
        System.out.println(text.toString());
        String result = text.toString(); // "fedcba"
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void testReversedSequence1() {
        char expected = 'e';
        char result = text.charAt(1); // 'e'
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void testReversedSequence2() {
        int expected = 6;
        int result = text.length();
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void testReversedSequence3() {
        String expected = "edc";
        String result = text.subSequence(1, 4).toString();
        assertThat(result).isEqualTo(expected);
    }

}
