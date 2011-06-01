/*
 * Simple Random Sample
 * 
 * srs360-scheduling-system
 */

package users;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;

import courses.Course;
import courses.Day;
import courses.DaySlot;
import courses.GeneralTime;
import courses.Schedule;
import courses.Section;

public class TestStudentPreferences
{
  private StudentPreferences my_student_prefs;
  private Course my_test_course;
  private Day my_test_day;
  private GeneralTime my_test_time;
  
  @Before
  public void setUp()
  {
    my_test_course = new Course("100", "CSS360", 5);
    my_test_day = Day.MONDAY;
    my_test_time = GeneralTime.MORNING;
  } 
  
  @Test
  public void testAddandRemoveMethods()
  {
    // test add and remove Courses
    my_student_prefs.addCourse(my_test_course);
    assertTrue("addCourse failed", my_student_prefs.
            getPreferredCourses().contains(my_test_course));
    my_student_prefs.removeCourse(my_test_course);
    assertFalse("removeCourse failed", my_student_prefs.
            getPreferredCourses().contains(my_test_course));
 
    // test add and remove Days
    my_student_prefs.addDay(my_test_day);
    assertTrue("addDay failed", my_student_prefs.
                  getPreferredDays().contains(my_test_day));
    my_student_prefs.removeDay(my_test_day);
    assertFalse("removeDay failed", my_student_prefs.
                  getPreferredDays().contains(my_test_day));
 
    // test add and remove Times
    my_student_prefs.addTime(my_test_time);
    assertTrue("addTime failed", my_student_prefs.
             getPreferredGeneralTimes().contains(my_test_time));
    my_student_prefs.removeTime(my_test_time);
    assertFalse("removeTime failed", my_student_prefs.
             getPreferredGeneralTimes().contains(my_test_time));
  }
  
}
