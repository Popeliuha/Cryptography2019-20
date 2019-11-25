const alphabet = 'abcdefghijklmnopqrstuvwxyz';

const encrypt = document.getElementById('encrypt');
const decrypt = document.getElementById('decrypt');

encrypt.addEventListener('click', event => {
    event.preventDefault();

    const key = document.getElementById('key').value;
    const text = document.getElementById('text').value;
    const result = document.getElementById('result');

    if (checkKey(key)) {
        result.value = encryptText(text, key);
    } else {
        alert('Bad key');
    }
});

decrypt.addEventListener('click', event => {
    event.preventDefault();

    const key = document.getElementById('key').value;
    const text = document.getElementById('text').value;
    const result = document.getElementById('result');

    if (checkKey(key)) {
        result.value = decryptText(text, key);
    } else {
        alert('Bad key');
    }
});

function encryptText(text, key) {
    const gamma = generateGamma(key, text.length);
    document.getElementById('gamma').value = gamma.join();

    return text.split('').map((letter, index) => {
        if (alphabet.indexOf(letter) !== -1) {
            const letterPosition = alphabet.indexOf(letter);
            return (letterPosition + gamma[index]) % 26;
        } else {
            const letterPosition = alphabet.indexOf('q');
            return (letterPosition + gamma[index]) % 26;
        }
    }).join(', ');
}

function decryptText(text, key) {
    const gamma = generateGamma(key, text.split(', ').length);
    document.getElementById('gamma').value = gamma.join();

    return text.split(', ').map((letter, index) => {
        const position = (parseInt(letter) + (26 - gamma[index])) % 26;
        return alphabet[position]; 
    }).join('');
}

function generateGamma(key, length) {
    const sequence = [...key.trim().split(' ')];

    for (let i = 3; i < length + 1; i++) {
        sequence.push((parseInt(sequence[i - 1]) + parseInt(sequence[i - 3])) % 26);
    }

    const gamma = [];

    for (let i = 0; i < length; i++) {
        gamma.push((parseInt(sequence[i]) + parseInt(sequence[i + 1])) % 26);
    }

    return gamma;
}

function checkKey(key) {
    const splitted = key.trim().split(' ');

    if (splitted.length !== 3) {
        alert('Key must have 3 digits');
        return false;
    }

    return splitted.every(num => isFinite(num));
}
