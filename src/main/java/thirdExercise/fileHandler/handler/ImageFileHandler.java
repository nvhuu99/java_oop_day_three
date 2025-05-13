package thirdExercise.fileHandler.handler;

import java.io.IOException;
import java.nio.file.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class ImageFileHandler extends FileHandler {
    private final String format;
    private BufferedImage image;

    public ImageFileHandler(String filePath, String format) {
        super(filePath);
        this.format = format.toLowerCase();
    }

    @Override
    public void read() throws Exception {
        image = ImageIO.read(path.toFile());
        if (image == null) {
            throw new IOException("Unsupported image format: " + format);
        }
    }

    @Override
    public void write(String newLocation) throws Exception {
        Path out = newLocation == null ? path : Paths.get(newLocation);
        if (!ImageIO.write(image, format, out.toFile())) {
            throw new IOException("Failed to write image with format: " + format);
        }
    }
}
