public class HumanEval_148 {
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
            return java.util.Arrays.copyOfRange(planetNames, planet1Index + 1, planet2Index);
        } else {
            return java.util.Arrays.copyOfRange(planetNames, planet2Index + 1, planet1Index);
        }
    }
}