function findPlanetsBetween(body1, body2) {
    const solarSystem = ["Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune"];
    if (!solarSystem.includes(body1) || !solarSystem.includes(body2) || body1 === body2) {
        return [];
    }
    
    const index1 = solarSystem.indexOf(body1);
    const index2 = solarSystem.indexOf(body2);
    
    if (index1 < index2) {
        return solarSystem.slice(index1 + 1, index2);
    } else {
        return solarSystem.slice(index2 + 1, index1);
    }
}