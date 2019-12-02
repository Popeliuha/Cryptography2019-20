const alphabet = 'abcdefghijklmnopqrstuvwxyz';

const encrypt = document.getElementById('encrypt');
const decrypt = document.getElementById('decrypt');

encrypt.addEventListener('click', event => {
    event.preventDefault();

    const textArea = document.getElementById('text');
    const resultArea = document.getElementById('result');
    const key = document.getElementById('key');

    if (!isFinite(key.value)) {
        alert('Key must be a number');
    } else {
        resultArea.value = encryptText(textArea.value, key.value);
    }
});

decrypt.addEventListener('click', event => {
    event.preventDefault();

    const textArea = document.getElementById('text');
    const resultArea = document.getElementById('result');
    const key = document.getElementById('key');

    if (!isFinite(key.value)) {
        alert('Key must be a number');
    } else {
        resultArea.value = decryptText(textArea.value, key.value);
    }
});

function encryptText(text, key) {
    key = key % 26;
    const splitterText = text.toLowerCase().split('');

    const result = splitterText.map(letter => {
        if (letter !== ' ' && alphabet.indexOf(letter) !== -1) {
            const letterPosition = alphabet.indexOf(letter);
            return (letterPosition + key) % 26;
        } else {
            return 25;
        }
    });

    for (var i = 0; i < alphabet.length; i++) {
        var letter = alphabet.charAt(i);

        const letterPosition = alphabet.indexOf(letter);

        var row1 = document.getElementById('letterRow');
        var cell1 = row1.insertCell(-1);
        cell1.innerHTML = letter;
        cell1.width='25px';

        var row2 = document.getElementById('valueRow');
        var cell2 = row2.insertCell(-1);
        cell2.innerHTML = "" + (letterPosition + key) % 26;
    }

    return result.join();
}

function decryptText(text, key) {
    key = key % 26;
    const splitterText = text.toLowerCase().split(',');

    const result = splitterText.map(charCode => {
        const letter = alphabet[charCode];
        if (alphabet.indexOf(letter) !== -1) {
            let letterPosition = alphabet.indexOf(letter);
            const additional = Math.abs(letterPosition - key);
            letterPosition = letterPosition - key >= 0 ? letterPosition - key : 26 - additional;
            return alphabet[letterPosition];
        }
    });

    return result.join('');
}
