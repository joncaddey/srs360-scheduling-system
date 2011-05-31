/*
 * Simple Random Sample
 * 
 * TCSS 360 Dr. Tenenberg
 * 
 * srs360-scheduling-system
 */

package io;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import courses.Course;

/**
 * <p>
 * Reads all the Courses from a file. Every line should
 * contain the information for a Course, with the course ID,
 * title, and number of credits all on the same line,
 * separated by commas. Instances are effectively immutable
 * once input is read.
 * </p>
 * 
 * <b>Invariants:</b>
 * <ul>
 * <li>TODO invariant1</li>
 * </ul>
 * 
 * @author Jonathan Caddey
 * @version May 30, 2011: Class created.
 */
public class CourseListReader
{

  /**
   * The number of fields to read in for each Course.
   */
  private static final int FIELDS_IN_COURSE = 3;

  /**
   * Mapping of course ID to Courses.
   */
  private Map<String, Course> my_course_map;

  /**
   * Whether a successful read has been made.
   */
  private boolean my_successfully_read;

  /**
   * Reads the input of Scanner as a list of Courses. See
   * class description for the required formatting.
   * 
   * <br>
   * <br>
   * <b>Preconditions:</b>
   * <ul>
   * <li>Input has not been successfully read before.</li>
   * <li>the_scanner != null</li>
   * <li>the input is properly formatted</li>
   * </ul>
   * <b>Postconditions:</b>
   * <ul>
   * <li>All courses within the input are represented in the
   * return.</li>
   * </ul>
   * 
   * @param the_scanner can retrieve properly formatted
   *          input.
   * @throws IllegalStateException if input has already
   *           successfully been read.
   * @throws InputFormatException if the format of the input
   *           is not as described in class documentation.
   */
  public void read(final Scanner the_scanner)
      throws IllegalStateException, InputFormatException
  {
    if (my_successfully_read)
    {
      throw new IllegalStateException(
        "Cannot read input a second time.");
    }
    my_course_map = new HashMap();
    LineCommentScanner scanner =
        new LineCommentScanner(the_scanner);
    String line = scanner.getNonComment();
    while (line != null)
    {
      // TODO be more robust, document Exceptions.
      final Course course = parseCourse(line);

      my_course_map.put(course.getID(), course);
      line = scanner.getNonComment();
    }
    my_successfully_read = true;

  }

  /**
   * Parses a line to get a Course. The line must contain
   * the course ID, title, and credits, separated by commas.
   * 
   * <br>
   * <br>
   * <b>Preconditions:</b>
   * <ul>
   * <li>the_string is properly formatted.</li>
   * <li>the_string is not null</li>
   * </ul>
   * <b>Postconditions:</b>
   * <ul>
   * <li>none</li>
   * </ul>
   * 
   * @param the_string contains information for a Course.
   * @return the Course represented in the_string.
   * @throws NullPointerException if the_string is null.
   * @throws InputFormatException if the_string is not
   *           properly formatted.
   * @throws NumberFormatException if the credits is not an
   *           integer
   * @throws IllegalArgumentException if the credits is
   *           negative.
   */
  protected Course parseCourse(final String the_string)
      throws NullPointerException, NumberFormatException,
      IllegalArgumentException, InputFormatException
  {
    final String[] tokens = the_string.split(",");
    if (tokens.length != FIELDS_IN_COURSE)
    {
      throw new InputFormatException(
        "Must have the ID, title, and credits.");
    }
    return new Course(tokens[0], tokens[1],
      Integer.parseInt(tokens[2]));
  }

  /**
   * <b>Preconditions:</b>
   * <ul>
   * <li>input has been read.</li>
   * </ul>
   * <b>Postconditions:</b>
   * <ul>
   * <li>does not return null.</li>
   * </ul>
   * 
   * @throws IllegalStateException if invoked before input
   *           is read.
   * @return a mapping of course IDs to Courses.
   */
  public Map<String, Course> getCourseMap()
      throws IllegalStateException
  {
    if (!my_successfully_read)
    {
      throw new IllegalStateException(
        "Must read input first.");
    }
    return Collections.unmodifiableMap(my_course_map);
  }

  
}
