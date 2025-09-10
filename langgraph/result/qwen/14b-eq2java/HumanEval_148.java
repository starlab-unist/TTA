import java.util.Arrays;
import java.util.List;

public class HumanEval_148 {
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
}