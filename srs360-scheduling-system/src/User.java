/**
 * Simple Random Sample
 * 
 * TCSS 360 Dr. Tenenberg
 * 
 * srs360-scheduling-system
 */
import java.util.ArrayList;
import java.util.List;

/**
 * Creates a User of the Scheduling System.
 * 
 * <br><br><b>Invariants:</b>
 * <ul><li>invariant1</li>
 * </ul>
 * 
 * @author David
 * @version May 16, 2011
 */
public class User
{
  private String my_name;
  private AdvisorPreferences advisor_preferences;
  private StudentPreferences student_preferences;
  private InstructorPreferences instructor_preferences;
  
  /**
   * Creates a User with the given name.
   * 
   * @param the_name The user name.
   * @throws IllegalArgumentException if the name is null.
   */
  public User(final String the_name)
                           throws IllegalArgumentException
  {
    my_name = the_name; 
    advisor_preferences = new AdvisorPreferences();
    student_preferences = new StudentPreferences();
    instructor_preferences = new InstructorPreferences();   
  }
  
  /**
   * <br><br><b>Preconditions:</b>
   * <ul><li>pre1: a valid Schedule</li>
   * </ul>
   * <b>Postconditions:</b>
   * <ul><li>post1: a list of missing courses</li>
   * </ul>
   * @param the_schedule The Schedule of Courses
   * @return A List of missing Courses
   */
  public List<Course> getAdvisorFeedback(Schedule the_schedule)
  {
    List<Course> missingCourseList = new ArrayList<Course>();
    for (Course advisorPreferredCourse:
                advisor_preferences.getPreferredCourses())
    {
      if (!Schedule.contains(advisorPreferredCourse))
      {
        missingCourseList.add(advisorPreferredCourse);
      }
    }
    return missingCourseList;
  }
  
}
