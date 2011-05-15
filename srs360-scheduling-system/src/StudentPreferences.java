import java.util.ArrayList;
import java.util.List;

/**
 * Simple Random Sample
 * 
 * TCSS 360 Dr. Tenenberg
 * 
 * srs360-scheduling-system
 */

public class StudentPreferences extends UserPreferences
{
  private List<Day> my_preferred_days;
  
  private TimePreference my_preferred_time;


  public void setTimePreference(TimePreference the_preferred_time)      
  {
    my_preferred_time = the_preferred_time;
  }

  public TimePreference getTimePreference()
  {
    return my_preferred_time;
  }
  
  public void setPreferredDays(String the_preferred_days)
  {
    my_preferred_days = the_preferred_days;
  }

  public String getPreferredDays()
  {
    return my_preferred_days;
  }

}
