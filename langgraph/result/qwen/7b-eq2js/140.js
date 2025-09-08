function adjustWhitespace(text) {
    let result = "";
    let index = 0;
    let start = 0, end = 0;
    while (index < text.length) {
        if (text[index] === " ") {
            end += 1;
        } else {
            const spaceCount = end - start;
            if (spaceCount > 2) {
                result += "-" + text[index];
            } else if (spaceCount > 0) {
                result += "_".repeat(spaceCount) + text[index];
            } else {
                result += text[index];
            }
            start = index + 1;
            end = index + 1;
        }
        index += 1;
    }
    const finalSpaceCount = end - start;
    if (finalSpaceCount > 2) {
        result += "-";
    } else if (finalSpaceCount > 0) {
        result += "_".repeat(finalSpaceCount);
    }
    return result;
}