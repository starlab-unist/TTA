function generateNumberSeries(n) {
    let numberList = [];
    let index = 0;

    while (index <= n) {
        numberList.push(String(index));
        index += 1;
    }

    let series = numberList.join(' ');
    return series;
}