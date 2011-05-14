/**
 * Simple Random Sample
 * 
 * TCSS 360 Dr. Tenenberg
 * 
 * srs360-scheduling-system
 */

/**
 * Contains information about a course like course title,
 * level, etc., but not information about a specific section
 * like who teaches it. Courses are immutable.<br>
 * <br>
 * <b>Invariants:</b>
 * <ul>
 * <li>invariant1</li>
 * </ul>
 * 
 * @author Jonathan Caddey
 * @version May 13, 2011
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
   * Creates a Course. For example, in
   * "TCSS 360 SOFTWARE DEV & QA" "TCSS" is the curriculum
   * code, 360 is the course level, and "SOFTWARE DEV & QA"
   * is the title.
   * 
   * @param the_curriculum_code the curriculum code of the
   *          course.
   * @param the_level the level of the course.
   * @param the_title the title of the course.
   */
  public Course(final String the_curriculum_code,
                final int the_level, final String the_title)
  {
    my_curriculum_code = the_curriculum_code;
    my_level = the_level;
    my_title = the_title;
  }

}
