function evaluateDictionaryKeysCasing(inputDict) {
    if (!inputDict) {
        return false;
    }

    let casingState = null;
    for (let key of Object.keys(inputDict)) {
        if (typeof key !== 'string') {
            return false;
        }

        if (casingState === null) {
            if (key.toUpperCase() === key) {
                casingState = 'UPPER';
            } else if (key.toLowerCase() === key) {
                casingState = 'LOWER';
            } else {
                return false;
            }
        } else {
            if ((casingState === 'UPPER' && key.toUpperCase() !== key) || (casingState === 'LOWER' && key.toLowerCase() !== key)) {
                return false;
            }
        }
    }

    return ['UPPER', 'LOWER'].includes(casingState);
}