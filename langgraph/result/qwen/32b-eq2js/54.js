function compareCharacterSets(stringOne, stringTwo) {
    const setOfCharsOne = new Set(stringOne);
    const setOfCharsTwo = new Set(stringTwo);
    
    if (setOfCharsOne.size !== setOfCharsTwo.size) {
        return false;
    }
    
    for (let char of setOfCharsOne) {
        if (!setOfCharsTwo.has(char)) {
            return false;
        }
    }
    
    return true;
}