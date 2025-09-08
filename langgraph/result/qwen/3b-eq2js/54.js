function compareCharacterSets(s0, s1) {
    const setOfCharsOne = new Set(s0);
    const setOfCharsTwo = new Set(s1);

    return setOfCharsOne.size === setOfCharsTwo.size && [...setOfCharsOne].every(char => setOfCharsTwo.has(char));
}