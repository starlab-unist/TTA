// Source Code
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

// Transformed Code (Semantically Equivalent)
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

// Test Cases
describe('bf vs findPlanetsBetween equivalence tests', () => {
    const testCases = [
        ["Earth", "Mars"],
        ["Neptune", "Mercury"],
        ["Venus", "Jupiter"],
        ["Saturn", "Saturn"],
        ["Pluto", "Earth"],
        ["Mars", "Mars"],
        ["Mercury", "Neptune"],
        ["Uranus", "Venus"],
        ["Earth", "Earth"],
        ["Jupiter", "Saturn"]
    ];

    test.each(testCases)('Input: "%s" and "%s"', (planet1, planet2) => {
        expect(bf(planet1, planet2)).toEqual(findPlanetsBetween(planet1, planet2));
    });
});