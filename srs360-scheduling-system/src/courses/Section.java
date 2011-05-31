/*
 * Simple Random Sample
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
   * The start Time for the Section.
   */
  private final Time my_start_time;
  
  /**
   * The end Time for the Section.
   */
  private final Time my_end_time;
  
  /**
   * The general time (morning/evening) for this section.
   */
  private final GeneralTime my_general_time;
  
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
                 final GeneralTime the_time)
    throws IllegalArgumentException
  {
    if (the_course == null)
    {
      throw new IllegalArgumentException(
        "the_course must not be null");
    }
    if ( the_instructor != null &&
       (!the_instructor.isInstructor()))
    {
      throw new IllegalArgumentException(
        "the_instructor must be in the instructor role");
    }
    my_course = the_course;
    my_instructor = the_instructor;
    my_time_slot = the_time_slot;
    my_start_time = the_time_slot.getStart();
    my_end_time = the_time_slot.getEnd();
    my_general_time = the_time;                                               
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

  /**
   * Returns the general time for this section.
   * <br>
   * <b>Preconditions:</b>
   * <ul>
   * <li>none</li>
   * </ul>
   * <b>Postconditions:</b>
   * <ul>
   * <li>the returned general time is not null</li>
   * </ul>
   * @return The general time for this section
   */
  public GeneralTime getGeneralTime()
  {
    return my_general_time;
  }

  /**
   * Returns the days this section meets.
   * <br>
   * <b>Preconditions:</b>
   * <ul>
   * <li>none</li>
   * </ul>
   * <b>Postconditions:</b>
   * <ul>
   * <li>The returned days is not null.</li>
   * </ul>
   * @return The days this section meets
   */
  public Collection<Day> getDays()
  {
    return my_time_slot.getDays();
  }
  
  /**
   * Returns the start time for this section.
   * <br>
   * <b>Preconditions:</b>
   * <ul>
   * <li>none</li>
   * </ul>
   * <b>Postconditions:</b>
   * <ul>
   * <li>The returned start time is not null.</li>
   * </ul>
   * @return The start time for this section
   */
  public Time getStartTime()
  {
    return my_time_slot.getStart();
  }
  
  /**
   * Returns the end time for this section.
   * <br>
   * <b>Preconditions:</b>
   * <ul>
   * <li>none</li>
   * </ul>
   * <b>Postconditions:</b>
   * <ul>
   * <li>The returned end time is not null.</li>
   * </ul>
   * @return The end time for this section
   */
  public Time getEndTime()
  {
    return my_time_slot.getEnd();
  }

}
