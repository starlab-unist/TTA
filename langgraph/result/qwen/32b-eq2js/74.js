function compareStringLists(listA, listB) {
    const lengthA = listA.reduce((sum, string) => sum + string.length, 0);
    
    let lengthB = 0;
    let index = 0;
    while (index < listB.length) {
        lengthB += listB[index].length;
        index += 1;
    }
    
    return lengthA <= lengthB ? listA : listB;
}