function fileNameCheck(fileName) {
    const suf = ['txt', 'exe', 'dll'];
    const lst = fileName.split('.');
    if (lst.length !== 2) {
        return 'No';
    }
    if (!suf.includes(lst[1])) {
        return 'No';
    }
    if (lst[0].length === 0) {
        return 'No';
    }
    if (!/^[a-zA-Z]/.test(lst[0][0])) {
        return 'No';
    }
    const t = (lst[0].match(/\d/g) || []).length;
    if (t > 3) {
        return 'No';
    }
    return 'Yes';
}