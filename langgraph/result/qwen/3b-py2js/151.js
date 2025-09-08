function doubleTheDifference(lst) {
    return lst.filter(i => i > 0 && i % 2 !== 0 && !i.toString().includes('.')).reduce((acc, i) => acc + Math.pow(i, 2), 0);
}