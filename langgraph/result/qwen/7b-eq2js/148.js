function findPlanetsBetween(planet1, planet2) {
    const planetNames = ["Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune"];
    if (!planetNames.includes(planet1) || !planetNames.includes(planet2) || planet1 === planet2) {
        return [];
    }
    
    const index1 = planetNames.indexOf(planet1);
    const index2 = planetNames.indexOf(planet2);
    
    if (index1 < index2) {
        return planetNames.slice(index1 + 1, index2);
    } else {
        return planetNames.slice(index2 + 1, index1);
    }
}