package filterapp;


import filterapp.ArgParser.ArgumentsDTO;
import filterapp.FileService.FileService;
import filterapp.StatisticsService.StatisticsService;


public class Controller {
    FileService _fileService;
    StatisticsService _statsService;
    public Controller(FileService fileService, StatisticsService statService) {
        _fileService = fileService;
        _statsService = statService;
    }
    public void Filter(ArgumentsDTO argsDTO) {
        var parsedDTO = _fileService.ReadAndParse(argsDTO.inputFiles);

        _fileService.SaveLists(parsedDTO, argsDTO.prefix, argsDTO.outputPath, argsDTO.append);

        _statsService.CalculateAndPrint(parsedDTO, argsDTO.statisticsFull); 

    }
    
}