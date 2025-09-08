function bf(planet1, planet2) {
    const planetNames = ["Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune"];
    if (!planetNames.includes(planet1) || !planetNames.includes(planet2) || planet1 === planet2) {
        return [];
    }
    const planet1Index = planetNames.indexOf(planet1);
    const planet2Index = planetNames.indexOf(planet2);
    if (planet1Index < planet2Index) {
        return planetNames.slice(planet1Index + 1, planet2Index);
    } else {
        return planetNames.slice(planet2Index + 1, planet1Index);
    }
}