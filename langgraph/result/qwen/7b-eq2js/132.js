function isNested(expression) {
    let startBracketPositions = [];
    let endBracketPositions = [];
    let index = 0;
    while (index < expression.length) {
        if (expression[index] === '[') {
            startBracketPositions.push(index);
        } else {
            endBracketPositions.push(index);
        }
        index++;
    }
    endBracketPositions.reverse();
    let matchCount = 0;
    let j = 0;
    let totalEndBrackets = endBracketPositions.length;
    for (let openPos of startBracketPositions) {
        if (j < totalEndBrackets && openPos < endBracketPositions[j]) {
            matchCount++;
            j++;
        }
    }
    return matchCount >= 2;
}