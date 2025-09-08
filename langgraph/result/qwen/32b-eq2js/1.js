function extractBalancedParentheses(inputSequence) {
    const outputGroups = [];
    let tempGroup = [];
    let nestingLevel = 0;

    let index = 0;
    while (index < inputSequence.length) {
        const character = inputSequence[index];
        if (character === '(') {
            nestingLevel += 1;
            tempGroup.push(character);
        } else if (character === ')') {
            nestingLevel -= 1;
            tempGroup.push(character);

            if (nestingLevel === 0) {
                outputGroups.push(tempGroup.join(''));
                tempGroup = [];
            }
        }

        index += 1;
    }

    return outputGroups;
}