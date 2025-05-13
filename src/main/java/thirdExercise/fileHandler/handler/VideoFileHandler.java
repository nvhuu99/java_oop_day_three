package thirdExercise.fileHandler.handler;

import java.nio.file.*;

public class VideoFileHandler extends FileHandler {
    private final String format;
    private byte[] data;

    public VideoFileHandler(String filePath, String format) {
        super(filePath);
        this.format = format.toLowerCase();
    }

    @Override
    public void read() throws Exception {
        data = Files.readAllBytes(path);
    }

    @Override
    public void write(String newLocation) throws Exception {
        Path out = newLocation == null ? path : Paths.get(newLocation);
        Files.write(out, data);
    }
}
