package filterapp.StatisticsService;

import java.util.List;

public class StringStatsCalculator implements IStatsCalculator<String, StringResultDTO> {

    @Override
    public StringResultDTO Calculate(List<String> list, boolean isFullStatistics) {
        var dto = new StringResultDTO();
        dto.count = list.size();
        if (isFullStatistics) {
            dto.maxLength = CalculateLongest(list);
            dto.minLength = CalculateShortest(list);
        }
        return dto;
    }
    public int CalculateLongest(List<String> list) {
        return list.stream().mapToInt(String::length)
                .max()
                .orElse(0);
    }
    public int CalculateShortest(List<String> list) {
              return list.stream().mapToInt(String::length)
                .min()
                .orElse(0);
    }
}