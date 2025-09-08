function splitWords(txt) {
    if (txt.includes(" ")) {
        return txt.split(" ");
    } else if (txt.includes(",")) {
        return txt.replace(',', ' ').split();
    } else {
        return txt.split('').filter(char => char.toLowerCase().charCodeAt(0) % 2 === 0).length;
    }
}