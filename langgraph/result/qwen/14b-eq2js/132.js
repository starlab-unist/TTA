function checkForNesting(expression) {
    const startBracketsPositions = [];
    const endBracketsPositions = [];
    let index = 0;
    while (index < expression.length) {
        if (expression[index] === '[') {
            startBracketsPositions.push(index);
        } else {
            endBracketsPositions.push(index);
        }
        index += 1;
    }
    endBracketsPositions.reverse();
    let matchCount = 0;
    let j = 0;
    const totalEndBrackets = endBracketsPositions.length;
    for (const openPos of startBracketsPositions) {
        if (j < totalEndBrackets && openPos < endBracketsPositions[j]) {
            matchCount += 1;
            j += 1;
        }
    }
    return matchCount >= 2;
}