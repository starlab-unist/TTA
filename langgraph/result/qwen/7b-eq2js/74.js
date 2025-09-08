function compareStringLists(lst1, lst2) {
    const lengthA = lst1.reduce((acc, str) => acc + str.length, 0);
    
    let lengthB = 0;
    let index = 0;
    while (index < lst2.length) {
        lengthB += lst2[index].length;
        index++;
    }
    
    return lengthA <= lengthB ? lst1 : lst2;
}