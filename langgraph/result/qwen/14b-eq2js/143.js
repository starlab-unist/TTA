function filterUniqueLengthWords(phrase) {
    let result = [];
    let terms = phrase.split(' ');

    for (let i = 0; i < terms.length; i++) {
        let term = terms[i];
        let flag = false;

        if (term.length === 1) {
            flag = true;
        }

        let divisor = 2;
        while (divisor < term.length) {
            if (term.length % divisor === 0) {
                flag = true;
                break;
            }
            divisor++;
        }

        if (!flag || term.length === 2) {
            result.push(term);
        }
    }

    return result.join(' ');
}