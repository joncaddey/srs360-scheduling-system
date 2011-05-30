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
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Scanner;

import users.AdvisorPreferences;
import users.InstructorPreferences;
import users.StudentPreferences;
import users.User;
import courses.Course;
import courses.Day;
import courses.GeneralTime;

/**
 * <p>
 * Parses a file containing all the users and their
 * preferences. Blank lines and lines starting with "%" are
 * ignored. Information is organized using case-sensitive
 * tags.
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
 * <p>
 * Data must be read using the read method before other
 * methods may be used. Data may be read only once,
 * effecively making instances immutable.
 * <p/>
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

  /**
   * A mapping of course IDs to Courses.
   */
  private Map<String, Course> my_course_map;

  /**
   * Knows how to parse a day String.
   */
  private TimeSlotReader my_reader;

  /**
   * Whether input has successfully been read.
   */
  private boolean my_successfully_read;

  /**
   * Creates a UserReader. Data must be inputed before other
   * methods may be called.
   * 
   * @param the_course_map a mapping of course IDs to
   *          corresponding Courses.
   * @param the_reader a reader that has already read Day
   *          information.
   * @throws IllegalArgumentException if either argument is
   *           null.
   */
  public UserReader(final TimeSlotReader the_reader,
                    final Map<String, Course> the_course_map)
    throws IllegalArgumentException
  {
    if (the_course_map == null)
    {
      throw new IllegalArgumentException(
        "the_course_map must not be null");
    }
    if (the_reader == null)
    {
      throw new IllegalArgumentException(
        "the_reader must not be null");
    }
    my_course_map = the_course_map;
    my_reader = the_reader;
  }

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
   * @throws IllegalStateException if data has already been
   *           read.
   * @param the_scanner contains the user data in the
   *          correct format.
   * 
   */
  public void read(final Scanner the_scanner)
      throws IllegalStateException
  {
    if (my_successfully_read)
    {
      throw new IllegalStateException(
        "Data may be read only once.");
    }
    String tag;
    final LineCommentScanner scanner =
        new LineCommentScanner(the_scanner);
    tag = scanner.getNonComment();
    while (tag != null)
    {
      // TODO if not USER_TAG then something's up

      // initialize fields to be used for constructing user.
      final String user_name = scanner.getNonComment();
      final String user_id = scanner.getNonComment();
      final String password = scanner.getNonComment();
      // TODO if password is null something's wrong

      StudentPreferences student = null;
      InstructorPreferences instructor = null;
      AdvisorPreferences advisor = null;
      boolean is_scheduler = false;

      tag = scanner.getNonComment();
      while (!USER_TAG.equals(tag))
      {
        if (STUDENT_TAG.equals(tag))
        {
          student = parseStudentPreferences(scanner);
        }

        tag = scanner.getNonComment();
      }

      my_user_map.put(user_id, new User(user_name,
        password, student, instructor, advisor,
        is_scheduler));
    }

    my_successfully_read = true;

  }

  /**
   * getNonComment should return the non comment after the
   * Student Tag. TODO add Description
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
   * @param the_scanner
   * @return
   */
  protected StudentPreferences parseStudentPreferences(
      final LineCommentScanner the_scanner)
  {
    final Collection<Day> days =
        my_reader.parseDayString(the_scanner
            .getNonComment());
    final Collection<GeneralTime> times =
        parseGeneralTimeString(the_scanner.getNonComment());
    return null;
  }

  /**
   * Returns a collection of all the Courses corresponding
   * to the course IDs found in the given string. Course IDs
   * should be separated by commas.
   * 
   * <br>
   * <br>
   * <b>Preconditions:</b>
   * <ul>
   * <li>the_string != null</li>
   * <li>the_string is as described</li>
   * <li>every course ID in the_string is a key in the Map
   * given upon construction.
   * </ul>
   * <b>Postconditions:</b>
   * <ul>
   * <li>the Course for every recognized course ID is in the
   * returned list.</li>
   * </ul>
   * 
   * @param the_string contains course IDs separated by
   *          commas.
   * @return the Courses corresponding to the course IDs in
   *         the_string.
   * @throws NullPointerException if the_string is null.
   * @throws IllegalArgumentException if an unrecognized
   *           course ID is in the_string.
   */
  protected Collection<Course> parseCourseString(
      final String the_string) throws NullPointerException,
      IllegalArgumentException
  {
    final String[] token = the_string.split(",");
    final Collection<Course> courses =
        new ArrayList<Course>(token.length);
    for (int i = 0; i < token.length; i++)
    {
      if (my_course_map.containsKey(token[i]))
      {
        courses.add(my_course_map.get(token[i]));
      }
      else
      {
        throw new IllegalArgumentException("\"" + token[i] +
                                           "\" is not a recognized course ID.");
      }
    }
    return courses;
  }

  /**
   * Given a string of times of day separated by commas,
   * returns a Collection of GeneralTimes that represent
   * those times of day.
   * 
   * <br>
   * <br>
   * <b>Preconditions:</b>
   * <ul>
   * <li>Every time of day in the_string is the toString()
   * output of a GeneralTime.</li>
   * <li>the_string != null</li>
   * </ul>
   * <b>Postconditions:</b>
   * <ul>
   * <li>none</li>
   * </ul>
   * 
   * @param the_string fits format as described above.
   * @return the GeneralTimes represented in the_string.
   * @throws NullPointerException if the_string is null.
   * @throws IllegalArgumentException if a time in
   *           the_string does not match the toString()
   *           output of a GeneralTime.
   */
  protected Collection<GeneralTime> parseGeneralTimeString(
      final String the_string) throws NullPointerException,
      IllegalArgumentException
      // TODO TEST THIS
  {
    final String[] token = the_string.split(",");
    Collection<GeneralTime> times =
        new ArrayList<GeneralTime>(token.length);
    final GeneralTime[] all_times = GeneralTime.values();

    // for every token, check to make sure it represents a
    // GeneralTime.
    for (int i = 0; i < token.length; i++)
    {
      boolean found = false;
      for (int j = 0; !found && j < all_times.length; j++)
      {
        if (token[i].equals(all_times[j].toString()))
        {
          times.add(all_times[j]);
          found = true;
        }
      }
      if (!found)
      {
        throw new IllegalArgumentException("\"" + token[i] +
                                           "\" is not a recognized time of day.");
      }
    }

    return times;
  }

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
      String separator =
          System.getProperty("line.separator");
      scanner =
          new Scanner(new File(
            "src/io/testUserReaderFile.txt"))
              .useDelimiter("[(aa)(bb)]");// %[^\n]+\n+

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
