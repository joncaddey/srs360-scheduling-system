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
   * Compares preferred sections with available sections
   * and returns a list of those that are missing.
   * 
   * <br><br><b>Preconditions:</b>
   * <ul><li>pre1: a valid Schedule</li>
   * </ul>
   * <b>Postconditions:</b>
   * <ul><li>post1: a list of missing sections</li>
   * </ul>
   * @param the_schedule The Schedule of Courses
   * @return A List of missing Sections
   */
  public Collection<Section> getAdvisorFeedback
                                     (Schedule the_schedule)
  {
    List<Section> preferred_sections =
                 advisor_preferences.getPreferredSections();
    Collection<Section> available_sections =
                                 the_schedule.getSections();
    List<Section> missing_sections =
                                   new ArrayList<Section>();
    for(Section each_preferred_section : preferred_sections)
    {
      if(!available_sections.contains(each_preferred_section))
      {
        missing_sections.add(each_preferred_section);
      }
    }
    return missing_sections;
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
   * feedbacks, from a student, each of which has a course
   * the student wants to take and the day and time he wants
   * to take it.</b>
   * <ul>
   * <li>TODO</li>
   * </ul>
   * @param the_schedule The Schedule
   * @return The Collection of student feedbacks
   */
  public Collection<StudentFeedback> getStudentFeedback
                               (final Schedule the_schedule)
  {
    Collection<StudentFeedback> student_feedback_collection
                         = new ArrayList<StudentFeedback>();
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
              StudentFeedback student_feedback =
                new StudentFeedback(each_course,each_day,
                                                 each_time);            
              student_feedback_collection.add
                                         (student_feedback);
            }
          }
        }     
      }
    } 
    return student_feedback_collection;   
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
    List<Course> preferred_courses =
               instructor_preferences.getPreferredCourses();
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
