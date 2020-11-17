package pl.dan.DPkurs.qajunit.junittest;

import org.junit.jupiter.api.*;
import pl.dan.qa.junit.GamePlay;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Junit tests")
public class JunitTest extends ConfigJunit {

    private static final String STRING_TEST = "stringTestowy";


    @DisplayName("First test")
    @Test
    @RepeatedTest(5)
    public void firstJunitTest() {
        assertTrue(5 == 2 + 3);
        assertFalse(5 == 3);
        assertTrue(STRING_TEST.contains("st"));
    }

    @DisplayName("Second test")
    @Test
    public void secondJunitTest() {
        double res = new BigDecimal("0.2").multiply(new BigDecimal("0.2")).doubleValue();
        assertTrue(res == 0.04);
    }

    @DisplayName("String test")
    @Test
    public void stringTest() {
        String str = "simple";
        String simple = "simple";

        String simpleStr = new String("str");
        String simpleStr2 = new String("str");

        assertTrue(str == "simple");
        assertTrue(str == simple);
        assertFalse(str == simpleStr);
        assertFalse(simpleStr2 == simpleStr);
        assertTrue(simpleStr2.equals(simpleStr));
        assertTrue(simpleStr2.equals(simpleStr));
    }

    @DisplayName("Google truth test")
    @Test
    public void googleTruthTest() {
        assertThat(STRING_TEST).contains("tring");
    }

    @Test
    public void zad1() {
        String resultString = "Wordpress powers 100% of the internet";
        String expectedString = "Wordpress powers %s";
        String expectedString2 = "% of the internet";

        assertTrue(resultString.equals(String.format(expectedString, "100").concat(expectedString2)));
        assertTrue(resultString.equals(String.format(expectedString, "100").concat(expectedString2)));
    }

    @DisplayName("Nested suite")
    @Nested
    public class NestedTest {

        @Test
        public void zad2() {

            List<Integer> result = Arrays.asList(1, 2, 3, 4, 5);
            List<Integer> expect = Arrays.asList(3, 4, 5);

            assertThat(result).containsAnyIn(expect);
            assertTrue(result.containsAll(expect));
            assertThat(result).hasSize(5);
            assertThat(result).containsAnyOf(1, 2, 3);
        }
    }

    @DisplayName("Exception test")
    @Test
    public void exceptionTest() {
        GamePlay gamePlay = new GamePlay();
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> {
                    gamePlay.play(0);
                }
        );
    }



}
