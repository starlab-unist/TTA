function doubleTheDifference(lst) {
    return lst.reduce((sum, i) => {
        if (i > 0 && i % 2 !== 0 && !i.toString().includes('.')) {
            return sum + i ** 2;
        }
        return sum;
    }, 0);
}