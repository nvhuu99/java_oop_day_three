package thirdExercise.fileHandler.app;

import thirdExercise.fileHandler.handler.*;
import thirdExercise.fileHandler.compression.ZipArchive;
import thirdExercise.fileHandler.encryption.FileEncryption;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class FileManagerApp {
    public static void main(String[] args) {
        System.out.println("Help:\n 1. moveFiles \"<from>\" \"<to>\"\n 2. deleteFile \"<path>\"\n 3. compressAndEncrypt \"<src>\" \"<password>\"\n 4. decryptAndExtract \"<archive>\" \"<password>\"");
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("$ ");
            String line = sc.nextLine().trim();
            if (line.equalsIgnoreCase("exit")) break;
            String[] parts = line.split("\\s+");
            try {
                switch (parts[0]) {
                    case "moveFiles" -> handleMove(parts[1], parts[2]);
                    case "deleteFile" -> handleDelete(parts[1]);
                    case "compressAndEncrypt" -> handleCompressEncrypt(parts[1], parts[2]);
                    case "decryptAndExtract" -> handleDecryptExtract(parts[1], parts[2]);
                    default -> {}
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        sc.close();
    }

    private static void handleMove(String src, String dst) throws Exception {
        FileHandler handler = createHandler(src);
        handler.read();
        handler.write(dst);
        handler.delete();
    }

    private static void handleDelete(String path) throws IOException {
        FileHandler handler = createHandler(path);
        handler.delete();
    }

    private static void handleCompressEncrypt(String src, String pwd) throws Exception {
        String zip = src + ".zip";
        new ZipArchive().compress(src, zip);
        new FileEncryption().encrypt(zip, zip + ".enc", pwd);
    }

    private static void handleDecryptExtract(String enc, String pwd) throws Exception {
        String zip = enc.replaceFirst("\\.enc$", "");
        new FileEncryption().decrypt(enc, zip, pwd);
        new ZipArchive().decompress(zip, zip.replaceFirst("\\.zip$", "_extracted"));
    }

    private static FileHandler createHandler(String path) {
        String ext = Paths.get(path).getFileName().toString();
        ext = ext.contains(".") ? ext.substring(ext.lastIndexOf('.') + 1).toLowerCase() : "";
        return switch (ext) {
            case "png", "jpg", "jpeg", "bmp", "gif" -> new ImageFileHandler(path, ext);
            case "mp4", "avi", "mkv" -> new VideoFileHandler(path, ext);
            default -> new TextFileHandler(path);
        };
    }
}
