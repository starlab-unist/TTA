function splitWords(txt) {
    if (txt.includes(" ")) {
        return txt.split(" ");
    } else if (txt.includes(",")) {
        return txt.replace(',', ' ').split(" ");
    } else {
        return Array.from(txt).filter(i => i >= 'a' && i <= 'z' && i.charCodeAt(0) % 2 === 0).length;
    }
}