/*
 * Simple Random Sample
 * 
 * TCSS 360 Dr. Tenenberg
 * 
 * srs360-scheduling-system
 */

package io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

import courses.Catalogue;

/**
 * <p>
 * A SimpleScheduleReader reads a given .csv file to produce
 * a Schedule. Cells that start with "%" are treated as
 * comments and ignored by the SimpleScheduleReader. Entire
 * lines rows are commented by commenting the first cell in
 * that row. Every row after 2 non-commented lines have been
 * skipped is assumed to represent a Section on a Schedule
 * columns in the following order:
 * </p>
 * <p>
 * <code>
 * COURSE_ID, SECTION, CLASS_TITLE, INSTRUCTOR, DAYS, 
 * START_TIME, END_TIME, CREDITS
 * </code>
 * </p>
 * 
 * <p>
 * Cells that are yet to be determined can be commented,
 * left blank, or contain "TBA". Of the cells, only
 * INSTRUCTOR, DAYS, START_TIME, and END_TIME may be TBA.
 * Input must be read with a read invocation before the
 * Schedule can be retrieved.
 * </p>
 * <b>Invariants:</b>
 * <ul>
 * <li>none</li>
 * </ul>
 * 
 * @author Jonathan Caddey
 * @version May 19, 2011: Class created.
 */
public final class SimpleScheduleReader
{

  /**
   * Cells that start with this String are treated as a
   * comment and ignored by the reader.
   */
  public static final String DEFAULT_COMMENT_STRING = "%";

  /**
   * Fields identified with this String indicate that their
   * contents have yet to be announced.
   */
  public static final String DEFAULT_TBA = "TBA";

  /**
   * The delimiter which separates cells in the file.
   */
  public static final String DEFAULT_DELIMITER = ",";

  /**
   * The number of lines that are skipped before Sections
   * are read.
   */
  public static final int DEFAULT_ROW_OFFSET = 2;

  /**
   * Whether input has been read successfully.
   */
  private boolean my_successfully_read = false;

  /**
   * Reads input in the format described in the class
   * documentation.
   * 
   * <br>
   * <br>
   * <b>Preconditions:</b>
   * <ul>
   * <li>Data has not already been successfully read.</li>
   * <li>the_reader has already read information</li>
   * </ul>
   * <b>Postconditions:</b>
   * <ul>
   * <li>TODO</li>
   * </ul>
   * 
   * @param the_scanner reads input which has the proper
   *          format.
   * @param the_reader has read input containing the names
   *          for all Days.
   * @param the_catalogue used to lookup instructor names.
   * @throws IllegalStateException if data has already been
   *           read.
   */
  public void read(final Scanner the_scanner,
      final TimeSlotReader the_reader,
      final Catalogue the_catalogue)
      throws IllegalStateException
  {
    if (my_successfully_read)
    {
      throw new IllegalStateException(
        "Can only read input once.");
    }
    String line;
    int to_skip = DEFAULT_ROW_OFFSET;

    String course_id; // should look up from Catalogue
    String section; // useful for making section
    String title; // does not need--in catalogue
    String instructor; // needs to get a reference to the
                       // actual instructor User from
                       // Catalogue.
    String days; // must parse with TimeSlotReader
    String start_time; // must parse with TimeSlotReader
    String end_time; // must parse with TimeSlotReader
    String credits; // must parse with Integer
    line = the_scanner.nextLine();

    // Must skip first few lines.
    while (null != line && to_skip > 0)
    {
      if (!line.startsWith(DEFAULT_COMMENT_STRING))
      {
        to_skip--;
        System.out.println("Skipped line: " + line);
      }
      line = the_scanner.nextLine();
    }

    // now treat each non-commented line as a Section.
    while (null != line)
    {

    }
  }

  /**
   * Returns an array containing the Strings that appear
   * from right to left separated by the reader's delimiter.
   * If the ith cell is empty, commented, or TBA, the ith
   * element of the returned array is null. If the last
   * cells are blank they will not be added to the end of
   * the returned array.
   * 
   * <br>
   * <br>
   * <b>Preconditions: </b>
   * <ul>
   * <li>the_line != null</li>
   * </ul>
   * <b>Postconditions:</b>
   * <ul>
   * <li>The returned array contains the cells of the_line
   * as interpreted as a .csv file.</li>
   * </ul>
   * 
   * @param the_line a line of cells, separated by this
   *          reader's delimiter.
   * @return the cells represented in the_line, with null
   *         for blank or otherwise ignored cells.
   * @throws NullPointerException if the_line is null.
   */
  protected String[] parseCells(final String the_line)
      throws NullPointerException
  {
    final String[] r = the_line.split(DEFAULT_DELIMITER);
    for (int i = 0; i < r.length; i++)
    {
      if ("".equals(r[i]) || r[i].equals(DEFAULT_TBA) ||
          r[i].startsWith(DEFAULT_COMMENT_STRING))
      {
        r[i] = null;
      }
    }
    return r;
  }

  public static void main(final String[] the_args)
  {
    String string = ",Hello,,";
    String[] parts = string.split(",");
    System.out.println(parts.length);
    for (int i = 0; i < parts.length; i++)
    {
      System.out.println(parts[i]);
    }

  }

}
