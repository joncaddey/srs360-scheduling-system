/*
 * Simple Random Sample
 * 
 * TCSS 360 Dr. Tenenberg
 * 
 * srs360-scheduling-system
 */

package io;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;
import java.util.Scanner;

import users.User;

/**
 * <p>
 * Parses a file containing all the users and their
 * preferences. The file should contain the information of
 * all users. Empty lines or lines starting with the '%'
 * character are skipped by the reader. Information is
 * organized using case-insensitive tags.
 * </p>
 * <p>
 * The representation of a new user on the file starts with
 * the "USER" tag on its own line. The next 3 lines are
 * interpreted as the user name, user id, and password.
 * </p>
 * <p>
 * If the user is a Student, the "STUDENT" tag should follow
 * on its own line. The next line should contain a list of
 * days the student would be willing to go to school (see
 * TODO DaySlotReader.parseDayString()). The line after that
 * should be a comma-separated list of times of day the
 * student would be willing to go to school, being either
 * "MORNING", "EVENING", or "MORNING,EVENING". Finally, the
 * next line should be a comma-separated list of course IDs
 * of Courses the Student would like to attend.
 * </p>
 * 
 * <p>
 * If the user is a Instructor, the "INSTRUCTOR" tag should
 * follow on its own line. The next line should contain a
 * list of days the instructor would be willing to teach
 * (see TODO DaySlotReader.parseDayString()). The line after
 * that should be a comma-separated list of times of day the
 * instructor would be willing to teach, being either
 * "MORNING", "EVENING", or "MORNING,EVENING". Finally, the
 * next line should be a comma-separated list of course IDs
 * of Courses the Instructor would be willing to teach.
 * </p>
 * 
 * <p>
 * If the user is a Advisor, the "ADVISOR" tag should follow
 * on its own line. The next line should be a
 * comma-separated list of course IDs of Courses the Advisor
 * recommends be on the Schedule.
 * </p>
 * 
 * <p>
 * If the user is a Scheduler, the "SCHEDULER" tag should be
 * on its own line.
 * </p>
 * 
 * 
 * <br>
 * <br>
 * <b>Invariants:</b>
 * <ul>
 * <li>TODO invariant1</li>
 * </ul>
 * 
 * @author Jonathan Caddey
 * @version May 27, 2011: Class created.
 */
public class UserReader
{

  /**
   * Lines starting with this String are ignored by the
   * reader. Blank lines are also ignored.
   */
  private static final String COMMENT_STRING = "%";

  /**
   * Indicates the next lines from file will concern a new
   * user.
   */
  private static final String USER_TAG = "USER";

  /**
   * Indicates the next lines from file will concern the
   * Student preferences.
   */
  private static final String STUDENT_TAG = "STUDENT";

  /**
   * Indicates the next lines from file will concern the
   * Instructor preferences.
   */
  private static final String INSTRUCTOR_TAG = "INSTRUCTOR";

  /**
   * Indicates the next lines from file will concern the
   * Advisor preferences.
   */
  private static final String ADVISOR_TAG = "ADVISOR";

  /**
   * Indicates the user is a Scheduler.
   */
  private static final String SCHEDULER_TAG = "SCHEDULER";

  /**
   * A mapping of user IDs to Users.
   */
  private Map<String, User> my_user_map;

  // constructor needs as an argument something that can
  // parse Strings, and possibly a list of all Courses.

  // Should have read(File)

  /**
   * Reads a given file containing information about all the
   * users. See class documentation on how the file should
   * be organized.
   * 
   * <br>
   * <br>
   * <b>Preconditions:</b>
   * <ul>
   * <li>TODO</li>
   * </ul>
   * <b>Postconditions:</b>
   * <ul>
   * <li>TODO</li>
   * </ul>
   * 
   * @param the_file contains the user data in the correct
   *          format.
   * 
   */
  public void read(final File the_file) throws IOException
  {
    final LineCommentScanner scanner =
        new LineCommentScanner(new Scanner(the_file));
    String tag = scanner.getNonComment();
    if (tag != null)
    {
      tag = tag.toUpperCase();
    }
    while (USER_TAG.equals(tag))
    {
      final String user_name = scanner.getNonComment();

      System.out.println("USER ID: " +
                         scanner.getNonComment());
      System.out.println("PASSWORD: " +
                         scanner.getNonComment());

      tag = scanner.getNonComment();
      if (tag != null)
      {
        tag = tag.toUpperCase();
      }

      while (tag != null && !USER_TAG.equals(tag))
      {
        if (tag.equals(STUDENT_TAG))
        {
          System.out.println("STUDENT");
        }
        else if (tag.equals(INSTRUCTOR_TAG))
        {
          System.out.println("INSTRUCTOR");
        }
        else if (tag.equals(ADVISOR_TAG))
        {
          System.out.println("ADVISOR");
        }
        else if (tag.equals(SCHEDULER_TAG))
        {
          System.out.println("ADVISOR");
        }
        tag = scanner.getNonComment();
        if (tag != null)
        {
          tag = tag.toUpperCase();
        }

      }
    }

  }

  // Should have Map<String, User> getUserMap, which returns
  // mapping of userId to Users.

  /**
   * Returns a mapping of user IDs to the Users they belong
   * to. The Users are those represented in the file passed
   * to the last successful read invocation.
   * 
   * <br>
   * <br>
   * <b>Preconditions:</b>
   * <ul>
   * <li>read(File) has been called</li>
   * </ul>
   * <b>Postconditions:</b>
   * <ul>
   * <li>TODO</li>
   * </ul>
   * 
   * @return a mapping of user IDs to the Users they belong
   *         to.
   */
  Map<String, User> getUserMap()
  {
    return Collections.unmodifiableMap(my_user_map);
  }

  public static void main(String[] args)
  {
    // try
    // {
    // new UserReader().read(new File(
    // "src/io/testUserReaderFile.txt"));
    // }
    // catch (IOException the_e)
    // {
    // System.out.println(the_e.getMessage());
    // }
    Scanner scanner;
    try
    {
      String separator = System
      .getProperty("line.separator");
      scanner =
          new Scanner(new File(
            "src/io/testUserReaderFile.txt"))
              .useDelimiter("[(aa)(bb)]");//%[^\n]+\n+

      System.out.println(scanner.next());
      System.out.println(scanner.next());
      System.out.println(scanner.next());
      System.out.println(scanner.next());

    }
    catch (IOException the_e)
    {
      System.out.println(the_e.getMessage());
    }
  }
}
