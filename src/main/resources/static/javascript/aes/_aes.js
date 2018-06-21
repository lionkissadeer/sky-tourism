var _aes = {
    encrypt: function (val) {
        var key = CryptoJS.enc.Utf8.parse("!@#$%^&*()_+~<>?");
        var srcs = CryptoJS.enc.Utf8.parse(val);
        var encrypted = CryptoJS.AES.encrypt(srcs, key, {mode: CryptoJS.mode.ECB, padding: CryptoJS.pad.Pkcs7});
        return encrypted.toString();
    },
    decrypt: function (val) {
        var key = CryptoJS.enc.Utf8.parse("!@#$%^&*()_+~<>?");
        var decrypt = CryptoJS.AES.decrypt(val, key, {mode: CryptoJS.mode.ECB, padding: CryptoJS.pad.Pkcs7});
        return CryptoJS.enc.Utf8.stringify(decrypt).toString();
    }
};