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
 * Contains tests for the UserReader class.
 * 
 * @author Jonathan Caddey
 * @version May 27, 2011: Class created.
 */
public class TestUserReader
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
    final Scanner scanner =
        new Scanner(LINE_SEPARATOR + LINE_SEPARATOR +
                    NON_COMMENT);

    assertEquals("Should have skipped blank", NON_COMMENT,
        UserReader.getNonComment(scanner));
  }

  /**
   * getNonComment when start with comment, then blank.
   */
  @Test
  public void testStartCommentGetNonComment()
  {
    final Scanner scanner =
        new Scanner(COMMENT + LINE_SEPARATOR + NON_COMMENT);

    assertEquals("Should have skipped Comment",
        NON_COMMENT, UserReader.getNonComment(scanner));
  }

  /**
   * getNonComment when no non comments.
   */
  @Test
  public void testNoNonCommentsGetNonComment()
  {
    final Scanner scanner = new Scanner(COMMENT);

    assertEquals("Should have found no non comments", null,
        UserReader.getNonComment(scanner));
  }

  /**
   * getNonComment when at EOF.
   */
  @Test
  public void testEOFGetNonComment()
  {
    final Scanner scanner = new Scanner("");

    assertEquals("Should have returned null at EOF", null,
        UserReader.getNonComment(scanner));
  }

}
