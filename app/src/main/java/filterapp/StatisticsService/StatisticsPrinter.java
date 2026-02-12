package filterapp.StatisticsService;

import java.lang.reflect.Field;

import filterapp.utils.IPrintable;

public class StatisticsPrinter {
    public static void PrintIndividualDTO(Object dto, boolean statisticsFull, String type) throws IllegalAccessException {
        if (dto instanceof ICountable countable) {
        if (countable.GetCount() == 0) return;
        }
        
        System.out.println("\nСтатистика (" + (statisticsFull ? "полная" : "краткая") + "): " 
        + type);

        for (Field field : dto.getClass().getDeclaredFields()) {
            
            field.setAccessible(true);
            IPrintable ann = field.getAnnotation(IPrintable.class);
            if (ann == null) {
                System.err.println("Нет аннотации у поля " + field + " пропускаю");
                continue;
            }              
            if (!statisticsFull && ann.showOnlyInFullStats()) continue;      

            String displayName = ann.name().isEmpty() ? field.getName() : ann.name();
            Object value = field.get(dto);
            PrintLine(displayName, String.valueOf(value));
        }
    }
    public static void Print(Object dto, boolean statisticsFull) throws IllegalAccessException {
        for (Field field : dto.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            IPrintable ann = field.getAnnotation(IPrintable.class);
            Object value = field.get(dto);  // проверяем примитивный ли тип
            if (value == null) {
                System.err.println("Ошибка чтения поля " + field + " пропускаю");
                continue;
            }
            if (ann == null) {
                System.err.println("Нет аннотации у поля " + field + " пропускаю");
                continue;
            }    

            
            PrintIndividualDTO(value, statisticsFull, ann.name());
        }
    }
    private static void PrintLine(String varName, String varValue) {
        System.out.printf("%-15s | %s%n", varName, varValue);
    }
}