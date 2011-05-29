/*
 * Simple Random Sample
 * 
 * srs360-scheduling-system
 */

package courses;

import java.util.ArrayList;
import java.util.List;

/**
 * A general division of the day. <br>
 * 
 * @author Jonathan Caddey
 * @author David Liddington(removed EITHER, changed name)
 * @version May 13, 2011
 */
public enum GeneralTime
{
  /**
   * Prefers attending in the morning.
   */
  MORNING,

  /**
   * Prefers attending in the evening.
   */
  EVENING;

  /**
   * Provides a list of all times. <br>
   * <b>Preconditions:</b>
   * <ul>
   * <li>none</li>
   * </ul>
   * <b>Postconditions:</b>
   * <ul>
   * <li>none</li>
   * </ul>
   * 
   * @return A list of all times
   */
  public static List<GeneralTime> getAllTimes()
  {
    final List<GeneralTime> times =
        new ArrayList<GeneralTime>();
    times.add(GeneralTime.MORNING);
    times.add(GeneralTime.EVENING);

    return times;
  }

}
