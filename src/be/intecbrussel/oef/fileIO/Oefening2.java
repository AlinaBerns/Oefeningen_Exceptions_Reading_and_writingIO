package be.intecbrussel.oef.fileIO;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Oefening2 {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";

    public static void main(String[] args) {


        //We gaan nu werken met bestanden en mappen.
        //We gaan een programma schrijven dat een nieuwe map aanmaakt met een bestand daarin.
        //
        //Schrijf enkele regels tekst naar het bestand.
        //Lees de tekst terug van het bestand.
        //Hernoem het bestand. Gebruik hiervoor de methode Files.move()
        //Druk wat kenmerken van een bestand af. Zoals bijvoorbeeld de size, is het readonly enz.
        //Druk de gegevens van de eigenaar van het bestand af. (Zoek zelf naar een manier om dit te doen)

        Path path = Path.of("oef2/newFile.txt");

        try {
            Files.createDirectory(path.getParent());
            if (Files.notExists(path)){
                Files.createFile(path);
                System.out.println(ANSI_GREEN + "File created!!!" + ANSI_RESET);
            }
        } catch (IOException e) {
            System.err.println("Not possible");
        }
    }
}
