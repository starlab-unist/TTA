function mergeStrings(stringList) {
    let result = "";
    let index = 0;
    while (index < stringList.length) {
        result += stringList[index];
        index += 1;
    }
    return result;
}