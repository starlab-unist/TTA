import java.util.Arrays;

class HumanEval_148 {
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