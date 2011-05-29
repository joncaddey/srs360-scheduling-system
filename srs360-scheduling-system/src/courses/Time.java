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
   * What the hours is multiplied when having time in its
   * integer form (example 1805 for 18:05).
   */
  private static final int BASE_100 = 100;

  /**
   * The total minutes, counted from 0.
   */
  private final int my_minutes;

  /**
   * Constructs a Time given the_hours and the_minutes.
   * Neither argument should be negative, but the time will
   * be normalized if the_hours > 23 or the_minutes > 59.
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

  /**
   * Accepts the integer representation of the time, where
   * the_time = hours * 100 + minutes. For example, to
   * express 18:05, the_time should be 1805. No attempt will
   * be made to normalize times where the hours is greater
   * than 23 or the minutes is greater than 59.
   * 
   * @param the_time the integer form of the desired time.
   * @throws IllegalArgumentException if the_time < 0,
   *           the_time / 100 > 23, or the_time % 100 > 59.
   */
  public Time(final int the_time)
    throws IllegalArgumentException
  {
    this(the_time / BASE_100, the_time % BASE_100);
    if (the_time < 0)
    {
      throw new IllegalArgumentException(
        "the_time must be positive.");
    }
    if (the_time / BASE_100 >= HOURS_IN_DAY)
    {
      throw new IllegalArgumentException(
        "the_time / 100 must be less than 24");
    }
    if (the_time % BASE_100 >= MINUTES_IN_HOUR)
    {
      throw new IllegalArgumentException(
        "the_time % 100 must be less than 60");
    }
  }

  /**
   * Allows a new Time to be created a given number of
   * minutes after a given Time. the_time_elapsed can be any
   * non-negative integer.
   * 
   * @param the_time a prior Time.
   * @param the_time_elapsed the number of minutes later
   *          this Time is.
   * @throws IllegalArgumentException if the_time_elapsed is
   *           less than 0.
   */
  public Time(final Time the_time,
              final int the_time_elapsed)
    throws IllegalArgumentException
  {
    this(0, the_time.my_minutes + the_time_elapsed);
    if (the_time_elapsed < 0)
    {
      throw new IllegalArgumentException(
        "the_time_elapsed must be non-negative.");
    }

  }

  public int getHour()
  {
    return my_minutes / 60;
  }

  public int getMinute()
  {
    return my_minutes % 60;
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
   * @throws IllegalArgumentException if the_difference < 0.
   */
  public static boolean overlap(final Time the_start_1,
      final Time the_end_1, final Time the_start_2,
      final Time the_end_2, final int the_difference)
      throws IllegalArgumentException
  {
    if (the_difference < 0)
    {
      throw new IllegalArgumentException(
        "the_difference must e positive.");
    }
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
