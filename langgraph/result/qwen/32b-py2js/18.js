function howManyTimes(string, substring) {
    let times = 0;

    for (let i = 0; i <= string.length - substring.length; i++) {
        if (string.substring(i, i + substring.length) === substring) {
            times++;
        }
    }

    return times;
}