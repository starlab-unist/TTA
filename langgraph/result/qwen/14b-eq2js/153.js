function findPowerfulAddon(baseClass, addonList) {
    let powerfulAddon = addonList[0];
    let maxStrength = [...addonList[0]].filter(char => char === char.toUpperCase()).length - [...addonList[0]].filter(char => char === char.toLowerCase()).length;

    for (let addon of addonList) {
        let currentStrength = [...addon].filter(char => char === char.toUpperCase()).length - [...addon].filter(char => char === char.toLowerCase()).length;
        if (currentStrength > maxStrength) {
            powerfulAddon = addon;
            maxStrength = currentStrength;
        }
    }

    let result = `${baseClass}.${powerfulAddon}`;
    return result;
}