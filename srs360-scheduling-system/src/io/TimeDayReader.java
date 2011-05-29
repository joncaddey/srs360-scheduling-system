/*
 * Simple Random Sample
 * 
 * TCSS 360 Dr. Tenenberg
 * 
 * srs360-scheduling-system
 */

package io;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import courses.Day;
import courses.DaySlot;
import courses.Time;

/**
 * <p>
 * Reads information related to times and days from a file.
 * Blank lines and lines starting with "%" are ignored. The
 * first line of the file names what to call each day of the
 * week, separated by commas, starting with what to call
 * Monday. The next line is the morning/evening cutoff time,
 * represented as hour * 100 + minutes, where hour is in
 * military time. For the rest of the file, every line
 * should be a combination of days on which classes are
 * offered.
 * </p>
 * <p>
 * Instances are immutable.
 * </p>
 * <br>
 * <br>
 * <b>Invariants:</b>
 * <ul>
 * <li>TODO invariant1</li>
 * </ul>
 * 
 * @author Jonathan Caddey
 * @version May 28, 2011: Class created.
 */
public class TimeDayReader
{

  private Collection<DaySlot> my_day_slots;

  /**
   * Parses a String and returns the Days represented in
   * that String. The days should not be separated by any
   * characters.
   * 
   * 
   * <br>
   * <br>
   * <b>Preconditions:</b>
   * <ul>
   * <li>the_string != null</li>
   * <li>the_string represents days the same way days as are
   * represented in the file this parsed.</li>
   * </ul>
   * <b>Postconditions:</b>
   * <ul>
   * <li>TODO</li>
   * </ul>
   * 
   * @return the Days represented in the_string.
   * @throws IllegalArgumentException if the_string is null
   *           or contains elements that are not recognized
   *           as days.
   */
  public Collection<Day> parseDayString(
      final String the_string)
      throws IllegalArgumentException
  {
    // Try each day and see if the string starts with it at
    // the current index.
    // Read it as the _longest_ match.
    // Increment the index.
    return null;
  }

  public Collection<DaySlot> getDaySlots()
  {
    return my_day_slots;
  }

  /**
   * Accepts a String which is composed of the
   * representations of all days of the week, separated by
   * commas, starting with Monday. All days must be present
   * and in order. A mapping of the representations to their
   * appropriate Day object is returned.
   * 
   * 
   * <br>
   * <br>
   * <b>Preconditions:</b>
   * <ul>
   * <li>the_string is in the format as described.</li>
   * </ul>
   * <b>Postconditions:</b>
   * <ul>
   * <li>all 7 days are represented in the returned map</li>
   * </ul>
   * 
   * @param the_string lists all 7 days of the week,
   *          separated by commas, starting with Monday
   * @return a mapping of the representations of days to
   *         their Day objects.
   * @throws IllegalArgumentException if the_string is null,
   *           there are not 7 days, or a day is repeated.
   */
  protected Map<String, Day> readDays(
      final String the_string)
      throws IllegalArgumentException
  {
    if (the_string == null)
    {
      throw new IllegalArgumentException(
        "the_string must not be null");
    }
    final Day[] all_days = Day.values();
    final String[] days = the_string.split(",");
    if (days.length != all_days.length)
    {
      throw new IllegalArgumentException(
        "Must have only 7 days");
    }
    final Map<String, Day> day_map =
        new HashMap<String, Day>(all_days.length);
    for (int i = 0; i < days.length; i++)
    {
      day_map.put(days[i].trim(), all_days[i]);
    }
    if (day_map.keySet().size() < all_days.length)
    {
      throw new IllegalArgumentException(
        "Not enough days in the_string or"
            + " repeated representation");
    }
    return Collections.unmodifiableMap(day_map);
  }

  /**
   * Reads a given String as a Time. The time must be in the
   * form of an integer, where the integer = hours * 100 +
   * minutes, with hours in military time. Beginning and
   * ending whitespace is ignored.
   * 
   * <br>
   * <br>
   * <b>Preconditions:</b>
   * <ul>
   * <li>the_string is in the correct format</li>
   * <li>the_string != null</li>
   * </ul>
   * <b>Postconditions:</b>
   * <ul>
   * <li>TODO</li>
   * </ul>
   * 
   * @param the_string a String in the correct format.
   * @return the Time represented in the_string.
   * @throws NullPointerException if the_string is null.
   * @throws NumberFormatException if the_string cannot be
   *           converted to an integer.
   * @throws IllegalArgumentException if the integer is does
   *           not represent a Time.
   */
  public Time parseTimeString(final String the_string)
      throws IllegalArgumentException,
      NullPointerException, NumberFormatException
  {
    return new Time(Integer.parseInt(the_string.trim()));
  }

}
