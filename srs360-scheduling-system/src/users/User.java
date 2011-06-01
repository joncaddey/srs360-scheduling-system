/*
 * Simple Random Sample
 * 
 * srs360-scheduling-system
 */

package users;

import java.util.Collection;

import courses.Course;
import courses.DaySlot;
import courses.Schedule;
import courses.Section;

/**
 * Represents a user of the Scheduling System. <br>
 * <b>Invariants:</b>
 * <ul>
 * <li>name != null</li>
 * <li>user name != null</li>
 * <li>password != null</li>
 * </ul>
 * 
 * @author David
 * @author Jonathan
 * @version May 31, 2011: modified getAdvisorFeedback
 *          signature.
 * @version May 27, 2011
 */
public class User
{
  private final String my_name;
  private final String my_password;
  private final StudentPreferences my_stud_prefs;
  private final InstructorPreferences my_inst_prefs;
  private final AdvisorPreferences my_adv_prefs;
  private final boolean is_scheduler;

  /**
   * Constructs a unique user of the scheduling system.
   * 
   * @param the_name The user's name
   * @param the_user_ID The user's system name
   * @param the_password The user's system password
   * @param the_student The user's student status (T/F)
   * @param the_instructor The user's instructor status
   *          (T/F)
   * @param the_advisor The user's advisor status (T/F)
   * @param the_scheduler The user's scheduler status (T/F)
   * @throws IllegalArgumentException if name, user name, or
   *           password == null
   */
  public User(final String the_name,
              final String the_password,
              final StudentPreferences the_stud_prefs,
              final InstructorPreferences the_inst_prefs,
              final AdvisorPreferences the_adv_prefs,
              final boolean the_scheduler)
    throws IllegalArgumentException
  {
    if (the_name == null)
    {
      throw new IllegalArgumentException(
        "name cannot be null");
    }

    if (the_password == null)
    {
      throw new IllegalArgumentException(
        "password cannot be null");
    }
    my_name = the_name;
    my_password = the_password;
    my_stud_prefs = the_stud_prefs;
    my_inst_prefs = the_inst_prefs;
    my_adv_prefs = the_adv_prefs;
    is_scheduler = the_scheduler;
  }

  /**
   * Authenticates a user with his password. <br>
   * <b>Preconditions:</b>
   * <ul>
   * <li>the password is not null</li>
   * </ul>
   * <b>Postconditions:</b>
   * <ul>
   * <li>the user's authentication status is not null</li>
   * </ul>
   * 
   * @param the_password The user's password
   * @return The user's authentication status
   * @throws IllegalArgumentException if password == null
   */
  public boolean authenticate(final String the_password)
      throws IllegalArgumentException
  {
    if (the_password == null)
    {
      throw new IllegalArgumentException(
        "password cannot be null");
    }
    return my_password.equals(the_password);
  }

  public String getName()
  {
    return my_name;
  }

  /**
   * Returns the Student role of the User <br>
   * <b>Preconditions:</b>
   * <ul>
   * <li>none</li>
   * </ul>
   * <b>Postconditions:</b>
   * <ul>
   * <li>the role is not null</li>
   * </ul>
   * 
   * @return The user's Student role
   */
  public boolean isStudent()
  {
    return my_stud_prefs != null;
  }

  /**
   * Returns the Instructor role of the User <br>
   * <b>Preconditions:</b>
   * <ul>
   * <li>none</li>
   * </ul>
   * <b>Postconditions:</b>
   * <ul>
   * <li>the role is not null</li>
   * </ul>
   * 
   * @return The user's Instructor role
   */
  public boolean isInstructor()
  {
    return my_inst_prefs != null;
  }

  /**
   * Returns the Advisor role of the User <br>
   * <b>Preconditions:</b>
   * <ul>
   * <li>none</li>
   * </ul>
   * <b>Postconditions:</b>
   * <ul>
   * <li>the role is not null</li>
   * </ul>
   * 
   * @return The user's Advisor role
   */
  public boolean isAdvisor()
  {
    return my_adv_prefs != null;
  }

  /**
   * Returns the Scheduler role of the User <br>
   * <b>Preconditions:</b>
   * <ul>
   * <li>none</li>
   * </ul>
   * <b>Postconditions:</b>
   * <ul>
   * <li>the role is not null</li>
   * </ul>
   * 
   * @return The user's Scheduler role
   */
  public boolean isScheduler()
  {
    return is_scheduler;
  }

  /**
   * Gets day and time feedback from a student regarding
   * when he can be on campus for the courses he wants to
   * take. <br>
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
   * 
   * @param the_schedule A schedule of courses
   * @param the_dayslot_collection The collection of
   *          dayslots
   * @return The feedback collection of days and times
   */
  public Collection<StudentFeedbackSummary> getStudentFeedback(
      final Schedule the_schedule,
      final Collection<DaySlot> the_dayslot_collection)
  {
    return my_stud_prefs.getStudentFeedback(the_schedule,
        the_dayslot_collection);
  }

  /**
   * Returns a collection of sections the advisor wants on
   * the schedule that it does not presently have. <br>
   * <b>Preconditions:</b>
   * <ul>
   * <li>the schedule is not null</li>
   * </ul>
   * <b>Postconditions:</b>
   * <ul>
   * <li>none</li>
   * </ul>
   * 
   * @param the_schedule The schedule of courses
   * @return A collection of missing sections
   */
  public AdvisorFeedback getAdvisorFeedback(
      final Schedule the_schedule)
  {
    return new AdvisorFeedback(
      my_adv_prefs.getAdvisorFeedback(the_schedule), this);
  }

  /**
   * This method compares every course/day/time assigned to
   * this instructor with the courses/days/times he wants to
   * teach and returns a collection of course sections that
   * do not match. <br>
   * <b>Preconditions:</b>
   * <ul>
   * <li>the schedule != null</li>
   * <li>the instructor != null</li>
   * </ul>
   * <b>Postconditions:</b>
   * <ul>
   * <li>the collection of unwanted sections != null</li>
   * </ul>
   * 
   * @param the_schedule The schedule of courses
   * @param the_instructor The instructor for whom the
   *          collection of unwanted sections is prepared
   * @return The collection of unwanted sections
   */
  public Collection<Section> getInstructorFeedback(
      final Schedule the_schedule, final User the_instructor)
  {
    return my_inst_prefs.getInstructorFeedback(
        the_schedule, the_instructor);
  }

}
