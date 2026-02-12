package filterapp.StatisticsService;

import filterapp.FileService.ParsedDataDTO;
public class StatisticsService {

    public void CalculateAndPrint(ParsedDataDTO parsedDto, boolean isFullStatistics) {
        
        var statsResultsDTO = new StatisticsResultDTO();

        statsResultsDTO.intResultDTO = new NumericStatsCalculator<Long>().Calculate(parsedDto.intList, isFullStatistics);
        statsResultsDTO.floatResultDTO = new NumericStatsCalculator<Double>().Calculate(parsedDto.floatList, isFullStatistics);
        statsResultsDTO.stringResultDTO = new StringStatsCalculator().Calculate(parsedDto.stringList, isFullStatistics);
        try {
            StatisticsPrinter.Print(statsResultsDTO, isFullStatistics);
        } catch (IllegalAccessException e) {
            System.err.println("Ошибка при подсчёте статистики" + e.getMessage());
        }
        

        
        //System.out.println(intDTO.count + " " + intDTO.max + " " + intDTO.min);
            
    }
    
}