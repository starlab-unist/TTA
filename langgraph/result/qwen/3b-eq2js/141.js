function validateFileIdentifier(filename) {
    const validExtensions = ['txt', 'exe', 'dll'];
    const [name, extension] = filename.split('.', 1);

    if (!extension || !name) {
        return 'No';
    }

    if (!validExtensions.includes(extension)) {
        return 'No';
    }

    if (!name[0].match(/[a-zA-Z]/)) {
        return 'No';
    }

    const digitCount = [...name].reduce((count, char) => count + (char.match(/\d/) ? 1 : 0), 0);
    if (digitCount > 3) {
        return 'No';
    }

    return 'Yes';
}