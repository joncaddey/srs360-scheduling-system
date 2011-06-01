/*
 * Simple Random Sample
 * 
 * srs360-scheduling-system
 */

package courses;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Contains information for all Schedules in general.
 * Instances are immutable.<br>
 * <br>
 * <b>Invariants:</b>
 * <ul>
 * <li>The master course list</li>
 * <li>The day/night cutoff time</li>
 * <li>The available time slots</li>
 * </ul>
 * 
 * @author Gregory Cloutier
 * @author Jonathan Caddey
 * @version May 30, 2011: Jon made small modifications,
 *          added class doc, added getGeneralTime
 * @version May 27, 2011: Class created.
 */
public class Catalogue
{
  /**
   * Master Course list from the catalogue.
   */
  private final Map<String, Course> my_course_map;

  /**
   * All possible combinations of days during which sections
   * may be offered.
   */
  private final Collection<DaySlot> my_day_slots;

  /**
   * The day/night cutoff. Used to determine if classes are
   * during the day or evening.
   */
  private final Time my_day_night_cutoff;

  /**
   * Creates a Catalogue object.
   * 
   * @param the_course_map A mapping of course IDs to
   *          Courses for all Courses offered.
   * @param the_day_slots The available combinations of days
   *          Sections may be offered.
   * @param a_day_night_cutoff The day/night cutoff time,
   *          where day classes end and evening classes
   *          begin.
   * @author Gregory Cloitier
   * @author Jonathan Caddey (modified signature)
   */
  public Catalogue(final Map<String, Course> the_course_map,
                   final Collection<DaySlot> the_day_slots,
                   final Time a_day_night_cutoff)
  {
    my_course_map =
        new HashMap<String, Course>(the_course_map);
    my_day_slots = new ArrayList<DaySlot>(the_day_slots);
    my_day_night_cutoff = a_day_night_cutoff;
  }

  /**
   * Finds a Course given a course ID, or returns null if it
   * is not found.
   * 
   * <b>Preconditions:</b>
   * <ul>
   * <li>the_course != null</li>
   * </ul>
   * <b>Postconditions:</b>
   * <ul>
   * <li>none</li>
   * </ul>
   * 
   * @author Jonathan Caddey
   * @param the_ID the ID of the Course sought.
   * @return the Course with the given ID, or null if no
   *         course is found. when otherwise.
   * @throws IllegalArgumentException if the_ID is null.
   */
  public Course getCourse(final String the_ID)
    throws IllegalArgumentException
  {
    if (the_ID == null)
    {
      throw new IllegalArgumentException(
        "Cannot look for null ID");
    }
    return my_course_map.get(the_ID);
  }

  /**
   * <b>Preconditions:</b>
   * <ul>
   * <li>none.</li>
   * </ul>
   * <b>Postconditions:</b>
   * <ul>
   * <li>does not return null</li>
   * </ul>
   * 
   * @return every possible combination of Days a Section is
   *         allowed to be held on.
   */
  public Collection<DaySlot> getDaySlots()
  {
    return Collections.unmodifiableCollection(my_day_slots);
  }

  /**
   * Determines which general time of day the given time is
   * in.
   * 
   * <br>
   * <br>
   * <b>Preconditions:</b>
   * <ul>
   * <li>the_time != null</li>
   * </ul>
   * <b>Postconditions:</b>
   * <ul>
   * <li>none</li>
   * </ul>
   * 
   * @param the_time the time in question.
   * @return what general time of day the given time belongs
   *         to.
   * @throws NullPointerException if the_time is null.
   */
  public GeneralTime getGeneralTime(final Time the_time)
    throws NullPointerException
  {
    GeneralTime time;
    if (the_time.compareTo(my_day_night_cutoff) < 0)
    {
      time = GeneralTime.MORNING;
    }
    else
    {
      time = GeneralTime.EVENING;
    }
    return time;
  }

}
