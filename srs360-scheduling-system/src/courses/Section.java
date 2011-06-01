/*
 * Simple Random Sample
 * 
 * srs360-scheduling-system
 */

package courses;

import java.util.ArrayList;
import java.util.Collection;

import users.User;

/**
 * Sections represent actual course offerings. A Section has
 * an instructor to teach it as well as a time when it is
 * taught, whereas a Course does not. Sections are
 * immutable. Certain fields can be null to indicate
 * TBA--see constructor.<br>
 * <br>
 * <b>Invariants:</b>
 * <ul>
 * <li>none</li>
 * </ul>
 * 
 * @author Jonathan Caddey
 * @author David Liddington modified constructor
 * @author Greg Cloutier (added JavaDoc)
 * @version May 31, 2011: Jon eliminated TimeSlot fields.
 * @version May 13, 2011
 * @version June 1, 2011: added java doc
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
   * The days which the section is taught.
   */
  private final DaySlot my_day_slot;
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
   * Constructs a Section.
   * 
   * @param the_course The course
   * @param the_instructor The user who teaches this section
   * @param the_day_slot The days of instruction
   * @param the_general_time The general time of this
   *          section (morning or evening)
   * @param the_start_time The time the section begins.
   * @param the_end_time The time the section ends.
   */
  public Section(final Course the_course,
                 final User the_instructor,
                 final DaySlot the_day_slot,
                 final GeneralTime the_general_time,
                 final Time the_start_time,
                 final Time the_end_time)
  {
    my_course = the_course;
    my_instructor = the_instructor;
    my_day_slot = the_day_slot;
    my_general_time = the_general_time;
    my_start_time = the_start_time;
    my_end_time = the_end_time;

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
   * Returns the general time for this section. <br>
   * <b>Preconditions:</b>
   * <ul>
   * <li>none</li>
   * </ul>
   * <b>Postconditions:</b>
   * <ul>
   * <li>the returned general time is not null</li>
   * </ul>
   * 
   * @return The general time for this section
   */
  public GeneralTime getGeneralTime()
  {
    return my_general_time;
  }

  /**
   * Returns the days this section meets. <br>
   * <b>Preconditions:</b>
   * <ul>
   * <li>none</li>
   * </ul>
   * <b>Postconditions:</b>
   * <ul>
   * <li>The returned days is not null.</li>
   * </ul>
   * 
   * @return The days this section meets
   */
  public Collection<Day> getDays()
  {
    if (my_day_slot == null) {
      return new ArrayList<Day>();
    }
    return my_day_slot.getDays();
  }

  /**
   * Returns the start time for this section. <br>
   * <b>Preconditions:</b>
   * <ul>
   * <li>none</li>
   * </ul>
   * <b>Postconditions:</b>
   * <ul>
   * <li>The returned start time is not null.</li>
   * </ul>
   * 
   * @return The start time for this section
   */
  public Time getStartTime()
  {
    return my_start_time;
  }

  /**
   * Returns the end time for this section. <br>
   * <b>Preconditions:</b>
   * <ul>
   * <li>none</li>
   * </ul>
   * <b>Postconditions:</b>
   * <ul>
   * <li>The returned end time is not null.</li>
   * </ul>
   * 
   * @return The end time for this section
   */
  public Time getEndTime()
  {
    return my_end_time;
  }

}
