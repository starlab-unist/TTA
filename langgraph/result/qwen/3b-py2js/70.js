function strangeSortList(lst) {
    let res = [];
    let switchFlag = true;
    while (lst.length > 0) {
        const element = switchFlag ? Math.min(...lst) : Math.max(...lst);
        res.push(element);
        lst.splice(lst.indexOf(element), 1);
        switchFlag = !switchFlag;
    }
    return res;
}