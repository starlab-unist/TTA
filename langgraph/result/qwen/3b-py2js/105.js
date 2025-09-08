function byLength(arr) {
    const dic = {
        1: "One",
        2: "Two",
        3: "Three",
        4: "Four",
        5: "Five",
        6: "Six",
        7: "Seven",
        8: "Eight",
        9: "Nine",
    };
    const sortedArr = arr.sort((a, b) => b - a);
    const newArr = [];
    sortedArr.forEach(var => {
        if (dic.hasOwnProperty(var)) {
            newArr.push(dic[var]);
        }
    });
    return newArr;
}