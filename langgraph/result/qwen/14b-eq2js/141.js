function validateFileIdentifier(filename) {
    const validExtensions = ['txt', 'exe', 'dll'];
    const parts = filename.split('.').reverse();

    if (parts.length !== 2) {
        return 'No';
    }

    const [extension, name] = parts.reverse();
    if (!validExtensions.includes(extension)) {
        return 'No';
    }

    if (!name) {
        return 'No';
    }

    if (!/^[a-zA-Z]/.test(name[0])) {
        return 'No';
    }

    const digitCount = [...name].filter(c => /\d/.test(c)).length;
    if (digitCount > 3) {
        return 'No';
    }

    return 'Yes';
}