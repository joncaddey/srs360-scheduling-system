/*
 * Simple Random Sample
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
 * @author Jonathan Caddey
 * @version May 30, 2011: compareTo implemented.
 *          Documentation added.
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
   * What the hours is multiplied by when having time in its
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

  /**
   * @return the hour.
   */
  public int getHour()
  {
    return my_minutes / MINUTES_IN_HOUR;
  }

  /**
   * @return the minutes.
   */
  public int getMinute()
  {
    return my_minutes % MINUTES_IN_HOUR;
  }

  /**
   * Returns whether two durations overlap. The durations
   * are the times between the_start and the_end. The start
   * time must be before the corresponding end time--i.e. no
   * duration may start in the evening and end in the
   * morning. The durations overlap if either duration ends
   * within the_difference minutes of the other duration
   * starting.
   * 
   * <br>
   * <br>
   * <b>Preconditions:</b>
   * <ul>
   * <li>the_start_1.compareTo(the_end_1) < 0</li>
   * <li>the_start_2.compareTo(the_end_2) < 0</li>
   * </ul>
   * <b>Postconditions:</b>
   * <ul>
   * <li>none</li>
   * </ul>
   * 
   * @param the_start_1 the start of the first duration.
   * @param the_end_1 the end of the first duration.
   * @param the_start_2 the start of the second duration.
   * @param the_end_2 the end of the second duration.
   * @param the_difference the necessary time between the
   *          two durations.
   * @return whether the two durations overlap.
   * @throws IllegalArgumentException if either start is at
   *           a later time than their corresponding ends,
   *           or the_difference < 0.
   * @throws NullPointerException if any argument is null.
   */
  public static boolean overlap(final Time the_start_1,
      final Time the_end_1, final Time the_start_2,
      final Time the_end_2, final int the_difference)
      throws IllegalArgumentException, NullPointerException
  {
    if (the_difference < 0)
    {
      throw new IllegalArgumentException(
        "the_difference must be positive");
    }
    final int s1 = the_start_1.my_minutes;
    final int e1 = the_end_1.my_minutes + the_difference;
    final int s2 = the_start_2.my_minutes;
    final int e2 = the_end_2.my_minutes + the_difference;
    return (s1 < e2 && e2 < e1) || (s2 < e1 && e1 < e2);
  }

  /**
   * Compares based on getHours() * 60 + getMinutes().
   * 
   * @param the_other the Time to compare to.
   */
  @Override
  public int compareTo(final Time the_other)
  {
    return my_minutes - the_other.my_minutes;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public int hashCode()
  {
    return my_minutes;
  }

  /**
   * @return whether the_other is the same time as this.
   * @param the_other a Time to compare to.
   */
  @Override
  public boolean equals(final Object the_other)
  {
    boolean to_return = false;
    if (the_other != null &&
        the_other.getClass() == getClass())
    {
      final Time other_time = (Time) the_other;
      to_return = other_time.my_minutes == my_minutes;
    }
    return to_return;
  }

}
