/*
 * Simple Random Sample
 * 
 * srs360-scheduling-system
 */

package courses;
import java.util.ArrayList;
import java.util.List;

/**
 * An enum that provides the days of the week individually
 * or as a list of all days.
 * <br>
 * <b>Invariants:</b>
 * <ul>
 * <li>none</li>
 * </ul>
 * 
 * @author David
 * @version May 28, 2011: Class created.
 */
public enum Day
{
  MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY,
  SUNDAY;
  
  /**
   * Provides a list of all days of the week.
   * <br>
   * <b>Preconditions:</b>
   * <ul>
   * <li>none</li>
   * </ul>
   * <b>Postconditions:</b>
   * <ul>
   * <li>none</li>
   * </ul>
   * @return A list of the days of the week
   */
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
