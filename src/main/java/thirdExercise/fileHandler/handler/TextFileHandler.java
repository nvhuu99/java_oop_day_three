package thirdExercise.fileHandler.handler;

import java.nio.file.*;

public class TextFileHandler extends FileHandler {
    private String content;

    public TextFileHandler(String filePath) {
        super(filePath);
    }

    @Override
    public void read() throws Exception {
        content = Files.readString(path);
    }

    @Override
    public void write(String newLocation) throws Exception {
        Path target = newLocation == null ? path : Paths.get(newLocation);
        Files.writeString(target, content);
    }
}
