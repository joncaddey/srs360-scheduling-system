/*
 * Simple Random Sample
 * 
 * srs360-scheduling-system
 */

package io;

import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * A wrapper for Scanner which can be used to keep track of
 * line number and skip commented and blank lines. <br>
 * <br>
 * <b>Invariants:</b>
 * <ul>
 * <li>none</li>
 * </ul>
 * 
 * @author Jonathan Caddey
 * @version May 28, 2011: Class created.
 */
public class LineCommentScanner
{
  private final String COMMENT_STRING = "%";
  final private Scanner my_scanner;
  private int my_line_number;
  private String my_last;

  /**
   * Initializes at line 0.
   * 
   * @param the_scanner used to parse input. Only a
   *          reference is held--no copy is made.
   */
  public LineCommentScanner(final Scanner the_scanner)
  {
    my_scanner = the_scanner;
    my_line_number = 0;
  }

  /**
   * Advances the Scanner until the first line after the
   * current which is not blank and does not start with a
   * "%". <br>
   * <br>
   * <b>Preconditions:</b>
   * <ul>
   * <li>none</li>
   * </ul>
   * <b>Postconditions:</b>
   * <ul>
   * <li>the end of input is reached if null is returned.</li>
   * </ul>
   * 
   * @return the next line from the given Scanner which is
   *         not blank and does not start with "%", or null
   *         if there is no such line.
   */
  public String getNonComment()
  {
    String non = null;
    while (my_scanner.hasNext())
    {
      final String line = my_scanner.nextLine();
      my_line_number++;
      if (!"".equals(line.trim()) &&
          !line.startsWith(COMMENT_STRING))
      {
        non = line;
        break;
      }
    }
    return non;
  }

  public int getLineNumber()
  {
    return my_line_number;
  }

  public void setLineNumber(final int the_line_number)
  {
    my_line_number = the_line_number;
  }

}
