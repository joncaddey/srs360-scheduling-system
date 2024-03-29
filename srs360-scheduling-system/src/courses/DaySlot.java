/*
 * Simple Random Sample
 * 
 * srs360-scheduling-system
 */

package courses;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import users.StudentFeedbackSummary;

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
 * @author Greg Cloutier (added JavaDoc)
 * @version May 19, 2011: Class created, original signatures
 *          added.
 * @version May 27, 2011: Completed construction, getter.
 * @version June 1, 2011: Added JavaDoc.
 */
public class DaySlot
{
  /**
   * Collection of Day objects.
   */
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
    my_days = new ArrayList<Day>(the_days);
  }

  /**
   * <b>Preconditions:</b>
   * <ul>
   * <li>none.</li>
   * </ul>
   * <b>Postconditions:</b>
   * <ul>
   * <li>does not return null.</li>
   * </ul>
   * 
   * @return the days this DaySlot is composed of.
   */
  public Collection<Day> getDays()
  {
    return Collections.unmodifiableCollection(my_days);
  }

  /**
   * Returns the collection of days.
   * 
   * @return The collection of days in String representation
   */
  public String toString()
  {
    return my_days.toString();
  }

  /**
   * Determines whether this DaySlot is the same as
   * the_other object.
   * 
   * @param the_other The object to be compared.
   * @return True if the_other object is the same as this
   *         DaySlot, false if otherwise
   */
  public boolean equals(final Object the_other)
  {
    boolean to_return = the_other == this;
    if (!to_return && the_other != null &&
        the_other.getClass() == getClass())
    {
      final DaySlot ds = (DaySlot) the_other;
      to_return =
          ds.getDays().containsAll(this.getDays()) &&
              getDays().containsAll(ds.getDays());
    }

    return to_return;
  }

  /**
   * @return The hashcode of the DaySlot object.
   */
  public int hashCode()
  {
    return 42;
  }

}
