import java.util.ArrayList;
import java.util.List;

public enum Day
{
  MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY,
  SUNDAY;
  
  public static List<Day> getAllDays()
  {
    List<Day> daysList = new ArrayList<Day>();
    daysList.add(Day.MONDAY);
    daysList.add(Day.TUESDAY);
    daysList.add(Day.WEDNESDAY);
    daysList.add(Day.THURSDAY);
    daysList.add(Day.FRIDAY);
    daysList.add(Day.SATURDAY);
    daysList.add(Day.SUNDAY);
    
    return daysList;
  }

}
