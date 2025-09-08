function fileNameCheck(fileName) {
    const suf = ['txt', 'exe', 'dll'];
    const [name, extension] = fileName.split('.');
    if (extension.length !== 2) return 'No';
    if (!suf.includes(extension)) return 'No';
    if (name.length === 0) return 'No';
    if (!name[0].match(/[a-zA-Z]/)) return 'No';
    const digitCount = [...name].filter(char => /\d/.test(char)).length;
    if (digitCount > 3) return 'No';
    return 'Yes';
}