function countPersonalStatements(text) {
    const segments = text.split(/[.?!]\s*/);
    let personalStatementCount = 0;

    for (let segment of segments) {
        if (segment.startsWith('I ')) {
            personalStatementCount++;
        }
    }

    return personalStatementCount;
}