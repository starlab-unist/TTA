function stringToMd5(text) {
    if (!text) return null;
    const encoder = new TextEncoder();
    const data = encoder.encode(text);
    return crypto.subtle.digest('MD5', data).then(hashBuffer => {
        const hashArray = Array.from(new Uint8Array(hashBuffer));
        const hashHex = hashArray.map(byte => byte.toString(16).padStart(2, '0')).join('');
        return hashHex;
    });
}