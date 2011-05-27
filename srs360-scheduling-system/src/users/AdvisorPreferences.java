/*
 * Simple Random Sample
 * 
 * TCSS 360 Dr. Tenenberg
 * 
 * srs360-scheduling-system
 */

package users;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import courses.Course;
/**
 * Stores a list of advisor preferred sections.
 * TODO
 * <br><br><b>Invariants:</b>
 * <ul><li>TODO invariant1</li>
 * </ul>
 * 
 * @author David
 * @version May 21, 2011: Class created.
 */
public class AdvisorPreferences
{
  /**
   * A list of preferred sections.
   */
  private List<Course> my_preferred_courses;
  
  /**
   * Creates a new AdvisorPreferences.
   */
  public AdvisorPreferences()
  {
    my_preferred_courses = new ArrayList<Course>();
  } 

  public void addCourse(Course the_course)
  {
    my_preferred_courses.add(the_course);
  }
  
  public void removecourse(Course the_course)
  {
    my_preferred_courses.remove(the_course);
  }
  
  public List<Course> getPreferredcourses()
  {
    return my_preferred_courses;
  }

}
