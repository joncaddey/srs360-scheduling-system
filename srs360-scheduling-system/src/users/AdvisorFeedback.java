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

/**
 * Represents feedback from an advisor.<br>
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

  private final Collection<Course> my_courses;
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

  /**
   * @return a String representation of the object.
   * @author Jonathan Caddey
   */
  public String toString()
  {
    StringBuilder str = new StringBuilder();
    str.append(my_advisor.getName() +
               " recommends but does not see ");
    for (Course course : my_courses)
    {
      str.append(course.getID() + ", ");
    }
    str.deleteCharAt(str.length() - 2);
    return str.toString();
  }
}
