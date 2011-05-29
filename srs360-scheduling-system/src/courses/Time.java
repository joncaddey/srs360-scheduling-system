/*
 * Simple Random Sample
 * 
 * TCSS 360 Dr. Tenenberg
 * 
 * srs360-scheduling-system
 */

package courses;

/**
 * The time of day on a 24 hour clock. There is no
 * representation of Days. Times are immutable.<br>
 * <br>
 * <b>Invariants:</b>
 * <ul>
 * <li>0 <= getHours() < 24</li>
 * <li>0 <= getMinutes() < 60</li>
 * </ul>
 * 
 * @author Jonathan Caddey (up to May 29)
 * @version May 29, 2011: class and constructor
 *          documentation, constructors implementation.
 * @version May 19, 2011 (evening): getLaterTime removed;
 *          loosened restrictions on 2 arg constructor
 *          instead to accept negative values.
 * @version May 19, 2011: class created, original signatures
 *          added.
 */
public class Time implements Comparable<Time>
{

  private static final int HOURS_IN_DAY = 24;
  private static final int MINUTES_IN_HOUR = 60;

  /**
   * The total minutes, counted from 0.
   */
  private final int my_minutes;

  /**
   * Constructs a Time given the_hours and the_minutes.
   * Neither argument should be negative, but the time will
   * be normalized if the_hours > 23 or the_minutes > 59.
   * For example, passing 1:61 will be interpreted as 2:01.
   * 
   * @param the_hours the hour of the day.
   * @param the_minutes the minutes of the day.
   * @throws IllegalArgumentException if the_hours < 0 or
   *           the_minutes < 0.
   */
  public Time(final int the_hours, final int the_minutes)
    throws IllegalArgumentException
  {
    if (the_hours < 0 || the_minutes < 0)
    {
      throw new IllegalArgumentException(
        "the_hours and the_minutes must be positive.");
    }
    my_minutes =
        (the_hours * MINUTES_IN_HOUR + the_minutes) %
            (HOURS_IN_DAY * MINUTES_IN_HOUR);

  }

  /*
   * Second constructor should accept 1805 and know it's 18
   * hours, 5 minutes. Should know 1861 is not a valid time.
   */
  public Time(final int the_time)
  {
    this(the_time / 100, the_time % 100);

  }

  /*
   * the_minute_difference should be allowed to be any int;
   * do modulo to normalize.
   */
  public Time(final Time the_time,
              final int the_minute_difference)
  {
    this(0, the_time.my_minutes + the_minute_difference);

  }

  public int getHour()
  {
    return my_minutes / MINUTES_IN_HOUR;
  }

  public int getMinute()
  {
    return my_minutes % MINUTES_IN_HOUR;
  }

  /**
   * Returns whether the two times overlap. TODO add
   * Description
   * 
   * <br>
   * <br>
   * <b>Preconditions:</b>
   * <ul>
   * <li>TODO</li>
   * </ul>
   * <b>Postconditions:</b>
   * <ul>
   * <li>TODO</li>
   * </ul>
   * 
   * @param the_start_1
   * @param the_end_1
   * @param the_start_2
   * @param the_end_2
   * @param the_difference
   * @return
   */
  public static boolean overlap(final Time the_start_1,
      final Time the_end_1, final Time the_start_2,
      final Time the_end_2, final int the_difference)
  {
    final int s1 = the_start_1.my_minutes;
    final int e1 = the_end_1.my_minutes + the_difference;
    final int s2 = the_start_2.my_minutes;
    final int e2 = the_end_2.my_minutes + the_difference;
    return (s1 < e2 && e2 < e1) || (s2 < e1 && e1 < e2);
  }

  @Override
  public int compareTo(final Time the_arg0)
  {
    // TODO Auto-generated method stub
    return 0;
  }

}
