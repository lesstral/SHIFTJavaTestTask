package filterapp.StatisticsService;

import filterapp.utils.IPrintable;

public class NumericResultDTO implements ICountable {
    @IPrintable(name = "Кол-во элементов", showOnlyInFullStats= false)
    public int count;
    @IPrintable(name = "Сумма")
    public float sum;
    @IPrintable(name = "Макс. значение")
    public float max;
    @IPrintable(name = "Мин. значение")
    public float min;
    @IPrintable(name = "Среднее значение")
    public float  mean;
    
    public int GetCount() { return count;}

}