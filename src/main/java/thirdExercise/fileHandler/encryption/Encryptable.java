package thirdExercise.fileHandler.encryption;

public interface Encryptable {
    void encrypt(String source, String target, String password) throws Exception;
    void decrypt(String source, String target, String password) throws Exception;
}
