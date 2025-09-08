function nextSmallest(lst) {
    const uniqueSorted = [...new Set(lst)].sort((a, b) => a - b);
    return uniqueSorted.length < 2 ? null : uniqueSorted[1];
}