function compareStringLists(listA, listB) {
    const lengthA = listA.reduce((acc, str) => acc + str.length, 0);
    
    let lengthB = 0;
    let index = 0;
    while (index < listB.length) {
        lengthB += listB[index].length;
        index++;
    }
    
    return lengthA <= lengthB ? listA : listB;
}

// method name: totalMatch -> compareStringLists
// parameter names: lst1 -> listA, lst2 -> listB