/*
 * Simple Random Sample
 * 
 * TCSS 360 Dr. Tenenberg
 * 
 * srs360-scheduling-system
 */

import java.util.Collection;

/**
 * Sections represent actual course offerings. A Section has
 * an instructor to teach it as well as a time when it is
 * taught, whereas a Course does not. Sections are
 * immutable.<br>
 * <br>
 * <b>Invariants:</b>
 * <ul>
 * <li>invariant 1</li>
 * </ul>
 * 
 * @author Jonathan Caddey
 * @version May 13, 2011
 */
public class Section
{
  /**
   * The Course this is a Section of.
   */
  private final Course my_course;

  /**
   * The User who is scheduled to teach.
   */
  private final User my_instructor;

  // TODO stuff like timeslots.

  public Section(final Course the_course,
                 final User the_instructor)
    throws IllegalArgumentException
  // TODO must make sure the user has an
  // instructorpreferences.
  {
    if (the_course == null)
    {
      throw new IllegalArgumentException(
        "the_course must not be null");
    }
    if (the_instructor == null)
    {
      throw new IllegalArgumentException(
        "the_instructor must not be null");
    }

    my_course = the_course;
    my_instructor = the_instructor;
  }

  /**
   * <b>Preconditions:</b> none.<br>
   * <b>Postconditions:</b>
   * <ul>
   * <li>does not return null</li>
   * </ul>
   * 
   * @return which Course this is a Section of.
   */
  public Course getCourse()
  {
    return my_course;
  }

  /**
   * Returns who is scheduled to teach the Section. <br>
   * <br>
   * <b>Preconditions:</b> none.<br>
   * <b>Postconditions:</b>
   * <ul>
   * <li>does not return null</li>
   * </ul>
   * 
   * @return a User who is also an Instructor.
   */
  public User getInstructor()
  {
    return my_instructor;
  }

  // TODO should these methods be here?
  public GeneralTime getGeneralTime()
  {
    return null;
  }

  public Collection<Day> getDays()
  {
    return null;
  }

}
