function validateFileIdentifier(filename) {
    const validExtensions = ['txt', 'exe', 'dll'];
    const parts = filename.split('.').slice(-2);
    
    if (parts.length !== 2) {
        return 'No';
    }
    
    const [name, extension] = parts;
    if (!validExtensions.includes(extension)) {
        return 'No';
    }
    
    if (!name) {
        return 'No';
    }
    
    if (!/^[a-zA-Z]/.test(name)) {
        return 'No';
    }
    
    const digitCount = (name.match(/\d/g) || []).length;
    if (digitCount > 3) {
        return 'No';
    }
    
    return 'Yes';
}