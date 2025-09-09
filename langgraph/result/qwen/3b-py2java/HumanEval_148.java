public class HumanEval_148 {
    public static String[] bf(String planet1, String planet2) {
        String[] planetNames = {"Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune"};
        
        if (!Arrays.asList(planetNames).contains(planet1) || !Arrays.asList(planetNames).contains(planet2) || planet1.equals(planet2)) {
            return new String[0];
        }
        
        int planet1Index = Arrays.asList(planetNames).indexOf(planet1);
        int planet2Index = Arrays.asList(planetNames).indexOf(planet2);
        
        if (planet1Index < planet2Index) {
            return Arrays.copyOfRange(planetNames, planet1Index + 1, planet2Index);
        } else {
            return Arrays.copyOfRange(planetNames, planet2Index + 1, planet1Index);
        }
    }
}