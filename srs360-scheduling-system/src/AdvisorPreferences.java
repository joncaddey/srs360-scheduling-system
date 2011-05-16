import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Simple Random Sample
 * 
 * TCSS 360 Dr. Tenenberg
 * 
 * srs360-scheduling-system
 */

public class AdvisorPreferences
{
  private List<Course> my_preferred_courses;
  
  public AdvisorPreferences()
  {
    my_preferred_courses = new ArrayList<Course>();
  } 

  public void addCourse(Course the_course)
  {
    my_preferred_courses.add(the_course);
  }
  
  public void removeCourse(Course the_course)
  {
    my_preferred_courses.remove(the_course);
  }
  
  public List<Course> getPreferredCourses()
  {
    return my_preferred_courses;
  }

}
