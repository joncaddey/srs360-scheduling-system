/**
 * Simple Random Sample
 * 
 * TCSS 360 Dr. Tenenberg
 * 
 * srs360-scheduling-system
 */
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Creates a User of the Scheduling System.
 * 
 * <br><br><b>Invariants:</b>
 * <ul><li>invariant1</li>
 * </ul>
 * 
 * @author David
 * @version May 16, 2011
 */
public class User
{
  private final String my_name;
  private final String my_user_name;
  private final String my_password;
  private final boolean my_is_student;
  private final boolean my_is_instructor;
  private final boolean my_is_advisor;
  private final boolean my_is_scheduler;
  private AdvisorPreferences advisor_preferences;
  private StudentPreferences student_preferences;
  private InstructorPreferences instructor_preferences;
  
  /**
   * Creates a User with the given name.
   * 
   * @param the_name The user name.
   * @throws IllegalArgumentException if the name is null.
   */
  public User(final String the_name,
              final String the_user_name,
              final String the_password,
              final boolean the_is_student,
              final boolean the_is_instructor,
              final boolean the_is_advisor,
              final boolean the_is_scheduler)
                             throws IllegalArgumentException
  {
    my_name = the_name; 
    my_user_name = the_user_name;
    my_password = the_password;
    my_is_student = the_is_student;
    my_is_instructor = the_is_instructor;
    my_is_advisor = the_is_advisor;
    my_is_scheduler = the_is_scheduler;
    advisor_preferences = new AdvisorPreferences();
    student_preferences = new StudentPreferences();
    instructor_preferences = new InstructorPreferences();   
  }
   
  public boolean authenticate(String the_password)
  {
    return my_password.equals(the_password);
  }
  
  public String getUserName()
  {
    return my_user_name;
  }
  
  public boolean isStudent()
  {
    return my_is_student;
  }
  
  public boolean isInstructor()
  {
    return my_is_instructor;
  }
  
  public boolean isAdvisor()
  {
    return my_is_advisor;
  }
  
  public boolean isScheduler()
  {
    return my_is_scheduler;
  }
  
  /**
   * <br><br><b>Preconditions:</b>
   * <ul><li>pre1: a valid Schedule</li>
   * </ul>
   * <b>Postconditions:</b>
   * <ul><li>post1: a list of missing courses</li>
   * </ul>
   * @param the_schedule The Schedule of Courses
   * @return A List of missing Courses
   */
  public List<Course> getAdvisorFeedback
                                     (Schedule the_schedule)
  {
    List<Course> missingCourseList =
                                    new ArrayList<Course>();
    for (Course advisorPreferredCourse:
                  advisor_preferences.getPreferredCourses())
    {
      if (!the_schedule.hasSection(advisorPreferredCourse))
      {
        missingCourseList.add(advisorPreferredCourse);
      }
    }
    return missingCourseList;
  }
  
  /**
   * For every course this student wants to take, this
   * method returns the day and time he wants to take it, if
   * the schedule does not already provide that.
   * <br>
   * <br>
   * <b>Preconditions: the Schedule.</b>
   * <ul>
   * <li>TODO</li>
   * </ul>
   * <b>Postconditions: a Collection of responses, or 
   * feedbacks, from the student. Each feedback has a course
   * the student wants to take and the day and time he wants
   * to take it.</b>
   * <ul>
   * <li>TODO</li>
   * </ul>
   * @param the_schedule The Schedule
   * @return A Collection of student feedbacks
   */
  public Collection<StudentFeedbackSummary> getStudentFeedback
                               (final Schedule the_schedule)
  {
    Collection<StudentFeedbackSummary> sfs_collection
                  = new ArrayList<StudentFeedbackSummary>();
    List<Course> preferred_courses =
                  student_preferences.getPreferredCourses();
    List<Day> preferred_days =
                     student_preferences.getPreferredDays();
    List<GeneralTime> preferred_times =
             student_preferences.getPreferredGeneralTimes();
 
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
              StudentFeedbackSummary a_new_sfs =
                     new StudentFeedbackSummary(each_course,
                                                each_day,
                                                each_time);            
              sfs_collection.add(a_new_sfs);
            }
          }
        }     
      }
    } 
    return sfs_collection;
    
  }
  
  public List<ArrayList<Course>> getInstructorFeedback
                                     (Schedule the_schedule)
  {
    return null;
  }
   
}
