const crypto = require('crypto');

function convertTextToHash(text) {
    if (!text) {
        return null;
    }
    const encodedString = Buffer.from(text, 'utf-8');
    const md5Hash = crypto.createHash('md5').update(encodedString).digest('hex');
    return md5Hash;
}