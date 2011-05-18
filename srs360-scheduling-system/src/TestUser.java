/**
 * Simple Random Sample
 * 
 * TCSS 360 Dr. Tenenberg
 * 
 * srs360-scheduling-system
 */
import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

/**
 * Contains tests for methods in the User class.
 * 
 * <br><br><b>Invariants:</b>
 * <ul><li>invariant1</li>
 * </ul>
 * 
 * @author David
 * @version May 16, 2011
 */
public class TestUser
{
  private User user;
  private AdvisorPreferences advisor_preferences;
  
  @Before
  public void setUp()
  {
    user = new User("David");
    advisor_preferences = new AdvisorPreferences();
  }
  
  /**
   * <br><br><b>Preconditions:</b>
   * <ul><li>pre1: a valid Schedule containing TCSS360</li>
   * </ul>
   * <b>Postconditions:</b>
   * <ul><li>post1: verification that TCSS360 is not
   * included in the List of missing Courses</li>
   * </ul>
   * @param the_schedule The Schedule of Courses
   */
  @Test
  public void testGetAdvisorFeedback(Schedule the_schedule)
  {
    Course tcss360 = new Course("TCSS360");
    advisor_preferences.addCourse(tcss360);
    List<Course> missingCourses = user.getAdvisorFeedback
                                             (the_schedule);
    assertFalse(missingCourses.contains(tcss360));   
  } 

}
