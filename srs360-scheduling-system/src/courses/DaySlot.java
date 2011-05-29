/*
 * Simple Random Sample
 * 
 * srs360-scheduling-system
 */

package courses;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * DaySlot is a combination of days on which a Section may
 * be offered. DaySlots are immutable.<br>
 * <br>
 * <b>Invariants:</b>
 * <ul>
 * <li>getDays() != null</li>
 * </ul>
 * 
 * @author Jonathan Caddey (up until May 19)
 * @author David Liddington
 * @version May 19, 2011: Class created, original signatures
 *          added.
 * @version May 27, 2011: Completed construction, getter.
 */
public class DaySlot
{
  private final Collection<Day> my_days;

  /**
   * Creates a DaySlot of particular days.
   * 
   * @param the_days The Days comprising the DaySlot
   * @throws IllegalArgumentException if the_days == null
   */
  public DaySlot(final Collection<Day> the_days)
    throws IllegalArgumentException
  {
    if (the_days == null)
    {
      throw new IllegalArgumentException(
        "the_days must not be null");
    }
    my_days = new ArrayList<Day>();
    for (Day day : the_days)
    {
      my_days.add(day);
    }
  }

  public Collection<Day> getDays()
  {
    return Collections.unmodifiableCollection(my_days);
  }
}
