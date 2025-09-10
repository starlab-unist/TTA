// equiv_test_0.java
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.stream.Stream;

public class HumanEval_36 {

    private static Stream<Arguments> provideIntCases() {
        return Stream.of(
            Arguments.of(0),
            Arguments.of(1),
            Arguments.of(7),
            Arguments.of(10),
            Arguments.of(25),
            Arguments.of(50),
            Arguments.of(75),
            Arguments.of(100),
            Arguments.of(125),
            Arguments.of(300)
        );
    }

    private static Stream<Arguments> provideStringCases() {
        return Stream.of(
            Arguments.of(""),
            Arguments.of("a"),
            Arguments.of("abc"),
            Arguments.of("hello"),
            Arguments.of("world"),
            Arguments.of("java"),
            Arguments.of("junit"),
            Arguments.of("testing"),
            Arguments.of("fizzbuzz"),
            Arguments.of("12345")
        );
    }

    @ParameterizedTest
    @MethodSource("provideIntCases")
    void fizzBuzz_vs_countSevensInSpecialNumbers_int(int input) {
        assertEquals(
            HumanEval_36_Source.fizzBuzz(input),
            HumanEval_36_Transformed.countSevensInSpecialNumbers(input)
        );
    }

    @ParameterizedTest
    @MethodSource("provideStringCases")
    void fizzBuzz_vs_countSevensInSpecialNumbers_string(String input) {
        assertEquals(
            HumanEval_36_Source.fizzBuzz(Integer.parseInt(input.replaceAll("\\D", ""))),
            HumanEval_36_Transformed.countSevensInSpecialNumbers(Integer.parseInt(input.replaceAll("\\D", "")))
        );
    }
}