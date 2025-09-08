function findSharedElements(listA, listB) {
    const sharedItems = new Set();
    const iteratorA = listA.values();

    while (true) {
        const elementA = iteratorA.next().value;
        if (elementA === undefined) break;

        for (const elementB of listB) {
            if (elementA === elementB) {
                sharedItems.add(elementA);
            }
        }
    }

    return Array.from(sharedItems).sort();
}