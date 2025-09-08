function compare_parity(list_a, list_b) {
    let odd_count = 0;
    let even_count = 0;
    let index = 0;

    while (index < list_a.length) {
        if (list_a[index] % 2 !== 0) {
            odd_count += 1;
        }
        index += 1;
    }

    index = 0;
    while (index < list_b.length) {
        if (list_b[index] % 2 === 0) {
            even_count += 1;
        }
        index += 1;
    }

    return even_count >= odd_count ? "YES" : "NO";
}