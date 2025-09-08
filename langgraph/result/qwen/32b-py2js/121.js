function solution(lst) {
    return lst.reduce((sum, x, idx) => {
        return (idx % 2 === 0 && x % 2 === 1) ? sum + x : sum;
    }, 0);
}