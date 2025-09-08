function closestInteger(value) {
    const { floor, ceil } = Math;

    if (value.includes('.')) {
        // remove trailing zeros
        while (value.endsWith('0')) {
            value = value.slice(0, -1);
        }
    }

    const num = parseFloat(value);
    if (value.endsWith('.5')) {
        if (num > 0) {
            res = ceil(num);
        } else {
            res = floor(num);
        }
    } else if (value.length > 0) {
        res = Math.round(num);
    } else {
        res = 0;
    }

    return res;
}