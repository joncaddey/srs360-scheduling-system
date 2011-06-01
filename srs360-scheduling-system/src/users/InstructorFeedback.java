/*
 * Simple Random Sample
 * 
 * srs360-scheduling-system
 */

package users;

import java.util.Collection;

import courses.Course;
import courses.Day;
import courses.GeneralTime;
import courses.Section;

/**
 * Contains which Sections the instructor is assigned to but
 * the instructor does not want to teach, which Sections the
 * instructor cannot teach because the Sections overlap, and
 * whether the instructor is assigned more credit hours than
 * he or she is willing to work.<br>
 * <br>
 * <b>Invariants:</b>
 * <ul>
 * <li>TODO invariant1</li>
 * </ul>
 * 
 * @author Gregory Cloutier
 * @author Jonathan Caddey--added constructor and
 *         documentation.
 * @version May 27, 2011: Class created.
 */
public class InstructorFeedback
{
  private Collection<Course> my_unwanted_courses;
  private Collection<Course> my_time_conflicted_courses;
  private int my_assigned_credit_hours;

  public InstructorFeedback(final Collection<Course> the_unwanted_courses,
                            final Collection<Course> the_time_conflicted_courses,
                            int the_assigned_credit_hours)
  {
    my_unwanted_courses = the_unwanted_courses;
    my_time_conflicted_courses =
        the_time_conflicted_courses;
    my_assigned_credit_hours = the_assigned_credit_hours;
  }

  public InstructorFeedback(User the_instructor,
                            Collection<Section> the_unwanted_sections)
  {
    // TODO Auto-generated constructor stub
  }

  public Collection<Course> getMy_unwanted_courses()
  {
    return my_unwanted_courses;
  }

  public Collection<Course> getMy_time_conflicted_courses()
  {
    return my_time_conflicted_courses;
  }

  public int getMy_assigned_credit_hours()
  {
    return my_assigned_credit_hours;
  }

}
