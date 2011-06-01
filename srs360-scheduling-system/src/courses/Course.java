/*
 * Simple Random Sample
 *
 * srs360-scheduling-system
 */

package courses;

/**
 * Contains information about a course like course title,
 * level, number of credit hours, etc., but not information
 * about a specific section like who teaches it. Courses are
 * immutable.<br>
 * <br>
 * <b>Invariants:</b>
 * <ul>
 * <li>getTitle() != null</li>
 * <li>getID() != null</li>
 * <li>getCredits() >= 0</li>
 * </ul>
 * 
 * @author Jonathan Caddey
 * @version May 30, 2011: added equals, hashcode, and
 *          toString.
 * @version May 20, 2011: combined my_curriculum_code with
 *          my_level to be expressed by my_id.
 * @version May 19, 2011: added credits field (thank you
 *          Steven Cozart for pointing the need out.)
 * @version May 13, 2011: file created.
 */
public class Course
{
  /**
   * Example: "TCSS360".
   */
  private final String my_id;

  /**
   * The name of the course, as it appears on the schedule.
   * Example: "INTR OBJ-ORIENT PRG".
   */
  private final String my_title;

  /**
   * The number of credits for the course.
   */
  private final int my_credits;

  /**
   * Creates a Course. For example, in
   * "TCSS360 SOFTWARE DEV & QA," "TCSS360" is the course
   * ID, and "SOFTWARE DEV & QA" is the title.
   * 
   * @param the_id the unique identifier for the course.
   * @param the_title the title of the course.
   * @param the_credits the number of credit hours the
   *          course is worth.
   * @throws IllegalArgumentException if the_id or the_title
   *           are null, or if the_credits is negative.
   */
  public Course(final String the_id,
                final String the_title,
                final int the_credits)
    throws IllegalArgumentException
  {
    if (the_id == null)
    {
      throw new IllegalArgumentException(
        "the_id must not be null");
    }
    if (the_title == null)
    {
      throw new IllegalArgumentException(
        "the_title must not be null");
    }
    if (the_credits < 0)
    {
      throw new IllegalArgumentException(
        "the credits must be positive");
    }
    my_id = the_id;
    my_title = the_title;
    my_credits = the_credits;
  }

  /**
   * @return A unique identifier for the Course. Example:
   *         "TCSS360".
   */
  public String getID()
  {
    return my_id;
  }

  /**
   * @return the descriptive title of the Course, as it
   *         appears on the Schedule.
   */
  public String getTitle()
  {
    return my_title;
  }

  /**
   * @return the credit hours the course is worth.
   */
  public int getCredits()
  {
    return my_credits;
  }

  /**
   * {@inheritDoc}
   */
  public boolean equals(final Object the_other)
  {
    boolean to_return = the_other == this;
    if (!to_return && the_other != null &&
        the_other.getClass() == getClass())
    {
      final Course other_course = (Course) the_other;
      to_return =
          getID().equals(other_course.getID()) &&
              getTitle().equals(other_course.getTitle()) &&
              getCredits() == other_course.getCredits();
    }
    return to_return;
  }

  /**
   * {@inheritDoc}
   */
  public int hashCode()
  {
    return my_id.hashCode() + my_title.hashCode() +
           my_credits;
  }

  /**
   * Returns a String containing the course ID, title, and
   * credit hours.
   * 
   * @return a String representation of this Course.
   */
  public String toString()
  {
    return getID() + " " + getTitle() + " " + getCredits();

  }

}
