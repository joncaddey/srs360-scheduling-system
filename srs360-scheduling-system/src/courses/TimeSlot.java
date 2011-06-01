/*
 * Simple Random Sample
 * 
 * srs360-scheduling-system
 */
package courses;

import java.util.Collection;
import java.util.Collections;

/**
 * Represents a combination of Days and a duration of time
 * when a Section can meet. TimeSlots are immutable. <br>
 * <br>
 * <b>Invariants:</b>
 * <ul>
 * <li>getDays() != null</li>
 * <li>!getDays().isEmpty()</li>
 * <li>getStart() != null</li>
 * <li>getEnd() != null</li>
 * </ul>
 * 
 * @author Jonathan Caddey
 * @version May 19, 2011: Class created, accessors and
 *          overlaps fully documented and implemented.
 */
public class TimeSlot
/*
 * No field should contain null. Section can worry about
 * TBA.
 */
{

  /**
   * The days this TimeSlot meets on.
   */
  private final Collection<Day> my_days;

  /**
   * When I start.
   */
  private final Time my_start;

  /**
   * When I end.
   */
  private final Time my_end;

  /**
   * Creates a new TimeSlot.
   * 
   * @param the_days the days when the TimeSlot meets.
   * @param the_start the start time of the TimeSlot.
   * @param the_end the end time of the TimeSlot.
   */
  public TimeSlot(final DaySlot the_days,
                  final Time the_start, final Time the_end)
  {
    my_days =
        Collections.unmodifiableCollection(the_days
            .getDays());
    my_start = the_start;
    my_end = the_end;
  } 

  /**
   * Determines whether a given TimeSlot meets at any time
   * that overlaps with this TimeSlot, within transit_time.
   * Two TimeSlots overlap if it would be impossible for a
   * person to do something at one TimeSlot, wait
   * the_transit_time, and then do something at another
   * TimeSlot. It is necessary for two TimeSlots to share at
   * least one day in common for them to overlap. If the
   * TimeSlots have a Day in common, and the duration of
   * time they meet on that day is not separated by at least
   * the_transit_time, they overlap.
   * 
   * @param the_other the TimeSlot to compare to.
   * @param the_transit_time the time, in minutes, necessary
   *          to wait between durations of time. If the time
   *          is more than an hour, simply use more than 60
   *          minutes.
   * @return whether this overlaps with the given TimeSlot.
   * @throws IllegalArgumentException if the_time_slot is
   *           null or the_transit_time is negative.
   */
  public boolean overlaps(final TimeSlot the_other,
      final int the_transit_time)
      throws IllegalArgumentException
  {
    if (null == the_other)
    {
      throw new IllegalArgumentException(
        "the_other must not be null");
    }
    if (the_transit_time < 0)
    {
      throw new IllegalArgumentException(
        "the transit time must be non-negative");
    }
    final boolean overlap;

    if (this.equals(the_other))
    {
      overlap = true;

    }
    else
    {
      final Time other_later_end =
          Time.getLaterTime(the_other.getEnd(),
              the_transit_time);
      final Time later_end =
          Time.getLaterTime(getEnd(), the_transit_time);

      overlap =
      // my start is in the duration of the_other
          (the_other.getStart().compareTo(my_start) < 0 && my_start
              .compareTo(other_later_end) < 0) ||

          // my_end is in the duration of the_other
              (the_other.getStart().compareTo(later_end) < 0 && later_end
                  .compareTo(other_later_end) < 0);
    }

    return overlap;
  }

  /**
   * @return the days I meet on.
   */
  public Collection<Day> getDays()
  {
    // returning direct reference because my_days is
    // unmodifiable and its contents are immutable.
    return my_days;
  }

  /**
   * @return when I start.
   */
  public Time getStart()
  {
    return my_start;
  }

  /**
   * @return when I end.
   */
  public Time getEnd()
  {
    return my_end;
  }

}
