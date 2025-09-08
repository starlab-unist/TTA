function generateNumberSeries(length) {
    const numberList = [];
    let index = 0;

    while (index <= length) {
        numberList.push(String(index));
        index += 1;
    }

    const series = numberList.join(' ');
    return series;
}