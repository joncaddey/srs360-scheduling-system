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
 * Contains tests for the LineCommentScanner class.
 * 
 * @author Jonathan Caddey
 * @version May 28, 2011: Class created.
 */
public class TestLineCommentScanner
{
  /**
   * The line separator used for testing with blank lines.
   */
  private static final String LINE_SEPARATOR = System
      .getProperty("line.separator");

  /**
   * A non-blank, non-commented line.
   */
  private static final String NON_COMMENT = "not a comment";

  /**
   * A commented line.
   */
  private static final String COMMENT = "% a comment";

  /**
   * getNonComment when start with blank.
   */
  @Test
  public void testStartBlankGetNonComment()
  {
    final LineCommentScanner scanner =
        new LineCommentScanner(new Scanner(LINE_SEPARATOR +
                                           LINE_SEPARATOR +
                                           NON_COMMENT));

    assertEquals("Should have skipped blank", NON_COMMENT,
        scanner.getNonComment());
  }

  /**
   * getNonComment when start with comment, then blank.
   */
  @Test
  public void testStartCommentGetNonComment()
  {
    final LineCommentScanner scanner =
        new LineCommentScanner(new Scanner(COMMENT +
                                           LINE_SEPARATOR +
                                           NON_COMMENT));

    assertEquals("Should have skipped Comment",
        NON_COMMENT, scanner.getNonComment());
  }

  /**
   * getNonComment when no non comments.
   */
  @Test
  public void testNoNonCommentsGetNonComment()
  {
    final LineCommentScanner scanner =
        new LineCommentScanner(new Scanner(COMMENT));

    assertEquals("Should have found no non comments", null,
        scanner.getNonComment());
  }

  /**
   * getNonComment when at EOF.
   */
  @Test
  public void testEOFGetNonComment()
  {
    final LineCommentScanner scanner =
        new LineCommentScanner(new Scanner(""));

    assertEquals("Should have returned null at EOF", null,
        scanner.getNonComment());
  }

  /**
   * getNonComment for various line numbers.
   */
  @Test
  public void testLineNumberGetNonComment()
  {
    final LineCommentScanner scanner =
        new LineCommentScanner(new Scanner(NON_COMMENT +
                                           LINE_SEPARATOR +
                                           LINE_SEPARATOR +
                                           NON_COMMENT));
    assertEquals("Bad initialization", 0,
        scanner.getLineNumber());
    scanner.getNonComment();
    assertEquals("Increment too soon", 1,
        scanner.getLineNumber());
    scanner.getNonComment();
    assertEquals("Bad counting on skip", 3,
        scanner.getLineNumber());

  }

}
