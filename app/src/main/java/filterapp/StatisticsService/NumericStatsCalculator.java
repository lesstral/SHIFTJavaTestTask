package filterapp.StatisticsService;

import java.util.Collections;
import java.util.List;

public class NumericStatsCalculator<T extends Number & Comparable<T>> implements IStatsCalculator<T, NumericResultDTO> {

    @Override
    public NumericResultDTO Calculate(List<T> list, boolean isFullStatistics) {
        var dto = new NumericResultDTO();
        dto.count = list.size();
        if (isFullStatistics && !list.isEmpty()) {
            dto.max = Collections.max(list).floatValue();
            dto.min = Collections.min(list).floatValue();
            dto.mean = CalculateMean(list);
            dto.sum = CalculateSum(list);
        }
        
        return dto;
    }
    public float CalculateMean(List<T> list) {
        float sum = 0;
        for (T element : list) {
            sum += element.floatValue();
        }
        float mean = list.isEmpty() ? 0 : sum / list.size();
        return mean;
    }
    // TODO: обьеденить 
    public float CalculateSum(List<T> list) {
        float sum = 0;
        for (T element : list) {
            sum += element.floatValue();
        }
        return sum;
    }
    
}