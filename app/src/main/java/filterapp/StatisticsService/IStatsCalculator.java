   package filterapp.StatisticsService;

   import java.util.List;

   public interface  IStatsCalculator<I, O> {

      public O Calculate(List<I> list, boolean isFullStatistics);
   }