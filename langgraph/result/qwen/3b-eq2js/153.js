function findPowerfulAddon(baseClass, addonList) {
    let powerfulAddon = addonList[0];
    let maxStrength = 0;

    for (let addon of addonList) {
        let currentStrength = 0;
        for (let char of addon) {
            if (char === char.toUpperCase()) {
                currentStrength++;
            } else if (char === char.toLowerCase()) {
                currentStrength--;
            }
        }
        if (currentStrength > maxStrength) {
            powerfulAddon = addon;
            maxStrength = currentStrength;
        }
    }

    let result = `${baseClass}.${powerfulAddon}`;
    return result;
}