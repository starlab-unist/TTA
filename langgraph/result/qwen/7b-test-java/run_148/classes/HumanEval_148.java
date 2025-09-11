import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import java.util.Arrays;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_148 {

    // Source Code
    public static String[] bf(String planet1, String planet2) {
        String[] planetNames = {"Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune"};
        int planet1Index = -1;
        int planet2Index = -1;

        for (int i = 0; i < planetNames.length; i++) {
            if (planetNames[i].equals(planet1)) {
                planet1Index = i;
            }
            if (planetNames[i].equals(planet2)) {
                planet2Index = i;
            }
        }

        if (planet1Index == -1 || planet2Index == -1 || planet1.equals(planet2)) {
            return new String[0];
        }

        if (planet1Index < planet2Index) {
            return Arrays.copyOfRange(planetNames, planet1Index + 1, planet2Index);
        } else {
            return Arrays.copyOfRange(planetNames, planet2Index + 1, planet1Index);
        }
    }

    // Transformed Code
    public static String[] findPlanetsBetween(String body1, String body2) {
        String[] solarSystem = {"Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune"};
        if (!ArrayUtils.contains(solarSystem, body1) || !ArrayUtils.contains(solarSystem, body2) || body1.equals(body2)) {
            return new String[0];
        }
        
        int index1 = ArrayUtils.indexOf(solarSystem, body1);
        int index2 = ArrayUtils.indexOf(solarSystem, body2);
        
        if (index1 < index2) {
            return Arrays.copyOfRange(solarSystem, index1 + 1, index2);
        } else {
            return Arrays.copyOfRange(solarSystem, index2 + 1, index1);
        }
    }

    // Test Cases
    private static final Object[][] testCases = {
        {"Earth", "Mars"},
        {"Neptune", "Mercury"},
        {"Venus", "Jupiter"},
        {"Saturn", "Saturn"},
        {"Pluto", "Earth"},
        {"Mars", "Mars"},
        {"Mercury", "Neptune"},
        {"Uranus", "Venus"},
        {"Earth", "Earth"},
        {"Jupiter", "Saturn"}
    };

    @Test
    public void test_0() {
        assertEquals(Arrays.toString(bf((String) testCases[0][0], (String) testCases[0][1])), 
                     Arrays.toString(findPlanetsBetween((String) testCases[0][0], (String) testCases[0][1])));
    }

    @Test
    public void test_1() {
        assertEquals(Arrays.toString(bf((String) testCases[1][0], (String) testCases[1][1])), 
                     Arrays.toString(findPlanetsBetween((String) testCases[1][0], (String) testCases[1][1])));
    }

    @Test
    public void test_2() {
        assertEquals(Arrays.toString(bf((String) testCases[2][0], (String) testCases[2][1])), 
                     Arrays.toString(findPlanetsBetween((String) testCases[2][0], (String) testCases[2][1])));
    }

    @Test
    public void test_3() {
        assertEquals(Arrays.toString(bf((String) testCases[3][0], (String) testCases[3][1])), 
                     Arrays.toString(findPlanetsBetween((String) testCases[3][0], (String) testCases[3][1])));
    }

    @Test
    public void test_4() {
        assertEquals(Arrays.toString(bf((String) testCases[4][0], (String) testCases[4][1])), 
                     Arrays.toString(findPlanetsBetween((String) testCases[4][0], (String) testCases[4][1])));
    }

    @Test
    public void test_5() {
        assertEquals(Arrays.toString(bf((String) testCases[5][0], (String) testCases[5][1])), 
                     Arrays.toString(findPlanetsBetween((String) testCases[5][0], (String) testCases[5][1])));
    }

    @Test
    public void test_6() {
        assertEquals(Arrays.toString(bf((String) testCases[6][0], (String) testCases[6][1])), 
                     Arrays.toString(findPlanetsBetween((String) testCases[6][0], (String) testCases[6][1])));
    }

    @Test
    public void test_7() {
        assertEquals(Arrays.toString(bf((String) testCases[7][0], (String) testCases[7][1])), 
                     Arrays.toString(findPlanetsBetween((String) testCases[7][0], (String) testCases[7][1])));
    }

    @Test
    public void test_8() {
        assertEquals(Arrays.toString(bf((String) testCases[8][0], (String) testCases[8][1])), 
                     Arrays.toString(findPlanetsBetween((String) testCases[8][0], (String) testCases[8][1])));
    }

    @Test
    public void test_9() {
        assertEquals(Arrays.toString(bf((String) testCases[9][0], (String) testCases[9][1])), 
                     Arrays.toString(findPlanetsBetween((String) testCases[9][0], (String) testCases[9][1])));
    }
}