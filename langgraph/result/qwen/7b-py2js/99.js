function closestInteger(value) {
    const { floor, ceil } = Math;

    if (value.includes('.')) {
        // remove trailing zeros
        while (value.endsWith('0')) {
            value = value.slice(0, -1);
        }
    }

    let num = parseFloat(value);
    if (value.endsWith('.5')) {
        if (num > 0) {
            return ceil(num);
        } else {
            return floor(num);
        }
    } else if (value.length > 0) {
        return Math.round(num);
    } else {
        return 0;
    }
}