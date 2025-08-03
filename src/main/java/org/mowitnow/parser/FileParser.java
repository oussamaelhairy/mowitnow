package org.mowitnow.parser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;
import java.util.List;


//utilitaire pour parser et valider le fichier (contenu, nombre de ligne doit être impaire)
public interface FileParser {
    static List<String> parseFile(String filePath) {
        try {
            List<String> lines = Files.lines(Paths.get(filePath))
                    .map(String::trim)
                    .filter(line -> !line.isBlank())
                    .toList();
            if(lines.isEmpty() || lines.size() % 2 == 0)
                throw new IllegalArgumentException("Le fichier n'est pas valide");
            return lines;
        } catch (IOException e) {
            throw new RuntimeException("Erreur lors de la lecture du fichier");
        } catch(InvalidPathException e) {
            throw new InvalidPathException(filePath, "Le chemin du fichier n'est pas valide");
        }
    }
}
