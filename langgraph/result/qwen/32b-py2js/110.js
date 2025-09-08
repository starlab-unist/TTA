function exchange(lst1, lst2) {
    let odd = 0;
    let even = 0;
    for (let i of lst1) {
        if (i % 2 === 1) {
            odd += 1;
        }
    }
    for (let i of lst2) {
        if (i % 2 === 0) {
            even += 1;
        }
    }
    if (even >= odd) {
        return "YES";
    }
    return "NO";
}