package filterapp.FileService;

import java.io.IOException;
import java.util.List;

public class FileService {

    FileParser _parser;
    FileWriter _writer;
    FileReader _reader;

    public FileService() {
        _parser = new FileParser();
        _writer = new FileWriter();
        _reader = new FileReader();
    }

    public ParsedDataDTO ReadAndParse(List<String> pathList) {

       List<String> fileData = _reader.Read(pathList);
       ParsedDataDTO dto = _parser.Parse(fileData);
       return dto;
    }
    public void SaveLists(ParsedDataDTO dto, String prefix, String path, boolean append) {
        _writer.Setup(append, prefix, path);
        try {
            _writer.Write(dto);
        }  
        catch (IllegalAccessException | IOException e) {
            System.err.println("Ошибка при сохранении файла " + e.getMessage());
        } 
        
    }

}