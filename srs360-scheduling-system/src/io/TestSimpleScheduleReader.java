/*
 * Simple Random Sample
 * 
 * srs360-scheduling-system
 */

package io;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import org.junit.*;

import users.UserCommunity;

import courses.Catalogue;
import courses.Course;
import courses.Section;

/**
 * Tests the methods of SimpleScheduleReader.
 * 
 * @author Jonathan Caddey
 * @version May 19, 2011: Class created.
 */
public class TestSimpleScheduleReader
{

  private SimpleScheduleReader my_reader;

  /**
   * Sets up objects for the unit tests.
   */
  @Before
  public void setUp()
  {
    try
    {
      TimeSlotReader reader = new TimeSlotReader();
      reader.read(new Scanner(new File(
        "src/io/dayslots.txt")));
      CourseListReader course_list_reader =
          new CourseListReader();
      course_list_reader.read(new Scanner(new File(
        "src/io/masterCourseList.txt")));
      Catalogue catalogue =
          new Catalogue(course_list_reader.getCourseMap(),
            reader.getDaySlots(), reader.getCutoffTime());
      UserReader user_reader =
          new UserReader(reader,
            course_list_reader.getCourseMap());
      user_reader.read(new Scanner(new File(
        "src/io/testUserReaderFile.txt")));

      my_reader =
          new SimpleScheduleReader(reader, catalogue,
            new UserCommunity(user_reader.getUserMap()
                .values(), catalogue));
    }
    catch (final IOException the_e)
    {
      fail(the_e.getMessage());
    }
  }

  /**
   * parseCells reads a line with no TBAs, blanks, etc..
   */
  @Test
  public void testAllFullParseCells()
  {
    assertArrayEquals("Did not parse cells", new String[] {
        "Hello", " ", "world!"},
        my_reader.parseCells("Hello, ,world!"));

  }

  /**
   * parseCells reads a line with a TBA, blank, and comment.
   */
  @Test
  public void testTBABlankCommentParseCells()
  {
    assertArrayEquals(
        "Did not handle blanks",
        new String[] {null, "Hello", null, null, "world!"},
        my_reader
            .parseCells(",Hello,TBA,%comments are ignored,world!,"));
  }

  /**
   * parseSectionString when working properly.
   */
  @Test
  public void testOkayParseSectionString()
  {
    Section section =
        my_reader
            .parseSectionString("TCSS360,A,Don't Care in Catalogue,Papa,MW,1615,1820,5");
    assertEquals("Wrong ID, Title, or credits", new Course(
      "TCSS360", "SOFTWARE DEV AND QA", 5),
        section.getCourse());
    assertTrue("Not an instructor", section.getInstructor()
        .isInstructor());

  }

  /**
   * read when working properly.
   */
  @Test
  public void testOkayRead()
  {
    try
    {
      my_reader.read(new Scanner(new File(
        "src/io/testSchedule.csv")));
    }
    catch (final IOException the_e)
    {
      fail(the_e.getMessage());
    }
    assertEquals("Wrong number classes.", 3, my_reader
        .getSchedule().getSections().size());
  }

}
