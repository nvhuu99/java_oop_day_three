package thirdExercise.fileHandler.handler;

import java.io.IOException;
import java.nio.file.*;

public abstract class FileHandler {
    protected Path path;

    public FileHandler(String filePath) {
        this.path = Paths.get(filePath);
    }

    public abstract void read() throws Exception;
    public abstract void write(String newLocation) throws Exception;

    public void delete() throws IOException {
        Files.deleteIfExists(path);
    }
}
