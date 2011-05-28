package users;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import courses.Course;
import courses.Day;
import courses.GeneralTime;
import courses.Schedule;
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
  
  /**
   * For every course this instructor wants to teach, this
   * method returns the day and time he wants to teach it,
   * if the schedule does not already provide that.
   * <br>
   * <br>
   * <b>Preconditions: the Schedule.</b>
   * <ul>
   * <li>TODO</li>
   * </ul>
   * <b>Postconditions: a Collection of responses, or 
   * feedbacks, from the instructor, each of which has a
   * course the instructor wants to teach and the day and
   * time he wants to teach it.</b>
   * <ul>
   * <li>TODO</li>
   * </ul>
   * @param the_schedule The Schedule
   * @return The Collection of instructor feedbacks
   */     
  public Collection<InstructorFeedback> getInstructorFeedback
                               (final Schedule the_schedule)
  {
    Collection<InstructorFeedback> instructor_feedback_collection
                      = new ArrayList<InstructorFeedback>();
    List<Section> preferred_sections =
               instructor_preferences.getPreferredSections();
    List<Day> preferred_days =
                  instructor_preferences.getPreferredDays();
    List<GeneralTime> preferred_times =
          instructor_preferences.getPreferredGeneralTimes();
 
    for(Course each_course : preferred_courses)
    {
      if(!the_schedule.hasSection(each_course,
                                  preferred_days,
                                  preferred_times))
      {
        for(Day each_day : Day.getAllDays())
        {
          for(GeneralTime each_time :
                           GeneralTime.getAllGeneralTimes())
          {
            if(preferred_days.contains(each_day) &&
               preferred_times.contains(each_time))
            {
              InstructorFeedback instructor_feedback =
              new InstructorFeedback(each_course, each_day,
                                                 each_time);            
              instructor_feedback_collection.add
                                      (instructor_feedback);
            }
          }
        }     
      }
    } 
    return instructor_feedback_collection;   
  }
  
}
