package filterapp.FileService;

import java.util.List;

public class FileParser {

    public ParsedDataDTO Parse(List<String> data) {
        ParsedDataDTO parsedData = new ParsedDataDTO();
        if (data.isEmpty()) return parsedData;
        

        

        for (var element : data) {

            if (element == null || element.isEmpty()) {
            parsedData.stringList.add(element);
            continue;
            }
            String trimmed = element.trim();
            try {
                parsedData.intList.add(Long.parseLong(trimmed));
                continue;
            } catch(NumberFormatException  e) {
                
            }
            try {
                parsedData.floatList.add(Double.parseDouble(trimmed));
            } catch(NumberFormatException  e) {
                parsedData.stringList.add(element);
            }
            
            
        }
        return parsedData;
    }

}