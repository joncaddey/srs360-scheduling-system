/*
 * Simple Random Sample
 * 
 * TCSS 360 Dr. Tenenberg
 * 
 * srs360-scheduling-system
 */
package io;

import static org.junit.Assert.*;

import java.util.Scanner;

import org.junit.*;

/**
 * Tests the methods of SimpleScheduleReader.
 * 
 * @author Jonathan Caddey
 * @version May 19, 2011: Class created.
 */
public class TestSimpleScheduleReader
{

  private final SimpleScheduleReader my_reader;

  /**
   * Sets up objects for the unit tests.
   */
  @Before
  public void setUp()
  {
    TimeSlotReader reader = new TimeSlotReader();
    reader.read(new Scanner("M,T,W,Th,F,S,Sn\n1615\nMW\nTR\nF"));
    

    my_reader = new SimpleScheduleReader(reader, the_catalogue, the_user_community)
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
   * parseSectionString when working properly
   */
  @Test
  public void testOkayParseSectionString() {
    fail();
  }

}
