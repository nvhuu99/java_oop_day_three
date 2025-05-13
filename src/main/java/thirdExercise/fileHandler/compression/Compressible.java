package thirdExercise.fileHandler.compression;

public interface Compressible {
    void compress(String source, String target) throws Exception;
    void decompress(String source, String target) throws Exception;
}
