/*
 * Simple Random Sample
 * 
 * TCSS 360 Dr. Tenenberg
 * 
 * srs360-scheduling-system
 */

import java.util.Collection;
import java.util.Map;

/**
 * Represents a Schedule within the program. Schedules are
 * immutable.<br>
 * <br>
 * <b>Invariants:</b> none<br>
 * 
 * @author Jonathan Caddey
 * @version May 23, 2011: Implemented hasSection(3 arg).
 * @version May 16, 2011: Changed file header.
 * @version May 13, 2011: Class created, hasSection,
 *          getSectionsTaughtBy, getSections signatures
 *          added.
 */
public class Schedule
{

  private final Map<Course, Collection<Section>>
          my_course_to_sections;

  /**
   * Creates a Schedule with the given Sections.
   * 
   * @param the_sections the Sections that are to be in the
   *          Schedule.
   * @throws IllegalArgumentException if the_sections is
   *           null or contains null.
   */
  public Schedule(final Collection<Section> the_sections)
    throws IllegalArgumentException
  {

  }

  /**
   * Determines whether there is a Section of the_course on
   * this Schedule. Details such as the days the Section
   * meets or who teaches the Section are ignored. <br>
   * <br>
   * <b>Preconditions:</b>
   * <ul>
   * <li>the_course is not null</li>
   * </ul>
   * <b>Postconditions:</b>
   * <ul>
   * <li>no Section of the_course is on this Schedule if
   * false is returned</li>
   * </ul>
   * 
   * @param the_course The Course being sought
   * @return whether the_course is on this Schedule
   */
  public boolean hasSection(final Course the_course)
  {
    return false;
  }

  /**
   * Determines whether this Schedule has a Section meeting
   * the given parameters. Returns true if there exists a
   * Section on the Schedule which is of the_course, AND
   * only meets on days included in the_days, AND meets at
   * one of the_times. Returns false otherwise.
   * 
   * <br>
   * <br>
   * <b>Preconditions:</b>
   * <ul>
   * <li>the_course != null</li>
   * <li>the_days is not null and does not contain null</li>
   * <li>the_times is not null and does not contain null
   * 
   * </li>
   * </ul>
   * <b>Postconditions:</b>
   * <ul>
   * <li>does not return null
   * 
   * </li>
   * </ul>
   * 
   * @param the_course the Course being looked for
   * @param the_days the days that the desired course may be
   *          held on
   * @param the_times the times at which the course is
   *          desired to be held
   * @return whether this Schedule has at least one Section
   *         meeting the given parameters.
   * @throws NullPointerException if the_course, the_days,
   *           or the_times are null.
   */
  public boolean hasSection(final Course the_course,
      final Collection<Day> the_days,
      final Collection<GeneralTime> the_times)
      throws NullPointerException
  {
    boolean has_section = false;
    final Collection<Section> sections =
        my_course_to_sections.get(the_course);
    if (sections != null)
    {
      for (Section section : sections)
      {
        if (the_days.containsAll(section.getDays()) &&
            the_times.contains(section.getGeneralTime()))
        {
          has_section = true;
          break;
        }

      }
    }
    return has_section;
  }

  /**
   * Returns all the Sections taught by the given
   * instructor. <br>
   * <br>
   * <b>Preconditions:</b>
   * <ul>
   * <li>the_instructor is not null</li>
   * <li>the_instructor is an instructor</li>
   * </ul>
   * <b>Postconditions:</b>
   * <ul>
   * <li>there is no Section in the Schedule which is taught
   * by the_instructor and also not returned</li>
   * </ul>
   * 
   * @param the_instructor a User who is an instructor.
   * @return all the Sections taught by the_instructor.
   */
  public Collection<Section> getSectionsTaughtBy(
      final User the_instructor)
  {
    return null;
  }

  /**
   * Returns a Collection of all Sections on the Schedule.
   * 
   * <br>
   * <br>
   * <b>Preconditions:</b> none <br>
   * <b>Postconditions:</b>
   * <ul>
   * <li>The return value is not null</li>
   * </ul>
   * 
   * @return the Sections on the Schedule.
   */
  public Collection<Section> getSections()
  {
    return null;

  }
}
