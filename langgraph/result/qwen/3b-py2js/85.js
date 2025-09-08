function add(lst) {
    return lst.filter((_, i) => i % 2 !== 0 && lst[i] % 2 === 0).reduce((acc, val) => acc + val, 0);
}