function compareStringLists(listA, listB) {
    const lengthA = listA.reduce((acc, string) => acc + string.length, 0);

    let lengthB = 0;
    let index = 0;
    while (index < listB.length) {
        lengthB += listB[index].length;
        index += 1;
    }

    if (lengthA <= lengthB) {
        return listA;
    }
    return listB;
}