function compareCharacterSets(stringOne, stringTwo) {
    const setOfCharsOne = new Set(stringOne);
    const setOfCharsTwo = new Set(stringTwo);
    
    return setOfCharsOne.size === setOfCharsTwo.size && [...setOfCharsOne].every(char => setOfCharsTwo.has(char));
}