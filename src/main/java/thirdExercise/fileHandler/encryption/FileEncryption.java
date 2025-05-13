package thirdExercise.fileHandler.encryption;

import javax.crypto.*;
import javax.crypto.spec.*;
import java.io.*;
import java.security.*;

public final class FileEncryption implements Encryptable {
    private static final String ALGO = "AES/CBC/PKCS5Padding";
    private static final byte[] IV = new byte[16];

    @Override
    public void encrypt(String source, String target, String password) throws Exception {
        Cipher cipher = initCipher(Cipher.ENCRYPT_MODE, password);
        processFile(cipher, source, target);
    }

    @Override
    public void decrypt(String source, String target, String password) throws Exception {
        Cipher cipher = initCipher(Cipher.DECRYPT_MODE, password);
        processFile(cipher, source, target);
    }

    private Cipher initCipher(int mode, String password) throws Exception {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        SecretKeySpec key = new SecretKeySpec(md.digest(password.getBytes()), "AES");
        IvParameterSpec ivSpec = new IvParameterSpec(IV);
        Cipher cipher = Cipher.getInstance(ALGO);
        cipher.init(mode, key, ivSpec);
        return cipher;
    }

    private void processFile(Cipher cipher, String source, String target) throws Exception {
        try (FileInputStream fis = new FileInputStream(source);
             FileOutputStream fos = new FileOutputStream(target);
             CipherOutputStream cos = new CipherOutputStream(fos, cipher)) {
            fis.transferTo(cos);
        }
    }
}
