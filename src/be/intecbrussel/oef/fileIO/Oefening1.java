package be.intecbrussel.oef.fileIO;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.FileTime;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

//Schrijf een programma dat kijkt of een file bestaat
//en wanneer het voor het laatst is gemodificeerd.
public class Oefening1 {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";

    public static boolean isFileExist (File file) {
        return file.exists() && !file.isDirectory();
    }

    private static void printFileTime (FileTime fileTime) {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy - hh:mm:ss");
        System.out.println(dateFormat.format(fileTime.toMillis()));
    }

    public static void main(String[] args) {
        String filePath = "C:\\Users\\AlinaB\\IdeaProjects\\Oefeningen_Exceptions\\myfolder\\mynewfile.txt";
        File file = new File(filePath);

        if (isFileExist(file)) {
            System.out.println(ANSI_GREEN + "File exists!!!" + ANSI_RESET);
        }
        else {
            System.err.println("File doesn't exist or program doesn't have access " +
                    "to the file");
        }

        FileTime fileTime;

        try {
            fileTime = Files.getLastModifiedTime(file.toPath());
            printFileTime(fileTime);
        } catch (IOException e) {
            System.err.println("Cannot get the last modified time - " + e);
        }

    }

}
