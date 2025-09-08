function wordsInSentence(sentence) {
    const newLst = [];
    const words = sentence.split();
    for (const word of words) {
        let flg = 0;
        if (word.length === 1) {
            flg = 1;
        }
        for (let i = 2; i < word.length; i++) {
            if (word.length % i === 0) {
                flg = 1;
            }
        }
        if (flg === 0 || word.length === 2) {
            newLst.push(word);
        }
    }
    return newLst.join(" ");
}