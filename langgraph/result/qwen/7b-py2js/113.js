function oddCount(lst) {
    let res = [];
    for (let arr of lst) {
        let n = arr.filter(d => parseInt(d) % 2 === 1).length;
        res.push(`the number of odd elements ${n}n the str${n}ng ${n} of the ${n}nput.`);
    }
    return res;
}