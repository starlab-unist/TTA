function findSharedElements(listA, listB) {
    const sharedItems = new Set();
    const iteratorA = listA[Symbol.iterator]();
    
    while (true) {
        const result = iteratorA.next();
        if (result.done) break;
        const elementA = result.value;
        
        for (const elementB of listB) {
            if (elementA === elementB) {
                sharedItems.add(elementA);
            }
        }
    }
    
    return Array.from(sharedItems).sort();
}