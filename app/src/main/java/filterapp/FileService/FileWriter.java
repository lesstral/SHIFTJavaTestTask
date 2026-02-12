package filterapp.FileService;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import filterapp.utils.IPrintable;


public class FileWriter {
    boolean _appendMode = false;
    String _prefix;
    String _path;
    
    public void Setup(boolean appendMode, String prefix, String path) {
        _appendMode = appendMode;
        _prefix = prefix;
        _path = path;

    }
    public void Write(ParsedDataDTO dto) throws IllegalAccessException, IOException {
        for (var field : dto.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            IPrintable ann = field.getAnnotation(IPrintable.class);
            Object value = field.get(dto);  // проверяем примитивный ли тип
        if (value == null) {
            System.err.println("Ошибка чтения поля " + field + " пропускаю");
            continue;
        }
        if (ann == null) {
            System.err.println("Нет аннотации у поля " + field + " пропускаю");
             continue;
        }    
        String fileName = buildFileName(_path, _prefix, ann.name());
        WriteInFile((List<?>)value, fileName, _appendMode);
        }
    }
    private String buildFileName(String path, String prefix, String defaultName) throws IOException {
        StringBuilder fullPath = new StringBuilder();
         
        if (path != null && !path.isEmpty()) {
            Files.createDirectories(Paths.get(path));
            fullPath.append(path);
            if (!path.endsWith(File.separator)) {
                fullPath.append(File.separator);
            }
        }
        if (prefix != null && !prefix.isEmpty()) {
            fullPath.append(prefix);
        }
        
        fullPath.append(defaultName);
        fullPath.append(".txt");
        return fullPath.toString();
    }
    private void WriteInFile(List<?> list, String fileName, boolean appendMode) throws IOException {
        if (list == null || list.isEmpty()) {
                System.out.println("ne pishu");
            return;
        }
        
        try (BufferedWriter writer = new BufferedWriter(
            new java.io.FileWriter(fileName, appendMode))) {
                for (Object elem : list) {
                    if (elem == null) continue; 
                    writer.write(elem.toString());
                    writer.newLine();
                } 
            } catch(IOException e) {
            System.err.println("Ошибка при записи " + e.getMessage());
        }
        } 
}