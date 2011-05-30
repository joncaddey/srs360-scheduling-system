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

import courses.Course;

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
}
