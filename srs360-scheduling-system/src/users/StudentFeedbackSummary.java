/*
 * Simple Random Sample
 * 
 * TCSS 360 Dr. Tenenberg
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
 * @version May 27, 2011: Class created.
 */
public class StudentFeedbackSummary
{

  private final Course my_course;
  private final DaySlot my_day_slot;
  private final GeneralTime my_time;
  private final int my_frequency;

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

  public boolean equals(final Object the_other)
  {
    boolean to_return = the_other == this;
    if (!to_return && the_other != null &&
        the_other.getClass() == getClass())
    {
      StudentFeedbackSummary sfs =
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

  public Course getCourse() {
    return my_course;
  }

  public DaySlot getDaySlot()
  {
    return my_day_slot;
  }

  public int getFrequency()
  {
    return my_frequency;
  }

  public GeneralTime getGeneralTime()
  {
    return my_time;
  }

  public String toString()
  {
    return my_frequency + " students would like " +
           my_course.getID() + " on " +
           my_day_slot.getDays() + " in the " +
           my_time.toString() + ".";
  }
}
