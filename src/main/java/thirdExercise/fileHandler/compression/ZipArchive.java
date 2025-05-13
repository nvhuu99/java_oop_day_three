package thirdExercise.fileHandler.compression;

import java.io.*;
import java.nio.file.*;
import java.util.zip.*;

public final class ZipArchive implements Compressible {
    @Override
    public void compress(String source, String target) throws IOException {
        try (ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(target))) {
            Path srcPath = Paths.get(source);
            try (InputStream fis = Files.newInputStream(srcPath)) {
                ZipEntry entry = new ZipEntry(srcPath.getFileName().toString());
                zos.putNextEntry(entry);
                fis.transferTo(zos);
            }
        }
    }

    @Override
    public void decompress(String source, String target) throws IOException {
        try (ZipInputStream zis = new ZipInputStream(new FileInputStream(source))) {
            ZipEntry entry;
            while ((entry = zis.getNextEntry()) != null) {
                Path outPath = Paths.get(target, entry.getName());
                Files.createDirectories(outPath.getParent());
                try (OutputStream fos = new FileOutputStream(outPath.toFile())) {
                    zis.transferTo(fos);
                }
            }
        }
    }
}
