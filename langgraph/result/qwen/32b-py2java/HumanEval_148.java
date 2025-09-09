import java.util.Arrays;
import java.util.List;

public class HumanEval_148 {
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