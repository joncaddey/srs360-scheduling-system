/*
 * Simple Random Sample
 * 
 * TCSS 360 Dr. Tenenberg
 * 
 * srs360-scheduling-system
 */

package courses;

import java.util.Collection;

/**
 * TODO <br>
 * <br>
 * <b>Invariants:</b>
 * <ul>
 * <li>The master course list</li>
 * <li>The day/night cutoff time</li>
 * <li>The available time slots</li>
 * </ul>
 * 
 * @author Gregory Cloutier
 * @version May 27, 2011: Class created.
 */
public class Catalogue
{
  /**
   * Master Course list from the catalogue.
   */
  private final Collection<Course> my_course_list;

  /**
   * All possible time slots.
   */
  private final Collection<TimeSlot> my_time_slots;

  /**
   * The day/night cutoff. Used to determine if classes are
   * during the day or evening.
   */
  private final Time my_day_night_cutoff;

  /**
   * Creates a Catalogue object.
   * 
   * @param the_course_list The list of courses within the
   *          schedule.
   * @param the_time_slots The available time slots.
   * @param a_day_night_cutoff The day/night cutoff time,
   *          where day classes end and evening classes
   *          begin.
   */
  public Catalogue(final Collection<Course> the_course_list,
                   final Collection<TimeSlot> the_time_slots,
                   final Time a_day_night_cutoff)
  {
    my_course_list = the_course_list;
    my_time_slots = the_time_slots;
    my_day_night_cutoff = a_day_night_cutoff;

  }

  /**
   * Checks to see if a course is within the catalogue or
   * not.
   * 
   * <br>
   * <br>
   * <b>Invariants:</b>
   * <ul>
   * <li>The course to be checked</li>
   * <li>The course list</li>
   * </ul>
   * <b>Preconditions:</b>
   * <ul>
   * <li>None</li>
   * </ul>
   * <b>Postconditions:</b>
   * <ul>
   * <li>TODO</li>
   * </ul>
   * 
   * @param the_course The course to be checked.
   * @return True if the course is in the catalogue, false
   *         when otherwise.
   */
  public boolean isInCatalogue(final Course the_course)
  {
    return my_course_list.contains(the_course);
  }

}
