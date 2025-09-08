function findPowerfulAddon(baseClass, addonList) {
    let powerfulAddon = addonList[0];
    let maxStrength = addonList[0].split('').reduce((sum, char) => sum + (char === char.toUpperCase() ? 1 : -1), 0);

    for (let addon of addonList) {
        let currentStrength = addon.split('').reduce((sum, char) => sum + (char === char.toUpperCase() ? 1 : -1), 0);
        if (currentStrength > maxStrength) {
            powerfulAddon = addon;
            maxStrength = currentStrength;
        }
    }

    let result = `${baseClass}.${powerfulAddon}`;
    return result;
}