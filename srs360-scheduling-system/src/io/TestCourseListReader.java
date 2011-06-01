/*
 * Simple Random Sample
 * 
 * srs360-scheduling-system
 */

package io;

import static org.junit.Assert.*;

import java.util.Scanner;

import org.junit.*;

import courses.Course;

/**
 * A series of tests.
 * 
 * @author Jonathan Caddey
 * @version May 30, 2011: Class created.
 */
public class TestCourseListReader
{

  private CourseListReader my_reader;

  /**
   * A scanner containing valid input for the test.
   */
  private Scanner my_scanner;

  /**
   * Sets up tests.
   */
  @Before
  public void setup()
  {
    my_reader = new CourseListReader();
    my_scanner =
        new Scanner("TCSS360,QA,5\n"
                    + "TCSS305,PROG PRACT,5");
  }

  /**
   * parseCourse when working properly.
   */
  @Test
  public void testWorksOkayParseCourse()
  {

    final Course course =
        my_reader.parseCourse("TCSS360,QA,5");
    assertEquals("Wrong ID", "TCSS360", course.getID());
    assertEquals("Wrong title", "QA", course.getTitle());
    assertEquals("Wrong credits", 5, course.getCredits());
  }

  /**
   * parseCourse when string null.
   */
  @Test(expected = NullPointerException.class)
  public void testNullParseCourse()
  {
    my_reader.parseCourse(null);
  }

  /**
   * parseCourse when not formatted properly.
   */
  @Test(expected = InputFormatException.class)
  public void testBadFormatParseCourse()
  {
    my_reader.parseCourse("TCSS360,QA,5,Tenenberg");
  }

  /**
   * parseCourse credits not integer.
   */
  @Test(expected = NumberFormatException.class)
  public void testNotIntegerParseCourse()
  {
    my_reader.parseCourse("TCSS360,QA,Batman");
  }

  /**
   * parseCourse credits are negative.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNegativeCreditsParseCourse()
  {
    my_reader.parseCourse("TCSS360,QA,-1");
  }

  /**
   * read call twice.
   */
  @Test(expected = IllegalStateException.class)
  public void testCallTwiceRead()
  {
    my_reader.read(my_scanner);
    my_reader.read(my_scanner);
  }

  /**
   * read when input is okay.
   */
  @Test
  public void testWorksOkayRead()
  {
    my_reader.read(my_scanner);
    assertNotNull("Should have found TCSS360", my_reader
        .getCourseMap().get("TCSS360"));

  }

  /**
   * getCourseMap before input is read.
   */
  @Test(expected = IllegalStateException.class)
  public void testBeforeReadGetCourseMap()
  {
    my_reader.getCourseMap();
  }

}
