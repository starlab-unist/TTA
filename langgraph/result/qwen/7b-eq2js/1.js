function extractBalancedParentheses(parenString) {
    let outputGroups = [];
    let tempGroup = [];
    let nestingLevel = 0;
    let index = 0;

    while (index < parenString.length) {
        let character = parenString[index];
        if (character === '(') {
            nestingLevel++;
            tempGroup.push(character);
        } else if (character === ')') {
            nestingLevel--;
            tempGroup.push(character);

            if (nestingLevel === 0) {
                outputGroups.push(tempGroup.join(''));
                tempGroup = [];
            }
        }

        index++;
    }

    return outputGroups;
}