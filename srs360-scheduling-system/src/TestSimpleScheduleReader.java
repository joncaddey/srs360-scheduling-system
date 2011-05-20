/*
 * Simple Random Sample
 * 
 * TCSS 360 Dr. Tenenberg
 * 
 * srs360-scheduling-system
 */

import static org.junit.Assert.*;

import org.junit.*;

/**
 * Tests the methods of SimpleScheduleReader.
 * 
 * @author Jonathan Caddey
 * @version May 19, 2011: Class created.
 */
public class TestSimpleScheduleReader
{

  private final SimpleScheduleReader my_reader =
      new SimpleScheduleReader();

  /**
   * Sets up objects for the unit tests.
   */
  @Before
  public void setUp()
  {

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

}
