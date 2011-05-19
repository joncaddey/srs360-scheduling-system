/*
 * Simple Random Sample
 * 
 * TCSS 360 Dr. Tenenberg
 * 
 * srs360-scheduling-system
 */

/**
 * Contains information about a course like course title,
 * level, number of credit hours, etc., but not information
 * about a specific section like who teaches it. Courses are
 * immutable.<br>
 * <br>
 * <b>Invariants:</b>
 * <ul>
 * <li>the curriculum code and title are not null.</li>
 * <li>getCredits() >= 0</li>
 * </ul>
 * 
 * @author Jonathan Caddey
 * @version May 19, 2011: added credits field (thank you
 *          Steven Cozart for pointing the need out.)
 * @version May 13, 2011: file created.
 */
public class Course
{
  /**
   * Example: "TCSS". No number is included.
   */
  private final String my_curriculum_code;

  /**
   * The number for the course; for example, the 360 in
   * "TCSS 360".
   */
  private final int my_level;

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
   * "TCSS 360 SOFTWARE DEV & QA," "TCSS" is the curriculum
   * code, 360 is the course level, and "SOFTWARE DEV & QA"
   * is the title.
   * 
   * @param the_curriculum_code the curriculum code of the
   *          course.
   * @param the_level the level of the course.
   * @param the_title the title of the course.
   * @param the_credits the number of credit hours the
   *          course is worth.
   * @throws IllegalArgumentException if the_curriculum_code
   *           or the_title are null, or if the_credits is
   *           negative.
   */
  public Course(final String the_curriculum_code,
                final int the_level,
                final String the_title,
                final int the_credits)
    throws IllegalArgumentException
  {
    if (the_curriculum_code == null)
    {
      throw new IllegalArgumentException(
        "the_curriculum_code must not be null");
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
    my_curriculum_code = the_curriculum_code;
    my_level = the_level;
    my_title = the_title;
    my_credits = the_credits;
  }

  /**
   * @return example: the "TCSS" in "TCSS 360."
   */
  public String getCurriculumCode()
  {
    return my_curriculum_code;
  }

  /**
   * @return example: the 360 in "TCSS 360."
   */
  public int getLevel()
  {
    return my_level;
  }

  /**
   * @return the name of the Course, as it appears on the
   *         Schedule.
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

}
