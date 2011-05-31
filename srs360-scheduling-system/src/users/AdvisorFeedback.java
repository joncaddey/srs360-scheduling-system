/*
 * Simple Random Sample
 * 
 * TCSS 360 Dr. Tenenberg
 * 
 * srs360-scheduling-system
 */

package users;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import courses.Course;

/**
 * Represents feedback from an advisor. This is basically a
 * holder of a Collection<Courses>, and is included simply
 * for ease of any future refactoring. <br>
 * <br>
 * <b>Invariants:</b>
 * <ul>
 * <li>getCourses != null</li>
 * </ul>
 * 
 * @author Jonathan Caddey
 * @version May 31, 2011: Class created.
 */
public class AdvisorFeedback
{

  private final Collection my_courses;
  private final User my_advisor;

  public AdvisorFeedback(Collection<Course> the_courses,
                         final User the_advisor)
  {
    my_courses = new ArrayList<Course>(the_courses);
    my_advisor = the_advisor;
  }

  public Collection<Course> getCourses()
  {
    return Collections.unmodifiableCollection(my_courses);
  }

  public User getAdvisor()
  {
    return my_advisor;
  }
}
