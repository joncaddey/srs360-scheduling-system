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

  public boolean hasSection(final Course the_course)
  {
    return false;
  }

  /**
   * Determines whether the Schedule has a Section meeting
   * the given parameters.  Returns true if there exists a Section on the Schedule
   * which is of the_course, AND meets at one of the given GeneralTimes, AND
   * only meets on days specified in the_days.  Returns false otherwise.<br>
   * <br>
   * <b>Preconditions:</b> none. </br>
   * <b>Postconditions:</b>
   * <ul>
   * <li>TODO</li>
   * <li>post2</li>
   * </ul>
   * 
   * @param the_course the Course being looked for
   * @param the_times the times the course is desired
   * @param the_days the days that the desired course may be on
   * @return
   */
  public boolean hasSection(final Course the_course,
      final Collection<GeneralTime> the_times,
      final Collection<Day> the_days)
  {
    return false;
  }

  public Collection<Section> getSectionsTaughtBy(
      final User the_instructor)
  {
    return null;
  }
}
