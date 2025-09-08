const crypto = require('crypto');

function convertTextToHash(inputString) {
    if (!inputString) {
        return null;
    }
    const encodedString = Buffer.from(inputString, 'ascii');
    const md5Hash = crypto.createHash('md5').update(encodedString).digest('hex');
    return md5Hash;
}

// method name: string_to_md5 -> convertTextToHash
// parameter name: text -> inputString
// moved the import statement outside the function
// replaced the conditional expression with an if statement for clarity
// split the encoding and hashing steps for better readability