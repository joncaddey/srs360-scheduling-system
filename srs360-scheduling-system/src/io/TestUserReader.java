/*
 * Simple Random Sample
 * 
 * TCSS 360 Dr. Tenenberg
 * 
 * srs360-scheduling-system
 */

package io;

import static org.junit.Assert.*;

import java.util.Collection;
import java.util.Scanner;

import org.junit.*;

import users.StudentPreferences;

import courses.Course;
import courses.Day;
import courses.GeneralTime;

/**
 * Contains tests for the UserReader class.
 * 
 * @author Jonathan Caddey
 * @version May 27, 2011: Class created.
 */
public class TestUserReader
{

  private UserReader my_reader;

  /**
   * Sets up the tests by constructing a new UserReader.
   */
  @Before
  public void setup()
  {
    final TimeSlotReader time_reader = new TimeSlotReader();
    time_reader.read(new Scanner("M,T,W,Th,F,S,Sn\n"
                                 + "1615\nMW\nTTh"));
    final CourseListReader course_reader =
        new CourseListReader();
    course_reader.read(new Scanner(
      "TCSS360,QA,5\nTCSS305,PROG PRACT,5"));
    my_reader =
        new UserReader(time_reader,
          course_reader.getCourseMap());
  }

  /**
   * parseCourseString when working okay.
   */
  @Test
  public void testOkayParseCourseString()
  {
    final Collection<Course> courses =
        my_reader.parseCourseString("TCSS360,TCSS305");
    assertTrue("Did not find first course",
        courses.contains(new Course("TCSS360", "QA", 5)));
    assertTrue("Did not find second course",
        courses.contains(new Course("TCSS305",
          "PROG PRACT", 5)));
  }

  /**
   * parseCourseString when unrecognized course.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testMissingCourseParseCourseString()
  {
    my_reader.parseCourseString("TCSS360, TCSS422");
  }

  /**
   * parseCourseString when null input.
   */
  @Test(expected = NullPointerException.class)
  public void testNullParseCourseString()
  {
    my_reader.parseCourseString(null);
  }

  /**
   * parseGeneralTimeString when working properly.
   */
  @Test
  public void testWorksOkayParseGeneralTimeString()
  {
    final Collection<GeneralTime> times =
        my_reader.parseGeneralTimeString("MORNING,EVENING");
    assertTrue("Missing MORNING",
        times.contains(GeneralTime.MORNING));
    assertTrue("Missing EVENING",
        times.contains(GeneralTime.EVENING));
  }

  /**
   * parseGeneralTimeString when unrecognized time of day.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testUnrecognizedTimeParseGeneralTimeString()
  {
    my_reader.parseGeneralTimeString("MORNING, EVENING");
  }

  /**
   * parseStudentPreferences when working properly. This
   * method is so dependent on other well-tested methods
   * that it is not exercised so thoroughly.
   */
  @Test
  public void testOkayParseStudentPreferences()
  {

    StudentPreferences student =
        my_reader
            .parseStudentPreferences(new LineCommentScanner(
              new Scanner("MTWThF\n" + "MORNING\n"
                          + "TCSS360,TCSS305")));
    assertTrue(
        "Should be in MORNING",
        student.getPreferredGeneralTimes().contains(
            GeneralTime.MORNING));
    assertEquals("Wrong number of preferred Days", 5,
        student.getPreferredDays().size());
  }
  
}
