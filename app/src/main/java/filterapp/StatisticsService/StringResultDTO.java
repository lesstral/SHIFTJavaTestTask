package filterapp.StatisticsService;

import filterapp.utils.IPrintable;

public class StringResultDTO implements ICountable{

    @IPrintable(name = "Кол-во элементов", showOnlyInFullStats=false)
    int count;
    @IPrintable(name = "Макс. длина строки")
    int maxLength;
    @IPrintable(name = "Мин. длина строки")
    int minLength;
    public int GetCount() { return count;}
}