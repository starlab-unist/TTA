function generateNumberSeries(length) {
    let numberList = [];
    let index = 0;

    while (index <= length) {
        numberList.push(index.toString());
        index++;
    }

    let series = numberList.join(' ');
    return series;
}