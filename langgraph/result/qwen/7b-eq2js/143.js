function filterUniqueLengthWords(sentence) {
    const result = [];
    const terms = sentence.split();
    for (let i = 0; i < terms.length; i++) {
        let flag = false;
        if (terms[i].length === 1) {
            flag = true;
        }
        let divisor = 2;
        while (divisor < terms[i].length) {
            if (terms[i].length % divisor === 0) {
                flag = true;
                break;
            }
            divisor++;
        }
        if (!flag || terms[i].length === 2) {
            result.push(terms[i]);
        }
    }
    return result.join(" ");
}