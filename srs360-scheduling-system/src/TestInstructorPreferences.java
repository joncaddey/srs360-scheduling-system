import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestInstructorPreferences
{
  private InstructorPreferences my_instructor_prefs;
  private Course my_test_course;
  private Day my_test_day;
  private GeneralTime my_test_time;
  
  @Before
  public void setUp()
  {
    my_instructor_prefs = new InstructorPreferences();
    my_test_course = new Course("100", "CSS360", 5);
    my_test_day = Day.MONDAY;
    my_test_time = GeneralTime.MORNING;
  }
  
  @Test
  public void testAddandRemoveMethods()
  {
    // test add and remove Courses
    my_instructor_prefs.addCourse(my_test_course);
    assertTrue("addCourse failed", my_instructor_prefs.
            getPreferredCourses().contains(my_test_course));
    my_instructor_prefs.removeCourse(my_test_course);
    assertFalse("removeCourse failed", my_instructor_prefs.
            getPreferredCourses().contains(my_test_course));
 
    // test add and remove Days
    my_instructor_prefs.addDay(my_test_day);
    assertTrue("addDay failed", my_instructor_prefs.
                  getPreferredDays().contains(my_test_day));
    my_instructor_prefs.removeDay(my_test_day);
    assertFalse("removeDay failed", my_instructor_prefs.
                  getPreferredDays().contains(my_test_day));
 
    // test add and remove Times
    my_instructor_prefs.addTime(my_test_time);
    assertTrue("addTime failed", my_instructor_prefs.
             getPreferredGeneralTimes().contains(my_test_time));
    my_instructor_prefs.removeTime(my_test_time);
    assertFalse("removeTime failed", my_instructor_prefs.
             getPreferredGeneralTimes().contains(my_test_time));
  }
  
}
