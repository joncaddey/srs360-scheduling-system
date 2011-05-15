/**
 * Simple Random Sample
 * 
 * TCSS 360 Dr. Tenenberg
 * 
 * srs360-scheduling-system
 */

import java.util.Collection;

/**
 * Represents a Schedule within the program. <br>
 * <br>
 * <b>Invariants:</b>
 * <ul>
 * <li>invariant1</li>
 * </ul>
 * 
 * @author Jonathan Caddey
 * @version May 13, 2011
 */
public class Schedule
{
  public Schedule(final Collection<Section> the_sections)
    throws IllegalArgumentException
  {

  }

  /**
   * <br>
   * <br>
   * <b>Preconditions:</b>
   * <ul>
   * <li>pre1</li>
   * <li>pre2</li>
   * </ul>
   * <b>Postconditions:</b>
   * <ul>
   * <li>post1</li>
   * <li>post2</li>
   * </ul>
   * 
   * @param the_courses The Courses that should be on the
   *          schedule.
   * @param the_time_preference The times the Courses should
   *          be offered.
   * @return which Courses from the_courses are not on the
   *         Schedule at the given time_preference.
   */
  public Collection<Course> getMissingCourses(
      final Collection<Course> the_courses,
      final TimePreference the_time_preference)
  {

    return null;

  }
}
