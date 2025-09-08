function oddCount(lst) {
    const res = [];
    lst.forEach(arr => {
        const n = arr.reduce((count, d) => count + (parseInt(d) % 2 === 1 ? 1 : 0), 0);
        res.push(`the number of odd elements ${n}n the str${n}ng ${n} of the ${n}nput.`);
    });
    return res;
}