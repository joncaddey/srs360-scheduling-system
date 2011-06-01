/*
 * Simple Random Sample
 * 
 * srs360-scheduling-system
 */

package io;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

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
 * Many methods require that read() be invoked before them
 * and will throw an IllegalStateException otherwise. The
 * idea is to construct an instance, invoke the read method,
 * and then invoke other methods. The read method is not
 * allowed to be invoked a second time. This effectively
 * makes an instance immutable once input is read.
 * </p>
 * <b>Invariants:</b>
 * <ul>
 * <li>none</li>
 * </ul>
 * 
 * @author Jonathan Caddey
 * @version May 28, 2011: Class created.
 */
public class TimeSlotReader
{

  /**
   * The message for when methods are called at
   * inappropriate times.
   */
  private static final String READ_INPUT_FIRST_MSG =
      "Must read input before invoking this method.";
  /**
   * Whether information has successfully been read from a
   * file and is ready to be retrieved.
   */
  private boolean my_successfully_read;

  /**
   * All the DaySlots from the last read invocation.
   */
  private Collection<DaySlot> my_day_slots;

  /**
   * The morning/evening cutoff time.
   */
  private Time my_cutoff_time;

  /**
   * A mapping from the String representations of days to
   * their Days.
   */
  private Map<String, Day> my_day_map;

  /**
   * Parses a String and returns the Days represented in
   * that String. The days should not be separated by any
   * characters.
   * 
   * <br>
   * <br>
   * <b>Preconditions:</b>
   * <ul>
   * <li>the instance has already read in input</li>
   * <li>the_string != null</li>
   * <li>the_string contains days as encountered from the
   * read() invocation.</li>
   * </ul>
   * <b>Postconditions:</b>
   * <ul>
   * <li>none</li>
   * </ul>
   * 
   * @param the_string a String with days represented as
   *          described.
   * @return the Days contained in the_string.
   * @throws IllegalArgumentException if the_string contains
   *           an unrecognized day.
   * @throws NullPointerException if the_string is null.
   * @throws IllegalStateException if read has not been
   *           invoked.
   */
  public Collection<Day> parseDayString(
      final String the_string)
      throws IllegalArgumentException,
      NullPointerException, IllegalStateException
  {
    if (!my_successfully_read)
    {
      throw new IllegalStateException(READ_INPUT_FIRST_MSG);
    }
    return parseDayString(the_string, my_day_map);
  }

  /**
   * Parses a String and returns the Days represented in
   * that String. The days should not be separated by any
   * characters. The names of the days should be contained
   * in the_day_map.
   * 
   * <br>
   * <br>
   * <b>Preconditions:</b>
   * <ul>
   * <li>the_string != null</li>
   * <li>the_day_map has mappings of names to all 7 Days
   * 
   * 
   * </li>
   * </ul>
   * <b>Postconditions:</b>
   * <ul>
   * <li>none</li>
   * </ul>
   * 
   * @param the_string a String with days represented as
   *          described.
   * @param the_day_map a mapping of String names to all 7
   *          Days.
   * @return the Days contained in the_string.
   * @throws IllegalArgumentException if the_string contains
   *           an unrecognized day.
   * @throws NullPointerException if the_string is null or
   *           the_day_map is null.
   */
  protected Collection<Day> parseDayString(
      final String the_string,
      final Map<String, Day> the_day_map)
      throws IllegalArgumentException, NullPointerException
  {
    Collection<Day> days = new ArrayList<Day>();
    int index = 0;
    while (index < the_string.length())
    {
      String longest = "";
      // see if remaining string starts with any known day
      for (String day_string : the_day_map.keySet())
      {
        if (the_string.startsWith(day_string, index) &&
            day_string.length() > longest.length())
        {
          longest = day_string;
        }
      }

      if (longest.length() == 0)
      {
        throw new IllegalArgumentException(
          "\"" + the_string.substring(index) +
              "\" is not the start of a known day.");
      }
      else
      {
        index += longest.length();
        days.add(the_day_map.get(longest));
      }
    }
    return days;
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
   * <li>none</li>
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
   * Reads the input, as described in the class
   * documentation. <br>
   * <br>
   * <b>Preconditions:</b>
   * <ul>
   * <li>The input to the_scanner must fit the description
   * provided in the class documentation</li>
   * </ul>
   * <b>Postconditions:</b>
   * <ul>
   * <li>information is correctly gathered from the input.
   * 
   * 
   * </li>
   * </ul>
   * 
   * @param the_scanner can read correctly formatted input.
   * @throws IllegalArgumentException if the_scanner is
   *           null.
   * @throws InputFormatException if the input of
   *           the_scanner does not adhere to the
   *           description provided in class documentation.
   * @throws IllegalStateException if input has already been
   *           read.
   */
  public void read(final Scanner the_scanner)
      throws IllegalArgumentException,
      InputFormatException, IllegalStateException
  {
    if (my_successfully_read)
    {
      throw new IllegalStateException(
        "Input may be read only once");
    }
    // TODO if something goes wrong..?
    final LineCommentScanner scanner =
        new LineCommentScanner(the_scanner);
    my_day_map = readDays(scanner.getNonComment());
    my_cutoff_time =
        parseTimeString(scanner.getNonComment());
    String line = scanner.getNonComment();
    my_day_slots = new ArrayList<DaySlot>();
    while (line != null)
    {
      my_day_slots.add(new DaySlot(parseDayString(line,
          my_day_map)));
      line = scanner.getNonComment();
    }
    my_successfully_read = true;
  }

  /**
   * <b>Preconditions:</b>
   * <ul>
   * <li>input has already been read.</li>
   * </ul>
   * <b>Postconditions:</b>
   * <ul>
   * <li>does not return null</li>
   * </ul>
   * 
   * @return an unmodifiable view of all possible Day
   *         combinations when Sections can be scheduled.
   * @throws IllegalStateException if invoked before input
   *           is read.
   */
  public Collection<DaySlot> getDaySlots()
      throws IllegalStateException
  {
    if (!my_successfully_read)
    {
      throw new IllegalStateException(READ_INPUT_FIRST_MSG);
    }
    return Collections.unmodifiableCollection(my_day_slots);
  }

  /**
   * <b>Preconditions:</b>
   * <ul>
   * <li>input has already been read.</li>
   * </ul>
   * <b>Postconditions:</b>
   * <ul>
   * <li>does not return null</li>
   * </ul>
   * 
   * @return the morning/evening cutoff time.
   * @throws IllegalStateException if invoked before input
   *           is read.
   */
  public Time getCutoffTime() throws IllegalStateException
  {
    if (!my_successfully_read)
    {
      throw new IllegalStateException(READ_INPUT_FIRST_MSG);
    }
    return my_cutoff_time;
  }
}
