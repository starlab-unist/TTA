function findSharedElements(listA, listB) {
    const sharedItems = new Set();
    const iteratorA = listA.values();
    
    while (true) {
        try {
            const elementA = iteratorA.next().value;
            for (const elementB of listB) {
                if (elementA === elementB) {
                    sharedItems.add(elementA);
                }
            }
        } catch (e) {
            if (e instanceof StopIteration) {
                break;
            }
        }
    }
    
    return Array.from(sharedItems).sort();
}