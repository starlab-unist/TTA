import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_148 {

    // Source Code
    static class SourceCode {
        public List<String> bf(String planet1, String planet2) {
            List<String> planetNames = Arrays.asList("Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune");
            if (!planetNames.contains(planet1) || !planetNames.contains(planet2) || planet1.equals(planet2)) {
                return Arrays.asList();
            }
            int planet1Index = planetNames.indexOf(planet1);
            int planet2Index = planetNames.indexOf(planet2);
            if (planet1Index < planet2Index) {
                return planetNames.subList(planet1Index + 1, planet2Index);
            } else {
                return planetNames.subList(planet2Index + 1, planet1Index);
            }
        }
    }

    // Transformed Code
    static class TransformedCode {
        public String[] findPlanetsBetween(String body1, String body2) {
            String[] solarSystem = {"Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune"};
            
            int index1 = Arrays.asList(solarSystem).indexOf(body1);
            int index2 = Arrays.asList(solarSystem).indexOf(body2);
            
            if (index1 == -1 || index2 == -1 || body1.equals(body2)) {
                return new String[0];
            }
            
            if (index1 < index2) {
                return Arrays.copyOfRange(solarSystem, index1 + 1, index2);
            } else {
                return Arrays.copyOfRange(solarSystem, index2 + 1, index1);
            }
        }
    }

    // Test Cases
    private static final String[][] testCases = {
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

    private static java.util.stream.Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).map(Arguments::of);
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void bf_vs_findPlanetsBetween(String planet1, String planet2) {
        assertEquals(
            SourceCode.bf(planet1, planet2),
            Arrays.asList(TransformedCode.findPlanetsBetween(planet1, planet2))
        );
    }
}