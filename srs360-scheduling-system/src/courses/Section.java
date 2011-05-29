/*
 * Simple Random Sample
 * 
 * TCSS 360 Dr. Tenenberg
 * 
 * srs360-scheduling-system
 */

package courses;

import java.util.Collection;

import users.User;

/**
 * Sections represent actual course offerings. A Section has
 * an instructor to teach it as well as a time when it is
 * taught, whereas a Course does not. Sections are
 * immutable.<br>
 * <br>
 * <b>Invariants:</b>
 * <ul>
 * <li>none</li>
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

  /**
   * When this Section is offered.
   */
  private final TimeSlot my_time_slot;

  /**
   * Creates a Section. Certain arguments can be null if
   * they are to be determined.
   * 
   * @param the_course what this is a Section of.
   * @param the_instructor who teaches this--may be null if
   *          TBA.
   * @param the_time_slot when this is taught--may be null
   *          if TBA.
   * @param the_catalogue knows the morning/evening cutoff
   *          time for reporting getGeneralTime().
   * @throws IllegalArgumentException if the_course is null,
   *           or if !the_instructor.isInstructor()
   */
  public Section(final Course the_course,
                 final User the_instructor,
                 final TimeSlot the_time_slot,
                 Catalogue the_catalogue)
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
    // probably need:
    // my_general_time = the_catalogue.getGeneralTime(the_time_slot)
    // don't need my_catalogue field
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

  // TODO should these methods be here?  probably.
  public GeneralTime getGeneralTime()
  {
    return my_general_time;
  }

  public Collection<Day> getDays()
  {
    return null;
  }

}
