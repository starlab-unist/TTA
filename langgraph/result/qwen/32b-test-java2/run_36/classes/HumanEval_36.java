{source_code}
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Source Code
static class HumanEval_36 {
    public static int fizzBuzz(int n) {
        List<Integer> ns = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (i % 11 == 0 || i % 13 == 0) {
                ns.add(i);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int num : ns) {
            sb.append(num);
        }
        String s = sb.toString();
        int ans = 0;
        for (char c : s.toCharArray()) {
            if (c == '7') {
                ans++;
            }
        }
        return ans;
    }
}

{transformed_code}
// Transformed Code
static class Transformed_HumanEval_36 {
    public static int countSevensInSpecialNumbers(int limit) {
        List<Integer> specialNumbers = new ArrayList<>();
        int index = 0;
        while (index < limit) {
            if (index % 11 == 0 || index % 13 == 0) {
                specialNumbers.add(index);
            }
            index++;
        }

        StringBuilder concatenatedString = new StringBuilder();
        for (int number : specialNumbers) {
            concatenatedString.append(number);
        }

        int sevenCount = 0;
        int position = 0;
        while (position < concatenatedString.length()) {
            if (concatenatedString.charAt(position) == '7') {
                sevenCount++;
            }
            position++;
        }

        return sevenCount;
    }
}

{test_cases}
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_36 {

    private static final Integer[] testCases = {
        0,
        1,
        25,
        50,
        75,
        100,
        125,
        150,
        200,
        300
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).map(Arguments::of);
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    @DisplayName("Compare fizzBuzz and countSevensInSpecialNumbers outputs")
    void fizzBuzz_vs_countSevensInSpecialNumbers(int input) {
        assertEquals(
            HumanEval_36.fizzBuzz(input),
            Transformed_HumanEval_36.countSevensInSpecialNumbers(input)
        );
    }
}