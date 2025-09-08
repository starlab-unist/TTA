function adjustWhitespace(inputString) {
    let result = "";
    let index = 0;
    let begin = 0;
    let finish = 0;
    while (index < inputString.length) {
        if (inputString[index] === " ") {
            finish++;
        } else {
            const spaceCount = finish - begin;
            if (spaceCount > 2) {
                result += "-" + inputString[index];
            } else if (spaceCount > 0) {
                result += "_".repeat(spaceCount) + inputString[index];
            } else {
                result += inputString[index];
            }
            begin = index + 1;
            finish = index + 1;
        }
        index++;
    }
    const finalSpaceCount = finish - begin;
    if (finalSpaceCount > 2) {
        result += "-";
    } else if (finalSpaceCount > 0) {
        result += "_";
    }
    return result;
}