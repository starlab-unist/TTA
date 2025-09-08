function findPowerfulAddon(baseClass, addonList) {
    let powerfulAddon = addonList[0];
    let maxStrength = Array.from(addonList[0]).reduce((acc, char) => acc + (char === char.toUpperCase() ? 1 : -1), 0);

    for (let addon of addonList) {
        let currentStrength = Array.from(addon).reduce((acc, char) => acc + (char === char.toUpperCase() ? 1 : -1), 0);
        if (currentStrength > maxStrength) {
            powerfulAddon = addon;
            maxStrength = currentStrength;
        }
    }

    let result = `${baseClass}.${powerfulAddon}`;
    return result;
}