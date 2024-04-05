class CaesarCipher {
    public static void main(String[] args) {
        String plaintext = "Hello, World!";
        int shiftKey = 3;

        // Encryption
        String encryptedText = encrypt(plaintext, shiftKey);
        System.out.println("Encrypted: " + encryptedText);

        // Decryption
        String decryptedText = decrypt(encryptedText, shiftKey);
        System.out.println("Decrypted: " + decryptedText);
    }

    // Encryption method
    public static String encrypt(String plaintext, int shiftKey) {
        StringBuilder cipherText = new StringBuilder();

        for (char character : plaintext.toCharArray()) {
            if (Character.isLetter(character)) {
                char base = Character.isUpperCase(character) ? 'A' : 'a';
                char encryptedChar = (char) (((character - base + shiftKey) % 26) + base);
                cipherText.append(encryptedChar);
            } else {
                cipherText.append(character);
            }
        }

        return cipherText.toString();
    }

    // Decryption method
    public static String decrypt(String encryptedText, int shiftKey) {
        return encrypt(encryptedText, 26 - shiftKey); // Decryption is just encryption with the opposite shift
    }
}
