function compare_parity(lst1, lst2) {
    let odd_count = 0;
    let even_count = 0;
    let index = 0;

    while (index < lst1.length) {
        if (lst1[index] % 2 !== 0) {
            odd_count++;
        }
        index++;
    }

    index = 0;
    while (index < lst2.length) {
        if (lst2[index] % 2 === 0) {
            even_count++;
        }
        index++;
    }

    return even_count >= odd_count ? "YES" : "NO";
}