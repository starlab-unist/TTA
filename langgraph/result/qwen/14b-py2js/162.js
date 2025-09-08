function stringToMd5(text) {
    const crypto = require('crypto');
    return text ? crypto.createHash('md5').update(text).digest('hex') : null;
}