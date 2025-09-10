import java.util.Arrays;
import java.util.List;

public class HumanEval_148 {
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
}