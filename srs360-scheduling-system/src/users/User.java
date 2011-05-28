/*
 * Simple Random Sample
 * 
 * srs360-scheduling-system
 */
package users;

import java.util.Collection;

import courses.Schedule;

/**
 * Represents a user of the Scheduling System.
 * <br>
 * <b>Invariants:</b>
 * <ul>
 * <li> name != null</li>
 * <li> user name != null</li>
 * <li> password != null</li>
 * </ul>
 * 
 * @author David
 * @version May 27, 2011
 */
public class User
{
  private final String my_name;
  private final String my_user_name;
  private final String my_password;
  private final boolean is_student;
  private final boolean is_instructor;
  private final boolean is_advisor;
  private final boolean is_scheduler;
  private final AdvisorPreferences my_adv_prefs;
  private final StudentPreferences my_stud_prefs;
  private final InstructorPreferences my_inst_prefs;
  
 /**
  * Constructs a unique user of the scheduling system.
  * 
  * @param the_name The user's name
  * @param the_user_name The user's system name
  * @param the_password The user's system password
  * @param the_student The user's student status (T/F)
  * @param the_instructor The user's instructor status (T/F)
  * @param the_advisor The user's advisor status (T/F)
  * @param the_scheduler The user's scheduler status (T/F)
  * @throws IllegalArgumentException if name, user name, or
  * password == null
  */
  public User(final String the_name,
              final String the_user_name,
              final String the_password,
              final boolean the_student,
              final boolean the_instructor,
              final boolean the_advisor,
              final boolean the_scheduler)
                             throws IllegalArgumentException
  {
    if (the_name == null)
    {
      throw new IllegalArgumentException
                                    ("name cannot be null");
    }
    my_name = the_name; 
    if (the_user_name == null)
    {
      throw new IllegalArgumentException
                               ("user name cannot be null");
    }
    my_user_name = the_user_name;
    if (the_password == null)
    {
      throw new IllegalArgumentException
                                ("password cannot be null");
    }
    my_password = the_password;
    is_student = the_student;
    is_instructor = the_instructor;
    is_advisor = the_advisor;
    is_scheduler = the_scheduler;
    my_adv_prefs = new AdvisorPreferences();
    my_stud_prefs = new StudentPreferences();
    my_inst_prefs = new InstructorPreferences();   
  }
   
  /**
   * Authenticates a user with his password. 
   * <br>
   * <b>Preconditions:</b>
   * <ul>
   * <li>the password is not null</li>
   * </ul>
   * <b>Postconditions:</b>
   * <ul>
   * <li>the user's authentication status is not null</li>
   * </ul>
   * @param the_password The user's password
   * @return The user's authentication status
   * @throws IllegalArgumentException if password == null
   */
  public boolean authenticate(final String the_password)
                             throws IllegalArgumentException
  {
    if (the_password == null)
    {
      throw new IllegalArgumentException
                                ("password cannot be null");
    }
    return my_password.equals(the_password);
  }
  
  public String getUserName()
  {
    return my_user_name;
  }
  
  public boolean isStudent()
  {
    return is_student;
  }
  
  public boolean isInstructor()
  {
    return is_instructor;
  }
  
  public boolean isAdvisor()
  {
    return is_advisor;
  }
  
  public boolean isScheduler()
  {
    return is_scheduler;
  }
  
  /**
   * Gets day and time feedback from a student regarding
   * when he can be on campus for the courses he wants to
   * take.
   * <br>
   * <b>Preconditions:</b>
   * <ul>
   * <li>the schedule of courses is not null</li>
   * <li>a collection of dayslots (MW, TR, etc) when courses
   * are offered is not null</li>
   * </ul>
   * <b>Postconditions:</b>
   * <ul>
   * <li>the returned feedback collection is not null</li>
   * </ul>
   * @param the_schedule A schedule of courses
   * @param the_dayslot_collection The collection of dayslots
   * @return The feedback collection of days and times
   */
  public Collection<StudentFeedbackSummary> getStudentFeedback
          (final Schedule the_schedule,
           final Collection<DaySlot> the_dayslot_collection)
  {
    return my_stud_prefs.getStudentFeedback(the_schedule,
                                    the_dayslot_collection);
  }
  
}
