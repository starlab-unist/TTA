function mergeStrings(strings) {
    let result = "";
    let index = 0;
    while (index < strings.length) {
        result += strings[index];
        index += 1;
    }
    return result;
}
// method name: concatenate -> mergeStrings
// parameter name: strings -> string_list
// replaced ''.join(strings) with a while loop to concatenate strings manually
// introduced an index variable to iterate through the list