import java.util.ArrayList;
import java.util.List;

public class User
{
  private String my_name;
  private AdvisorPreferences advisor_preferences;
  private StudentPreferences student_preferences;
  private InstructorPreferences instructor_preferences;
  
  public User(String the_name)
  {
    my_name = the_name; 
    advisor_preferences = new AdvisorPreferences();
    student_preferences = new StudentPreferences();
    instructor_preferences = new InstructorPreferences();   
  }
  
  public List<Course> getAdvisorFeedback(Schedule the_schedule)
  {
    List<Course> missingCourseList = new ArrayList<Course>();
    for (Course advisorPreferredCourse:
                advisor_preferences.getPreferredCourses())
    {
      if (!Schedule.contains(advisorPreferredCourse))
      {
        missingCourseList.add(advisorPreferredCourse);
      }
    }
    return missingCourseList;
  }
  
}
