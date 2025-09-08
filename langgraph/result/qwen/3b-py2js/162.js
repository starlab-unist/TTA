function stringToMD5(text) {
    if (!text) return null;
    const crypto = require('crypto');
    return crypto.createHash('md5').update(text).digest('hex');
}