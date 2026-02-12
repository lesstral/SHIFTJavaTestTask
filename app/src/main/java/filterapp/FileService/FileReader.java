package filterapp.FileService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class FileReader {

    public List<String> Read(List<String> pathList) {
        List<String> result = new ArrayList<>();
        
        for (var path : pathList) {
            if(isValidPath(path)) {
                try (Stream<String> fileStream = Files.lines(Paths.get(path))) {
                    fileStream.map(line -> {
                        // из-за BOM парсер считал что число = строка
                    if (line != null && line.length() > 0 && line.charAt(0) == '\uFEFF') {
                            return line.substring(1);
                    }
                    return line;
                }).forEach(result::add);
                } catch (IOException e) {
                    System.err.println("Ошибка при чтении файла " + path + e.getMessage());
                }
                
            }
        }
    
        return result;
    }

    public boolean isValidPath(String path) {
        try {
            Paths.get(path);
        } catch (InvalidPathException | NullPointerException e) {
            System.err.println("Ошибка при чтении файла " + path + e.getMessage());
            return false;
        }
        return true;
    }
}