/*
 * Simple Random Sample
 * 
 * srs360-scheduling-system
 */

package users;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import courses.Course;
import courses.Schedule;
import courses.Section;

/**
 * Provides the advisor's preferences of courses for the
 * schedule. Multiple sections of a course are indicated by
 * multiple requests for a course. <br>
 * <b>Invariants:</b>
 * <ul>
 * <li>none</li>
 * </ul>
 * 
 * @author David
 * @version May 27, 2011: Class created.
 */
public class AdvisorPreferences
{
  private final Collection<Course> my_pref_courses;

  /**
   * Constructs an AdvisorPreferences.
   * 
   * @param the_courses the courses the Advisor recommends.
   */
  public AdvisorPreferences(final Collection<Course> the_courses)
  {
    my_pref_courses = new ArrayList<Course>(the_courses);
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
   * @return the Courses the advisor would like to see on
   *         the Schedule.
   */
  public Collection<Course> getPreferredCourses()
  {
    return Collections
        .unmodifiableCollection(my_pref_courses);
  }

  /**
   * Returns a collection of Courses the Advisor wants on
   * the Schedule that it does not presently have. <br>
   * <b>Preconditions:</b>
   * <ul>
   * <li>the schedule is not null</li>
   * </ul>
   * <b>Postconditions:</b>
   * <ul>
   * <li>none</li>
   * </ul>
   * 
   * @param the_schedule The schedule of courses
   * @return A collection of missing sections
   * @throws IllegalArgumentException if the schedule ==
   *           null
   */
  public Collection<Course> getAdvisorFeedback(
      final Schedule the_schedule)
      throws IllegalArgumentException
  {
    if (the_schedule == null)
    {
      throw new IllegalArgumentException();
    }

    Collection<Section> all_sections =
        the_schedule.getSections();

    for (Section each_section : all_sections)
    {
      if (my_pref_courses
          .contains(each_section.getCourse()))
      {
        my_pref_courses.remove(each_section.getCourse());
      }
    }
    // the courses remaining after all the ones on the
    // schedule have been removed
    return my_pref_courses;
  }

}
