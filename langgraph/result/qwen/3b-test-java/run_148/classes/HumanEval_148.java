public class HumanEval_148 {

    public static String[] findPlanetsBetween(String planet1, String planet2) {
        String[] solarSystem = {"Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune"};
        
        if (!isPlanetInSolarSystem(planet1, solarSystem) || !isPlanetInSolarSystem(planet2, solarSystem) || planet1.equals(planet2)) {
            return new String[0];
        }
        
        int index1 = getIndex(planet1, solarSystem);
        int index2 = getIndex(planet2, solarSystem);
        
        if (index1 < index2) {
            return Arrays.copyOfRange(solarSystem, index1 + 1, index2);
        } else {
            return Arrays.copyOfRange(solarSystem, index2 + 1, index1);
        }
    }

    private static boolean isPlanetInSolarSystem(String planet, String[] solarSystem) {
        for (String planetName : solarSystem) {
            if (planetName.equals(planet)) {
                return true;
            }
        }
        return false;
    }

    private static int getIndex(String planet, String[] solarSystem) {
        for (int i = 0; i < solarSystem.length; i++) {
            if (solarSystem[i].equals(planet)) {
                return i;
            }
        }
        throw new IllegalArgumentException("Planet not found in solar system");
    }
}