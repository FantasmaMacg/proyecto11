package es.santander.ascender.proyecto11;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class FileProcesor implements IFileProcesor {

    public String leerFile(String filePath) throws IOException {
        return Files.lines(Paths.get(filePath))
                .collect(Collectors.joining(System.lineSeparator()));
    }

    public String eliminarVocales(String input) {

        if (input == null) {
            return input;
        }

        return input.chars()
                .filter(a -> "AaEeIiOoUu".indexOf(a) == -1)
                .mapToObj(a -> String.valueOf((char) a))
                .collect(Collectors.joining());
    }

    public void escribirAFile(String filePath, String content) throws Exception {
        
        try (FileOutputStream fos = new FileOutputStream(filePath)) {
            fos.write(content.getBytes());
        }

    }

}
