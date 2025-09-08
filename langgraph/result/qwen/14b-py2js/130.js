function tri(n) {
    if (n === 0) {
        return [1];
    }
    const myTri = [1, 3];
    for (let i = 2; i <= n; i++) {
        if (i % 2 === 0) {
            myTri.push(i / 2 + 1);
        } else {
            myTri.push(myTri[i - 1] + myTri[i - 2] + (i + 3) / 2);
        }
    }
    return myTri;
}