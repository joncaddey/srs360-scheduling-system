/*
 * Simple Random Sample
 * 
 * srs360-scheduling-system
 */

package courses;
import java.util.ArrayList;
import java.util.List;

/**
 * Provides the days of the week individually
 * or as a list of all days.
 * <br>
 * <b>Invariants:</b>
 * <ul>
 * <li>none</li>
 * </ul>
 * 
 * @author David
 * @author Greg (added JavaDoc)
 * @version May 28, 2011: Class created.
 * @version June 1, 2011: added more JavaDoc.
 */
public enum Day
{
  /*
   * Days of the week.
   */
  /**
   * Monday.
   */
  MONDAY,
  /**
   * Tuesday.
   */
  TUESDAY,
  /**
   * Wednesday.
   */
  WEDNESDAY,
  /**
   * Thursday.
   */
  THURSDAY,
  /**
   * Friday.
   */
  FRIDAY,
  /**
   * Saturday.
   */
  SATURDAY,
  /**
   * Sunday.
   */
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
    final List<Day> daysList = new ArrayList<Day>();
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
