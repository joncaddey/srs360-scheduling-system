package users;

import org.junit.Before;
import org.junit.Test;

import courses.Course;
import courses.Section;
import static org.junit.Assert.*;

public class TestAdvisorPreferences
{
  private AdvisorPreferences my_adv_prefs;
  private Section my_test_section;
  
  @Before
  public void setUp()
  {
    my_adv_prefs = new AdvisorPreferences();
    Course course = new Course("TCSS360", "Prog QA", 5);
    User user = new User("Dave", "liddid", "password",
                          true, false, false, false);
    my_test_course = new Section(course, user);                         
  }
  
  @Test
  public void testAddandRemoveSection()
  {
    my_adv_prefs.addcourse(my_test_course);
    assertTrue("addcourse failed", my_adv_prefs.
          getPreferredcourses().contains(my_test_course));
    my_adv_prefs.removecourse(my_test_course);
    assertFalse("removecourse failed", my_adv_prefs.
          getPreferredcourses().contains(my_test_course));
  }

}
