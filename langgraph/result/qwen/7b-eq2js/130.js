function generateCustomSequence(n) {
    if (n === 0) {
        return [1];
    }
    
    let myTri = [1, 3];
    let i = 2;
    
    while (i <= n) {
        if (i % 2 === 0) {
            myTri.push(i / 2 + 1);
        } else {
            myTri.push(myTri[i - 1] + myTri[i - 2] + (i + 3) / 2);
        }
        i += 1;
    }
    
    return myTri;
}