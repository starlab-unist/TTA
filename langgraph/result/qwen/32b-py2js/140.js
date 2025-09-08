function fixSpaces(text) {
    let newText = "";
    let i = 0;
    let start = 0, end = 0;
    while (i < text.length) {
        if (text[i] === " ") {
            end += 1;
        } else {
            if (end - start > 2) {
                newText += "-" + text[i];
            } else if (end - start > 0) {
                newText += "_".repeat(end - start) + text[i];
            } else {
                newText += text[i];
            }
            start = i + 1;
            end = i + 1;
        }
        i += 1;
    }
    if (end - start > 2) {
        newText += "-";
    } else if (end - start > 0) {
        newText += "_";
    }
    return newText;
}