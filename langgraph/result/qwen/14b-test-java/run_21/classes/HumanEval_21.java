import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_21 {

    // Source Code
    public static List<Double> rescaleToUnit(List<Double> numbers) {
        double minNumber = Collections.min(numbers);
        double maxNumber = Collections.max(numbers);
        List<Double> rescaledNumbers = new ArrayList<>();
        for (double x : numbers) {
            rescaledNumbers.add((x - minNumber) / (maxNumber - minNumber));
        }
        return rescaledNumbers;
    }

    // Transformed Code
    public static List<Double> normalizeValues(List<Double> values) {
        double smallestValue = Collections.min(values);
        double largestValue = Collections.max(values);
        double rangeValue = largestValue - smallestValue;

        List<Double> normalizedList = new ArrayList<>();
        for (double value : values) {
            double normalizedValue = (value - smallestValue) / rangeValue;
            normalizedList.add(normalizedValue);
        }

        return normalizedList;
    }

    // Test Cases
    private static final Double[][] testCases = {
        {1.0, 2.0, 3.0, 4.0, 5.0},
        {10.0, 20.0, 30.0, 40.0, 50.0},
        {5.0, 5.0, 5.0, 5.0},
        {-1.0, -2.0, -3.0, -4.0, -5.0},
        {0.0, 100.0},
        {3.14, 2.71, 1.618, 0.577},
        {100.0, 200.0, 300.0, 400.0, 500.0},
        {1.0, 1.0, 2.0, 2.0, 3.0, 3.0},
        {-5.0, 0.0, 5.0},
        {1000.0}
    };

    @Test
    public void test_0() {
        assertEquals(rescaleToUnit(List.of(testCases[0])), normalizeValues(List.of(testCases[0])));
    }

    @Test
    public void test_1() {
        assertEquals(rescaleToUnit(List.of(testCases[1])), normalizeValues(List.of(testCases[1])));
    }

    @Test
    public void test_2() {
        assertEquals(rescaleToUnit(List.of(testCases[2])), normalizeValues(List.of(testCases[2])));
    }

    @Test
    public void test_3() {
        assertEquals(rescaleToUnit(List.of(testCases[3])), normalizeValues(List.of(testCases[3])));
    }

    @Test
    public void test_4() {
        assertEquals(rescaleToUnit(List.of(testCases[4])), normalizeValues(List.of(testCases[4])));
    }

    @Test
    public void test_5() {
        assertEquals(rescaleToUnit(List.of(testCases[5])), normalizeValues(List.of(testCases[5])));
    }

    @Test
    public void test_6() {
        assertEquals(rescaleToUnit(List.of(testCases[6])), normalizeValues(List.of(testCases[6])));
    }

    @Test
    public void test_7() {
        assertEquals(rescaleToUnit(List.of(testCases[7])), normalizeValues(List.of(testCases[7])));
    }

    @Test
    public void test_8() {
        assertEquals(rescaleToUnit(List.of(testCases[8])), normalizeValues(List.of(testCases[8])));
    }

    @Test
    public void test_9() {
        assertEquals(rescaleToUnit(List.of(testCases[9])), normalizeValues(List.of(testCases[9])));
    }
}