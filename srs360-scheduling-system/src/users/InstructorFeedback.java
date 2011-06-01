/*
 * Simple Random Sample
 *
 * TCSS 360 Dr. Tenenberg
 *
 * srs360-scheduling-system
 */
package users;

import java.util.Collection;

import courses.Course;
import courses.Day;
import courses.GeneralTime;

/**
 * TODO
 * <br><br><b>Invariants:</b>
 * <ul><li>TODO invariant1</li>
 * </ul>
 * 
 * @author Gregory Cloutier
 * @version May 27, 2011: Class created.
 */
public class InstructorFeedback
{
  private Collection<Course> my_unwanted_courses;
  private Collection<Course> my_time_conflicted_courses;
  private int my_assigned_credit_hours;
  
  public InstructorFeedback
      (final Collection<Course> the_unwanted_courses,
       final Collection<Course> the_time_conflicted_courses,
       int the_assigned_credit_hours)                         
  {
    my_unwanted_courses = the_unwanted_courses;
    my_time_conflicted_courses = the_time_conflicted_courses;
    my_assigned_credit_hours = the_assigned_credit_hours;
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
