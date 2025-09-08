function solution(lst) {
    return lst.reduce((sum, x, idx) => {
        if (idx % 2 === 0 && x % 2 === 1) {
            return sum + x;
        }
        return sum;
    }, 0);
}