function evaluateDictionaryKeysCasing(inputDict) {
    if (!inputDict || Object.keys(inputDict).length === 0) {
        return false;
    }

    let casingState = null;
    for (let key in inputDict) {
        if (typeof key !== 'string') {
            return false;
        }

        if (casingState === null) {
            if (key === key.toUpperCase()) {
                casingState = 'UPPER';
            } else if (key === key.toLowerCase()) {
                casingState = 'LOWER';
            } else {
                return false;
            }
        } else {
            if ((casingState === 'UPPER' && key !== key.toUpperCase()) || (casingState === 'LOWER' && key !== key.toLowerCase())) {
                return false;
            }
        }
    }

    return casingState === 'UPPER' || casingState === 'LOWER';
}