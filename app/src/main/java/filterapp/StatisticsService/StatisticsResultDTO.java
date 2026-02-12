package filterapp.StatisticsService;

import filterapp.utils.IPrintable;

public class StatisticsResultDTO {
    @IPrintable(name="int")
    NumericResultDTO intResultDTO;
    @IPrintable(name="float")
    NumericResultDTO floatResultDTO;
    @IPrintable(name="string")
    StringResultDTO stringResultDTO;
}