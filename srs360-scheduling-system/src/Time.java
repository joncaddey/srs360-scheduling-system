/*
 * Simple Random Sample
 * 
 * TCSS 360 Dr. Tenenberg
 * 
 * srs360-scheduling-system
 */

/**
 * Times are immutable. TODO <br>
 * <br>
 * <b>Invariants:</b>
 * <ul>
 * <li>TODO invariant1</li>
 * </ul>
 * 
 * @author Jonathan Caddey (up to May 19)
 * @version May 19, 2011 (evening): getLaterTime removed;
 *          loosened restrictions on 2 arg constructor
 *          instead to accept negative values.
 * @version May 19, 2011: class created, original signatures
 *          added.
 */
public class Time implements Comparable<Time>
{

  /*
   * first constructor should accept positive or negative
   * values, whatever range, and do mod or whatever to it to
   * normalize it (0 <= hour <24, 0 <= min < 60). For
   * example, it should know what to do with Time(10, 5 -
   * 15). This makes it easy to see what time 30 minutes
   * earlier was, for example.
   */
  public Time(final int the_hours, final int the_minutes)
  {

  }

  /*
   * Second constructor should accept 1805 and know it's 18
   * hours, 5 minutes. Should know 1861 is not a valid time.
   */
  public Time(final int the_time)
  {

  }

  /*
   * the_minute_difference should be allowed to be any int;
   * do modulo to normalize.
   */
  public Time(final Time the_time,
              final int the_minute_difference)
  {

  }

  public int getHour()
  {
    return 0;
  }

  public int getMinute()
  {
    return 0;
  }
  
  /**
   * Returns whether the two times overlap.
   * TODO add Description
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

  }

  @Override
  public int compareTo(final Time the_arg0)
  {
    // TODO Auto-generated method stub
    return 0;
  }

}
