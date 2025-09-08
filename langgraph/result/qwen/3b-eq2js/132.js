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
        index++;
    }

    endBracketsPositions.reverse();
    let matchCount = 0;
    let j = 0;
    const totalEndBrackets = endBracketsPositions.length;

    for (const openPos of startBracketsPositions) {
        if (j < totalEndBrackets && openPos < endBracketsPositions[j]) {
            matchCount++;
            j++;
        }
    }

    return matchCount >= 2;
}