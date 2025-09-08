function fixSpaces(text) {
    let newText = "";
    let i = 0;
    let start = 0, end = 0;
    while (i < text.length) {
        if (text[i] === " ") {
            end++;
        } else {
            if (end - start > 2) {
                newText += "-" + text[i];
            } else if (end - start > 0) {
                newText += "_".repeat(end - start) + text[i];
            } else {
                newText += text[i];
            }
            start = end = i + 1;
        }
        i++;
    }
    if (end - start > 2) {
        newText += "-";
    } else if (end - start > 0) {
        newText += "_".repeat(end - start);
    }
    return newText;
}