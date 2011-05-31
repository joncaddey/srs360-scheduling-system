/*
 * Simple Random Sample
 * 
 * TCSS 360 Dr. Tenenberg
 * 
 * srs360-scheduling-system
 */

package io;

import java.util.Scanner;

import users.User;
import users.UserCommunity;
import courses.Catalogue;
import courses.Course;
import courses.DaySlot;
import courses.Schedule;
import courses.Section;
import courses.Time;

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
 * Schedule can be retrieved. Multiple Schedules may be read
 * over the lifetime of this instance.
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
   * Contains the Schedule constructed from the last
   * successful read invocation.
   */
  private Schedule my_schedule;

  /**
   * Already read all the names of Days.
   */
  private final TimeSlotReader my_reader;

  /**
   * Contains information on all instructors.
   */
  private final Catalogue my_catalogue;
  private final UserCommunity my_user_community;

  /**
   * Creates an instance.
   * 
   * @param the_reader already read input containing names
   *          of all the Days.
   * @param the_catalogue
   */
  public SimpleScheduleReader(final TimeSlotReader the_reader,
                              final Catalogue the_catalogue,
                              final UserCommunity the_user_community)
  {
    my_reader = the_reader;
    my_catalogue = the_catalogue;
    my_user_community = the_user_community;
  }

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
   * <li>none</li>
   * </ul>
   * 
   * @param the_scanner reads input which has the proper
   *          format.
   */
  public void read(final Scanner the_scanner,
      final TimeSlotReader the_reader,
      final Catalogue the_catalogue)
  {
    String line;
    int to_skip = DEFAULT_ROW_OFFSET;

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
    while (the_scanner.hasNextLine())
    {
      line = the_scanner.nextLine();
      if (!line.startsWith(DEFAULT_COMMENT_STRING) &&
          !line.startsWith(DEFAULT_DELIMITER))
      {
        parseSectionString(line);

      }
    }

    // my_schedule = schedule;
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

  protected Section parseSectionString(final String the_line)
  {
    // course_id; // should look up from Catalogue <course
    // id to course>
    // section; // useful for making section
    // title; // does not need
    // instructor; // needs to get a reference to the
    // // actual instructor User from
    // // UserCommunity <user name to Users.>
    // days; // must parse with TimeSlotReader
    // start_time; // must parse with TimeSlotReader
    // end_time; // must parse with TimeSlotReader
    // credits; // must parse with Integer
    final String[] token = parseCells(the_line);

    User instructor = null;
    DaySlot dayslot = null;
    Time start_time = null;
    Time end_time = null;

    int i = 0;
    final Course course =
        my_catalogue.getCourse(token[i++]);
    // final String section = token[i++];
    i++; // skip section letter
    i++; // skip title
    if (token[i] != null)
    {
      instructor =
          my_user_community.getInstructor(token[i]);
    }
    i++;
    if (token[i] != null)
    {
      dayslot =
          new DaySlot(my_reader.parseDayString(token[i]));
    }
    i++;
    if (token[i] != null)
    {
      start_time = my_reader.parseTimeString(token[i]);
    }
    i++;
    if (token[i] != null)
    {
      end_time = my_reader.parseTimeString(token[i]);
    }
    // credits ignored.
    return new Section(course, instructor, dayslot,
      my_catalogue.getGeneralTime(start_time), start_time,
      end_time);
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
