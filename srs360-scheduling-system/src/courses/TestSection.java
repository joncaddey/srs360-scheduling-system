package courses;

import org.junit.Before;
import org.junit.Test;

import users.AdvisorPreferences;
import users.InstructorPreferences;
import users.StudentPreferences;
import users.User;

public class TestSection
{
  /**
   * Section(Course, null, null, null) when the Course
   * argument is null.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNullCourseParameterSection()
  {
    new Section(null, null, null, null);
  }
  
  /**
   * Section(Course, User, null, null) when the User is not
   * an instructor.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testUserNotInstructorParameterSection()
  {
    final Course course = new Course("", "", 0);
    final StudentPreferences stud_prefs =
                                   new StudentPreferences();
    final InstructorPreferences inst_prefs = null;
    final AdvisorPreferences adv_prefs =
                                   new AdvisorPreferences();
    
    // null inst_prefs, the second parameter, means the user
    // is not an instructor
    final User user = new User("", "", stud_prefs,
                                       null,
                                       adv_prefs, false);  
    new Section(course, user, null, null);
  }

}
