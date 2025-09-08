function strangeSortList(lst) {
    const res = [];
    let switchFlag = true;
    while (lst.length > 0) {
        res.push(switchFlag ? Math.min(...lst) : Math.max(...lst));
        lst.splice(lst.indexOf(res[res.length - 1]), 1);
        switchFlag = !switchFlag;
    }
    return res;
}