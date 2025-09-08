function closestInteger(value) {
    const floor = Math.floor;
    const ceil = Math.ceil;

    if (value.includes('.')) {
        // remove trailing zeros
        while (value.endsWith('0')) {
            value = value.slice(0, -1);
        }
    }

    let num = parseFloat(value);
    if (value.endsWith('.5')) {
        if (num > 0) {
            res = ceil(num);
        } else {
            res = floor(num);
        }
    } else if (value.length > 0) {
        res = parseInt(Math.round(num));
    } else {
        res = 0;
    }

    return res;
}