function oddCount(lst) {
    const result = [];
    for (const arr of lst) {
        const n = Array.from(arr).reduce((count, d) => count + (parseInt(d) % 2 === 1), 0);
        result.push(`the number of odd elements ${n}n the str${n}ng ${n} of the ${n}nput.`);
    }
    return result;
}