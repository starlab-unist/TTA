function countSevensInSpecialNumbers(limit) {
    let specialNumbers = [];
    let index = 0;
    while (index < limit) {
        if (index % 11 === 0 || index % 13 === 0) {
            specialNumbers.push(index);
        }
        index++;
    }

    let concatenatedString = specialNumbers.join('');
    let sevenCount = 0;
    let position = 0;
    while (position < concatenatedString.length) {
        if (concatenatedString[position] === '7') {
            sevenCount++;
        }
        position++;
    }

    return sevenCount;
}