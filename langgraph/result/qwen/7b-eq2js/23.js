function calculateStringLength(string) {
    let count = 0;
    for (let character of string) {
        count += 1;
    }
    return count;
}
// method name: strlen -> calculateStringLength
// parameter name: string -> text
// replaced length property with a manual counting loop