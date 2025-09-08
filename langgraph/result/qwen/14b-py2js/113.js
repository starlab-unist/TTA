function oddCount(lst) {
    const res = [];
    for (const arr of lst) {
        const n = arr.filter(d => parseInt(d) % 2 === 1).length;
        res.push(`the number of odd elements ${n}n the str${n}ng ${n} of the ${n}nput.`);
    }
    return res;
}