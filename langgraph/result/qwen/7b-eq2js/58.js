function findSharedElements(l1, l2) {
    let sharedItems = new Set();
    let iteratorA = l1[Symbol.iterator]();

    while (true) {
        try {
            let elementA = iteratorA.next().value;
            for (let elementB of l2) {
                if (elementA === elementB) {
                    sharedItems.add(elementA);
                }
            }
        } catch (e) {
            break;
        }
    }

    return Array.from(sharedItems).sort();
}