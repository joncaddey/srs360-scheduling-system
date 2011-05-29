package courses;


import org.junit.Before;
import org.junit.Test;

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
  
  /* TODO: finish this after changing User constructor*/
  @Test(expected = IllegalArgumentException.class)
  public void testUserNotInstructorParameterSection()
  {
    final Course course = new Course(null, null, 0);
    boolean isInstructor = false;
    final User user = new User(String, String, null, isInstructor,
                         false, false, false);
    new Section(course, user, null, null);
  }

}
