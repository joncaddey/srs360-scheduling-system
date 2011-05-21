import java.util.ArrayList;
import java.util.List;

/**
 * Simple Random Sample
 * 
 * TCSS 360 Dr. Tenenberg
 * 
 * srs360-scheduling-system
 */

/**
 * Users use this class to express their general time
 * preferences. <br>
 * 
 * @author Jonathan Caddey
 * @author David Liddington(removed EITHER, changed name)
 * @version May 13, 2011
 */
public enum GeneralTime
{
  /**
   * Prefers attending in the morning.
   */
  MORNING,

  /**
   * Prefers attending in the evening.
   */
  EVENING;
  
  public static List<GeneralTime> getAllGeneralTimes()
  {
    List<GeneralTime> times = new ArrayList<GeneralTime>();
    times.add(GeneralTime.MORNING);
    times.add(GeneralTime.EVENING);
    
    return times;  
  }
  
}
