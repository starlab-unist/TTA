function fixSpaces(text) {
    let new_text = "";
    let i = 0;
    let start = 0;
    let end = 0;

    while (i < text.length) {
        if (text[i] === " ") {
            end++;
        } else {
            if (end - start > 2) {
                new_text += "-" + text[i];
            } else if (end - start > 0) {
                new_text += "_" + Array(end - start).fill("_").join("") + text[i];
            } else {
                new_text += text[i];
            }
            start = end;
            end = i + 1;
        }
        i++;
    }

    if (end - start > 2) {
        new_text += "-";
    } else if (end - start > 0) {
        new_text += "_";
    }

    return new_text;
}