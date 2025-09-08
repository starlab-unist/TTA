function filterUniqueLengthWords(phrase) {
    const result = [];
    const terms = phrase.split(' ');

    for (let i = 0; i < terms.length; i++) {
        let flag = false;
        const term = terms[i];

        if (term.length === 1) {
            flag = true;
        }

        let divisor = 2;
        while (divisor < term.length) {
            if (term.length % divisor === 0) {
                flag = true;
                break;
            }
            divisor += 1;
        }

        if (!flag || term.length === 2) {
            result.push(term);
        }
    }

    return result.join(' ');
}