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

// method name: separate_paren_groups -> extractBalancedParentheses
// parameter name: paren_string -> inputSequence
// variable name: result -> outputGroups, current_string -> tempGroup, current_depth -> nestingLevel
// replaced for loop with while loop and index increment
// used tempGroup.join('') directly in push statement