import java.util.Collection;

/**
 * Simple Random Sample
 * 
 * TCSS 360 Dr. Tenenberg
 * 
 * srs360-scheduling-system
 */

/**
 * A BusinessRule checks a Schedule to make sure the Schedule adheres to the
 * BusinessRule. <br>
 * <br>
 * <b>Invariants:</b> none<br>
 * 
 * @author Jonathan Caddey
 * @version May 13, 2011
 */
public interface BusinessRule
{

  /**
   * Determines whether the given Schedule satisfies the constraints posed by
   * this BusinessRule. If the constraint is violated, the offending Sections
   * are returned. Otherwise, an empty Collection is returned. <br>
   * <br>
   * <b>Preconditions:</b>
   * <ul>
   * <li>the_schedule is not null</li>
   * </ul>
   * <b>Postconditions:</b>
   * <ul>
   * <li>removing the returned sections from the Schedule would satisfy this
   * constraint.</li>
   * </ul>
   * 
   * @param the_schedule a valid (non-null) Schedule
   * @return the list of Sections of the_schedule which keep this constraint
   *         from being satisfied.
   */
  Collection<Section> getViolations(Schedule the_schedule);
}
