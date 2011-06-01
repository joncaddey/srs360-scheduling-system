/*
 * Simple Random Sample
 * 
 * srs360-scheduling-system
 */

package users;

import courses.Course;
import courses.DaySlot;
import courses.GeneralTime;

/**
 * Contains a frequency of how many students would like to
 * take a Course at a GeneralTime on certain Days. Instances
 * are immutable.<br>
 * <br>
 * <b>Invariants: </b>
 * <ul>
 * <li>TODO invariant1</li>
 * </ul>
 * 
 * @author Jonathan Caddey
 * @author Greg Cloutier (added JavaDoc)
 * @version May 27, 2011: Class created.
 * @version June 1, 2011: added JavaDoc.
 */
public class StudentFeedbackSummary
{
  /**
   * The course.
   */
  private final Course my_course;
  /**
   * The days instructed (or should be instructed).
   */
  private final DaySlot my_day_slot;
  /**
   * The general time of the course.
   */
  private final GeneralTime my_time;
  /**
   * The number of students who have this feedback.
   */
  private final int my_frequency;

  /**
   * Constructs the StudentFeedbackSummary.
   * 
   * @param the_course The course.
   * @param the_day_slot The days of instruction.
   * @param the_time The general time of this course.
   * @param the_frequency Number of students that have this
   *          same feedback.
   */
  public StudentFeedbackSummary(final Course the_course,
                                final DaySlot the_day_slot,
                                final GeneralTime the_time,
                                final int the_frequency)
  {
    my_course = the_course;
    my_day_slot = the_day_slot;
    my_time = the_time;
    my_frequency = the_frequency;
  }

  /**
   * Determines whether or not the feedback is the same as
   * the_other object.
   * 
   * @param the_other The object to be compared.
   * @return True if the objects are equal, false if
   *         otherwise.
   */
  public boolean equals(final Object the_other)
  {
    boolean to_return = the_other == this;
    if (!to_return && the_other != null &&
        the_other.getClass() == getClass())
    {
      final StudentFeedbackSummary sfs =
          (StudentFeedbackSummary) the_other;
      to_return =
          sfs.my_course.equals(my_course) &&
              sfs.my_day_slot.equals(my_day_slot) &&
              sfs.my_frequency == my_frequency;
    }

    return to_return;

  }

  @Override
  public int hashCode()
  {
    return my_course.hashCode() + my_day_slot.hashCode() +
           my_frequency;
  }

  /**
   * Returns the course of this object.
   * 
   * @return The course.
   */
  public Course getCourse()
  {
    return my_course;
  }

  /**
   * Returns the dayslot of this object.
   *
   * @return The dayslot.
   */
  public DaySlot getDaySlot()
  {
    return my_day_slot;
  }

  /**
   * Returns the frequency of this object.
   *
   * @return The frequency.
   */
  public int getFrequency()
  {
    return my_frequency;
  }

  /**
   * Returns the general time of this object.
   *
   * @return The general time.
   */
  public GeneralTime getGeneralTime()
  {
    return my_time;
  }

  /**
   * Returns the string representation of the feedback.
   * 
   * @return A String representation of the feed back.
   */
  public String toString()
  {
    return my_frequency + " students would like " +
           my_course.getID() + " on " +
           my_day_slot.getDays() + " in the " +
           my_time.toString() + ".";
  }
}
