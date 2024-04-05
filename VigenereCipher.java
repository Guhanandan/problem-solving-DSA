public class VigenereCipher {
    public static void main(String[] args) {
        String plaintext = "Hello, World!";
        String keyword = "KEY";

        // Encryption
        String encryptedText = encrypt(plaintext, keyword);
        System.out.println("Encrypted: " + encryptedText);

        // Decryption
        String decryptedText = decrypt(encryptedText, keyword);
        System.out.println("Decrypted: " + decryptedText);
    }

    // Encryption method
    public static String encrypt(String plaintext, String keyword) {
        StringBuilder cipherText = new StringBuilder();
        int keywordLength = keyword.length();

        for (int i = 0; i < plaintext.length(); i++) {
            char character = plaintext.charAt(i);

            if (Character.isLetter(character)) {
                char base = Character.isUpperCase(character) ? 'A' : 'a';
                char encryptedChar = (char) (((character + keyword.charAt(i % keywordLength) - 2 * base) % 26) + base);
                cipherText.append(encryptedChar);
            } else {
                cipherText.append(character);
            }
        }

        return cipherText.toString();
    }

    // Decryption method
    public static String decrypt(String encryptedText, String keyword) {
        StringBuilder decryptedText = new StringBuilder();
        int keywordLength = keyword.length();

        for (int i = 0; i < encryptedText.length(); i++) {
            char character = encryptedText.charAt(i);

            if (Character.isLetter(character)) {
                char base = Character.isUpperCase(character) ? 'A' : 'a';
                char decryptedChar = (char) (((character - keyword.charAt(i % keywordLength) + 26) % 26) + base);
                decryptedText.append(decryptedChar);
            } else {
                decryptedText.append(character);
            }
        }

        return decryptedText.toString();
    }
}
