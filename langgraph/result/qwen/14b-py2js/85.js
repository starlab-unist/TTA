function add(lst) {
    return lst.filter((value, index) => index % 2 !== 0 && value % 2 === 0).reduce((acc, curr) => acc + curr, 0);
}