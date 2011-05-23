import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Simple Random Sample
 * 
 * TCSS 360 Dr. Tenenberg
 * 
 * srs360-scheduling-system 
 */
public class StudentPreferences
{
  private List<Course> my_preferred_courses;
  
  private List<Day> my_preferred_days;
  
  private List<GeneralTime> my_preferred_general_times;
  
  public StudentPreferences()
  {
    my_preferred_courses = new ArrayList<Course>();
    my_preferred_days = new ArrayList<Day>();
    my_preferred_general_times = new ArrayList<GeneralTime>();
  }
  public void addCourse(Course the_course)
  {
    my_preferred_courses.add(the_course);
  }
  
  public void removeCourse(Course the_course)
  {
    my_preferred_courses.remove(the_course);
  }
  
  public List<Course> getPreferredCourses()
  {
    return my_preferred_courses;
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
  
  public void addTime(GeneralTime the_time)      
  {
    my_preferred_general_times.add(the_time);
  }
  
  public void removeTime(GeneralTime the_time)      
  {
    my_preferred_general_times.remove(the_time);
  }

  public List<GeneralTime> getPreferredGeneralTimes()
  {
    return my_preferred_general_times;
  }

}
