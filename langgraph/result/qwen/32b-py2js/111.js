function histogram(test) {
    const dict1 = {};
    const list1 = test.split(" ");
    let t = 0;

    for (const i of list1) {
        if (list1.filter(x => x === i).length > t && i !== '') {
            t = list1.filter(x => x === i).length;
        }
    }
    if (t > 0) {
        for (const i of list1) {
            if (list1.filter(x => x === i).length === t) {
                dict1[i] = t;
            }
        }
    }
    return dict1;
}