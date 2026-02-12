package filterapp;

import filterapp.ArgParser.ArgumentParser;
import filterapp.ArgParser.ArgumentsDTO;
import filterapp.FileService.FileService;
import filterapp.StatisticsService.StatisticsService;
import picocli.CommandLine;

public class Main {
    public static void main(String[] args) {

        var parser = new ArgumentParser();
        CommandLine cmd = new CommandLine(parser);
        int exitCode = cmd.execute(args);
        if (exitCode != 0) {
            System.exit(exitCode);  
            return;
        }
        ArgumentsDTO dto = parser.call();




        var fileService = new FileService();
        var statService = new StatisticsService();
        var controller = new Controller(fileService, statService);
        controller.Filter(dto);

    }
}