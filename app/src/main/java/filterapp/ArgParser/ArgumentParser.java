package filterapp.ArgParser;
import java.util.List;
import java.util.concurrent.Callable;

import picocli.CommandLine.ArgGroup;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

public class ArgumentParser implements Callable<ArgumentsDTO> {


    @Parameters(index = "*", arity="1..*", description= "File input path")
    List<String> _inputFiles;
    @Option(names = {"-o", "--output"},  description="File output path")
    String _outputPath;
    @Option(names = {"-p", "--prefix"}, description="File name frefix")
    String _prefix;
    @Option(names = {"-a", "--append"},  description="Append existing files") 
    Boolean _append = false;
    @ArgGroup(exclusive = true)
    ExclusiveStats _statisticsMode;

    static class ExclusiveStats {
        @Option(
            names = {"-s", "--short"},
            description = "Short statistics"
        )
        boolean shortStats;
        
        @Option(
            names = {"-f", "--full"},
            description = "Full statistics"
        )
        boolean fullStats;
    }
    

    @Override
    public ArgumentsDTO  call() {

    ArgumentsDTO argumentsDTO = new ArgumentsDTO();
    argumentsDTO.inputFiles = _inputFiles;
    argumentsDTO.append = _append;
    argumentsDTO.outputPath = _outputPath;
    argumentsDTO.prefix = _prefix;
    if (_statisticsMode != null) {
        argumentsDTO.statisticsFull = _statisticsMode.fullStats ?
    _statisticsMode.fullStats : _statisticsMode.shortStats;
    }
    else
    {
        argumentsDTO.statisticsFull = false;
    }

     return argumentsDTO;
    }
}