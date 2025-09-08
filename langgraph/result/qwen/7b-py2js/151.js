function doubleTheDifference(lst) {
    return lst.filter(i => i > 0 && i % 2 !== 0 && !str(i).includes('.')).reduce((acc, i) => acc + i * i, 0);
}