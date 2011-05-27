package users;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import courses.Day;
import courses.GeneralTime;
import courses.Section;

/**
 * Simple Random Sample
 * 
 * TCSS 360 Dr. Tenenberg
 * 
 * srs360-scheduling-system
 */  
     
public class InstructorPreferences
{
  private List<Section> my_preferred_sections;
  
  private List<Day> my_preferred_days;
  
  private List<GeneralTime> my_preferred_general_times;
  
  private int my_max_credit_hours;
  
  public InstructorPreferences()
  {
    my_preferred_sections = new ArrayList<Section>();
    my_preferred_days = new ArrayList<Day>();
    my_preferred_general_times = new ArrayList<GeneralTime>();
  }
  public void addSection(Section the_section)
  {
    my_preferred_sections.add(the_section);
  }
  
  public void removeSection(Section the_section)
  {
    my_preferred_sections.remove(the_section);
  }
  
  public List<Section> getPreferredSections()
  {
    return my_preferred_sections;
  }
  
  public void addDay(Day day)
  {
    my_preferred_days.add(day);
  }
  
  public void removeDay(Day day)
  {
    my_preferred_days.remove(day);
  }

  public List<Day> getPreferredDays()
  {
    return my_preferred_days;
  }
  
  public void addTime(GeneralTime the_general_time)      
  {
    my_preferred_general_times.add(the_general_time);
  }
  
  public void removeTime(GeneralTime the_general_time)      
  {
    my_preferred_general_times.remove(the_general_time);
  }

  public List<GeneralTime> getPreferredGeneralTimes()
  {
    return my_preferred_general_times;
  }
  
  public void setMaxCreditHours(int the_max_credit_hours)
  {
    my_max_credit_hours = the_max_credit_hours;
  }
  
  public int getMaxCreditHours()
  {
    return my_max_credit_hours;
  }
  
}
