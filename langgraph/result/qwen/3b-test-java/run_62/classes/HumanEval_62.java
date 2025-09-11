import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_62 {

    // Source Code
    public static List<Double> derivative(List<Double> xs) {
        return IntStream.range(1, xs.size())
                .mapToObj(i -> i * xs.get(i))
                .collect(Collectors.toList());
    }

    // Transformed Code
    public static List<Integer> computeDerivative(List<Integer> coefficients) {
        List<Integer> result = new ArrayList<>();
        int index = 1;
        while (index < coefficients.size()) {
            result.add(index * coefficients.get(index));
            index++;
        }
        return result;
    }

    // Test Cases
    private static final Object[][] testCases = {
        {Arrays.asList(3.0, 1.0, 2.0, 4.0), Arrays.asList(1, 4, 12)},
        {Arrays.asList(0.0, 5.0, 0.0, 7.0), Arrays.asList(5, 0, 21)},
        {Arrays.asList(1.0, 3.0, 5.0, 7.0, 9.0), Arrays.asList(3, 10, 21, 36)},
        {Arrays.asList(2.0, 0.0, 0.0, 0.0), Arrays.asList(0, 0, 0)},
        {Arrays.asList(10.0, 20.0, 30.0), Arrays.asList(20, 60)},
        {Arrays.asList(5.0), Arrays.asList()},
        {Arrays.asList(), Arrays.asList()},
        {Arrays.asList(1.0, -1.0, 1.0, -1.0), Arrays.asList(-1, 2, -3)},
        {Arrays.asList(0.0, 0.0, 0.0, 0.0, 0.0), Arrays.asList(0, 0, 0, 0)},
        {Arrays.asList(7.0, 6.0, 5.0, 4.0, 3.0, 2.0), Arrays.asList(6, 10, 12, 12, 10)}
    };

    @Test
    public void test_0() {
        assertEquals(transformDoubleListToIntegerList(derivative((List<Double>) testCases[0][0])), 
                     computeDerivative((List<Integer>) transformObjectListToIntegerList(testCases[0][0])));
    }

    @Test
    public void test_1() {
        assertEquals(transformDoubleListToIntegerList(derivative((List<Double>) testCases[1][0])), 
                     computeDerivative((List<Integer>) transformObjectListToIntegerList(testCases[1][0])));
    }

    @Test
    public void test_2() {
        assertEquals(transformDoubleListToIntegerList(derivative((List<Double>) testCases[2][0])), 
                     computeDerivative((List<Integer>) transformObjectListToIntegerList(testCases[2][0])));
    }

    @Test
    public void test_3() {
        assertEquals(transformDoubleListToIntegerList(derivative((List<Double>) testCases[3][0])), 
                     computeDerivative((List<Integer>) transformObjectListToIntegerList(testCases[3][0])));
    }

    @Test
    public void test_4() {
        assertEquals(transformDoubleListToIntegerList(derivative((List<Double>) testCases[4][0])), 
                     computeDerivative((List<Integer>) transformObjectListToIntegerList(testCases[4][0])));
    }

    @Test
    public void test_5() {
        assertEquals(transformDoubleListToIntegerList(derivative((List<Double>) testCases[5][0])), 
                     computeDerivative((List<Integer>) transformObjectListToIntegerList(testCases[5][0])));
    }

    @Test
    public void test_6() {
        assertEquals(transformDoubleListToIntegerList(derivative((List<Double>) testCases[6][0])), 
                     computeDerivative((List<Integer>) transformObjectListToIntegerList(testCases[6][0])));
    }

    @Test
    public void test_7() {
        assertEquals(transformDoubleListToIntegerList(derivative((List<Double>) testCases[7][0])), 
                     computeDerivative((List<Integer>) transformObjectListToIntegerList(testCases[7][0])));
    }

    @Test
    public void test_8() {
        assertEquals(transformDoubleListToIntegerList(derivative((List<Double>) testCases[8][0])), 
                     computeDerivative((List<Integer>) transformObjectListToIntegerList(testCases[8][0])));
    }

    @Test
    public void test_9() {
        assertEquals(transformDoubleListToIntegerList(derivative((List<Double>) testCases[9][0])), 
                     computeDerivative((List<Integer>) transformObjectListToIntegerList(testCases[9][0])));
    }

    private List<Integer> transformObjectListToIntegerList(Object list) {
        return ((List<?>) list).stream()
                .map(o -> (Integer) ((Double) o).intValue())
                .collect(Collectors.toList());
    }

    private List<Integer> transformDoubleListToIntegerList(List<Double> doubleList) {
        return doubleList.stream()
                .map(Double::intValue)
                .collect(Collectors.toList());
    }
}