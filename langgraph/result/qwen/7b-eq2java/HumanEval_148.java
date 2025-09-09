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