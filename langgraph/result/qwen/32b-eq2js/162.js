const crypto = require('crypto');

function convertTextToHash(inputString) {
    if (!inputString) {
        return null;
    }
    const encodedString = Buffer.from(inputString, 'ascii');
    const md5Hash = crypto.createHash('md5').update(encodedString).digest('hex');
    return md5Hash;
}