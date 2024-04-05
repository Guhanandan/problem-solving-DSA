import java.math.BigInteger;
import java.security.SecureRandom;

class RSA {
    private BigInteger privateKey;
    private BigInteger publicKey;
    private BigInteger modulus;

    public static void main(String[] args) {
        RSA rsa = new RSA(512); // You can adjust the key size (e.g., 1024, 2048) based on your security needs

        String message = "Hello, RSA!";
        System.out.println("Original message: " + message);

        // Encrypt the message
        BigInteger encrypted = rsa.encrypt(message);
        System.out.println("Encrypted message: " + encrypted);

        // Decrypt the message
        String decrypted = rsa.decrypt(encrypted);
        System.out.println("Decrypted message: " + decrypted);
    }

    public RSA(int bits) {
        generateKeys(bits);
    }

    private void generateKeys(int bits) {
        SecureRandom random = new SecureRandom();

        // Generate two large random prime numbers, p and q
        BigInteger p = new BigInteger(bits, 100, random);
        BigInteger q = new BigInteger(bits, 100, random);

        // Compute n = p * q
        modulus = p.multiply(q);

        // Compute the totient (p-1)(q-1)
        BigInteger totient = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));

        // Choose an public exponent e such that 1 < e < totient and gcd(e, totient) = 1
        publicKey = new BigInteger("65537"); // Commonly used value for e

        // Compute the private exponent d such that d * e ≡ 1 (mod totient)
        privateKey = publicKey.modInverse(totient);
    }

    public BigInteger encrypt(String message) {
        // Convert the message to a BigInteger
        BigInteger plaintext = new BigInteger(message.getBytes());

        // Encrypt the message: ciphertext ≡ plaintext^publicKey (mod modulus)
        return plaintext.modPow(publicKey, modulus);
    }

    public String decrypt(BigInteger ciphertext) {
        // Decrypt the message: plaintext ≡ ciphertext^privateKey (mod modulus)
        BigInteger decrypted = ciphertext.modPow(privateKey, modulus);

        // Convert the decrypted BigInteger to a string
        return new String(decrypted.toByteArray());
    }
}
