package pl.dan.DPkurs.qajunit.junittest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Params test")
public class JunitParamsTest extends ConfigJunit {

    @DisplayName("First params test")
    @ParameterizedTest(name = "Parameter test with value 5.")
    @ValueSource(ints = {5, 15, 25})
    public void firsParamsTest(int number) {
        assertTrue(number % 5 == 0);
    }

    @DisplayName("Param test for string say hell")
    @ParameterizedTest(name = "Parameter test: {0}")
    @ValueSource(strings = {"Hello", "Hello Junit", "Hello students"})
    public void secondParamTest(String par) {
        assertThat(par).contains("Hello");
    }

    @DisplayName("Param test with multi param")
    @ParameterizedTest(name = "Parameter test for multi param: {0}, {1}")
    @CsvSource(value = {"Hello; 5", "Hello Junit; 5", "'Hello, students'; 25"}, delimiter = ';')
    public void multiParamTest(String par, int number) {
        assertThat(par).contains("Hello");
        assertTrue(number % 5 ==0);
    }

    @DisplayName("Param test with value from file csv")
    @ParameterizedTest(name = "Params test for multi parm: {0}, {1}")
    @CsvFileSource(resources = "/plik.csv",delimiter = ',')
    public void csvMultiParamTest(String par, int number){
        assertThat(par).contains("Hello");
        assertTrue(number % 5 ==0);
    }

    @DisplayName("Enum param test")
    @ParameterizedTest(name = "Enum param test: {0}")
    @EnumSource
    public void enumtest(ParamEnum paramEnum){
        assertThat(paramEnum.toString()).contains("ENUM");
    }

    String res ="Wordpress powers 100% of the internet";
    String expectedString = "Wordpress powers [number]% of the internet";

    @ParameterizedTest(name = "Wordpress test {0}")
    @ValueSource(strings = {"1","1000","10000"})
    public void wordpressTest(String s){
        String resultString = "Wordpress powers "+s+"% of the internet";

        assertThat(resultString).startsWith("Wordpress powers ");
        assertThat(resultString).endsWith("% of the internet");
        assertThat(resultString).matches("Wordpress powers \\d+% of the internet");
        String result = resultString.replace("Wordpress powers ", "").replace("% of the internet", "");
        assertThat(result).matches("^\\d+$");
        int resultNumber = Integer.parseInt(result);
        assertThat(resultNumber > 0);
    }


    enum ParamEnum{
        ENUM_ONE,
        ENUM_TWO
    }

}
