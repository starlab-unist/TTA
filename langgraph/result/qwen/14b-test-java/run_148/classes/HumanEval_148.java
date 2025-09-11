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

public class HumanEval_148 {

    // Source Code
    public static List<String> bf(String planet1, String planet2) {
        String[] planetNames = {"Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune"};
        List<String> planets = Arrays.asList(planetNames);
        
        if (!planets.contains(planet1) || !planets.contains(planet2) || planet1.equals(planet2)) {
            return Arrays.asList();
        }
        
        int planet1Index = planets.indexOf(planet1);
        int planet2Index = planets.indexOf(planet2);
        
        if (planet1Index < planet2Index) {
            return planets.subList(planet1Index + 1, planet2Index);
        } else {
            return planets.subList(planet2Index + 1, planet1Index);
        }
    }

    // Transformed Code
    public static List<String> findPlanetsBetween(String body1, String body2) {
        List<String> solarSystem = Arrays.asList("Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune");
        
        if (!solarSystem.contains(body1) || !solarSystem.contains(body2) || body1.equals(body2)) {
            return Arrays.asList();
        }
        
        int index1 = solarSystem.indexOf(body1);
        int index2 = solarSystem.indexOf(body2);
        
        if (index1 < index2) {
            return solarSystem.subList(index1 + 1, index2);
        } else {
            return solarSystem.subList(index2 + 1, index1);
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
        assertEquals(bf((String) testCases[0][0], (String) testCases[0][1]), 
                     findPlanetsBetween((String) testCases[0][0], (String) testCases[0][1]));
    }

    @Test
    public void test_1() {
        assertEquals(bf((String) testCases[1][0], (String) testCases[1][1]), 
                     findPlanetsBetween((String) testCases[1][0], (String) testCases[1][1]));
    }

    @Test
    public void test_2() {
        assertEquals(bf((String) testCases[2][0], (String) testCases[2][1]), 
                     findPlanetsBetween((String) testCases[2][0], (String) testCases[2][1]));
    }

    @Test
    public void test_3() {
        assertEquals(bf((String) testCases[3][0], (String) testCases[3][1]), 
                     findPlanetsBetween((String) testCases[3][0], (String) testCases[3][1]));
    }

    @Test
    public void test_4() {
        assertEquals(bf((String) testCases[4][0], (String) testCases[4][1]), 
                     findPlanetsBetween((String) testCases[4][0], (String) testCases[4][1]));
    }

    @Test
    public void test_5() {
        assertEquals(bf((String) testCases[5][0], (String) testCases[5][1]), 
                     findPlanetsBetween((String) testCases[5][0], (String) testCases[5][1]));
    }

    @Test
    public void test_6() {
        assertEquals(bf((String) testCases[6][0], (String) testCases[6][1]), 
                     findPlanetsBetween((String) testCases[6][0], (String) testCases[6][1]));
    }

    @Test
    public void test_7() {
        assertEquals(bf((String) testCases[7][0], (String) testCases[7][1]), 
                     findPlanetsBetween((String) testCases[7][0], (String) testCases[7][1]));
    }

    @Test
    public void test_8() {
        assertEquals(bf((String) testCases[8][0], (String) testCases[8][1]), 
                     findPlanetsBetween((String) testCases[8][0], (String) testCases[8][1]));
    }

    @Test
    public void test_9() {
        assertEquals(bf((String) testCases[9][0], (String) testCases[9][1]), 
                     findPlanetsBetween((String) testCases[9][0], (String) testCases[9][1]));
    }
}