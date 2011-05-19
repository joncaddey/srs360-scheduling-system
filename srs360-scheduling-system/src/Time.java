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
 * @version May 19, 2011: class created, original signatures
 *          added.
 */
public class Time implements Comparable<Time>
{
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

  public int getHour()
  {
    return 0;
  }

  public int getMinute()
  {
    return 0;
  }

  public static Time getLaterTime(final Time the_time, final int the_added_minutes)
  {
    return null;
  }

  @Override
  public int compareTo(final Time the_arg0)
  {
    // TODO Auto-generated method stub
    return 0;
  }

}
