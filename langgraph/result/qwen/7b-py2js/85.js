function add(lst) {
    return lst.filter((_, index) => index % 2 === 1 && lst[index] % 2 === 0).reduce((acc, val) => acc + val, 0);
}