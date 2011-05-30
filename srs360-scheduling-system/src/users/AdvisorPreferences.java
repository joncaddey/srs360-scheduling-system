/*
 * Simple Random Sample
 * 
 * srs360-scheduling-system
 */
package users;

import java.util.ArrayList;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import courses.Course;
import courses.Schedule;
import courses.Section;

/**
 * Provides the advisor's preferences of courses for the 
 * schedule. Multiple sections of a course are indicated
 * by multiple requests for a course.
 * <br>
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
   */
  public AdvisorPreferences(Collection<Course> the_courses)
  {
    my_pref_courses = the_courses;
  } 

  /**
   * Adds a section to the advisor's section list.
   * <br>
   * <b>Preconditions:</b>
   * <ul>
   * <li>The added section is not null</li>
   * </ul>
   * <b>Postconditions:</b>
   * <ul>
   * <li>the section is added to the list</li>
   * </ul>
   * @param the_section The section to be added
   * @throws IllegalArgumentException if the section == null
   */
  public void addCourse(final Course the_course)
                             throws IllegalArgumentException
  {
    if (the_course == null)
    {
      throw new IllegalArgumentException();
    }
    my_pref_courses.add(the_course);
  }
  
  /**
   * Removes a section from the advisor's section list.
   * <br>
   * <b>Preconditions:</b>
   * <ul>
   * <li>The removed section is not null</li>
   * </ul>
   * <b>Postconditions:</b>
   * <ul>
   * <li>the section is removed from the list</li>
   * </ul>
   * @param the_section The section to be removed
   * @throws IllegalArgumentException if the section == null
   */
  public void removeCourse(final Section the_course)
                             throws IllegalArgumentException
  {
    if (the_course == null)
    {
      throw new IllegalArgumentException();
    }
    my_pref_courses.remove(the_course);
  }

  public Collection<Course> getPreferredCourses()
  {
    return my_pref_courses;
  }

  /**
   * Returns a collection of sections the advisor wants on 
   * the schedule that it does not presently have.
   * <br>
   * <b>Preconditions:</b>
   * <ul>
   * <li>the schedule is not null</li>
   * </ul>
   * <b>Postconditions:</b>
   * <ul>
   * <li>none</li>
   * </ul>
   * @param the_schedule The schedule of courses
   * @return A collection of missing sections
   * @throws IllegalArgumentException if the schedule == null
   */
  public Collection<Section> getAdvisorFeedback
                               (final Schedule the_schedule)
                             throws IllegalArgumentException
  {
    if (the_schedule == null)
    {
      throw new IllegalArgumentException();
    } 
      final List<Course> missing_sections =
                                   new ArrayList<Section>();
      for (Section each_section : my_pref_sections)
      {
        if (!the_schedule.getSections().contains(each_section))
        {
          missing_sections.add(each_section);
        }
      }
      return missing_sections;
    }

}
