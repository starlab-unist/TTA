function strangeSortList(arr) {
    const res = [];
    let switcher = true;
    while (arr.length > 0) {
        const value = switcher ? Math.min(...arr) : Math.max(...arr);
        res.push(value);
        arr.splice(arr.indexOf(value), 1);
        switcher = !switcher;
    }
    return res;
}