function splitWords(txt) {
    if (txt.includes(" ")) {
        return txt.split();
    } else if (txt.includes(",")) {
        return txt.replace(',', ' ').split();
    } else {
        return [...txt].filter(i => i === i.toLowerCase() && (i.charCodeAt(0) - 97) % 2 === 0).length;
    }
}