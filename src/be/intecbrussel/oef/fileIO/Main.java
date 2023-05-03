package be.intecbrussel.oef.fileIO;

import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {

        try {
            // define path
            Path path = Path.of("myfolder/myfile.txt");

            // create parent directories
            Files.createDirectories(path.getParent());

            // create if not exists
            if (Files.notExists(path)) {
                Files.createFile(path);
                System.out.println("File created");
            } else {
                System.err.println("File already exist");
            }

            // write lines of text to file
            List<String> lines = new ArrayList<>();
            lines.add("Hello");
            lines.add("Intec Brussel");
            Files.write(path, lines, StandardCharsets.UTF_8, StandardOpenOption.APPEND);

            // Read lines of text from file
            Files.lines(path).forEach(System.out::println);

            // Copy the file
            Path path2 = Paths.get("myfolder/mynewfile.txt");
            Files.copy(path, path2, StandardCopyOption.REPLACE_EXISTING);

            // Delete file
            Files.deleteIfExists(path);

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

    }
}


