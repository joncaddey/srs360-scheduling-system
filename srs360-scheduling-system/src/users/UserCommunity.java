/*
 * Simple Random Sample
 * 
 * srs360-scheduling-system
 */

package users;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import courses.Catalogue;
import courses.Schedule;

/**
 * 
 * <b>Invariants:</b>
 * <ul>
 * <li>List of users.</li>
 * </ul>
 * 
 * @author Gregory Cloutier
 * @author Jon Caddey (gather feedback implementation)
 * @version 05/16/11 Made class
 * @version 05/18/11 Updated authenticate() and constructor
 *          method.
 * @version 06/01/11 Added javadoc.
 */
public class UserCommunity
{
  /**
   * List of authenticated users. Key is UserID and Value is
   * the User.
   */
  private final Map<String, User> my_authenticated_users;

  /**
   * The Catalogue of courses.
   */
  private final Catalogue my_catalogue;

  /**
   * List of student feedback.
   */
  private List<StudentFeedbackSummary> my_student_feedback;

  private Collection<InstructorFeedback> my_instructor_feedback;
  private Collection<AdvisorFeedback> my_advisor_feedback;

  /**
   * Creates a UserCommunity using the following parameters.
   * 
   * @param the_catalogue The catalogue of courses possibly
   *          offered.
   * @param a_list_of_users List of authenticated users.
   */
  public UserCommunity(final Collection<User>
                                       a_list_of_users,
                       final Catalogue the_catalogue)
  {
    my_catalogue = the_catalogue;
    // Under Construction
    my_authenticated_users = new HashMap<String, User>();
    for (User u : a_list_of_users)
    {
      my_authenticated_users.put(u.getName(), u);
    }
  }

  /**
   * <b>Preconditions:</b>
   * <ul>
   * <li>There is a list of users and passwords associated
   * with them.</li>
   * </ul>
   * <b>Postconditions:</b>
   * <ul>
   * <li>Delivers enabled or disabled access upon
   * authentication</li>
   * </ul>
   * 
   * @param a_user_id the user's ID
   * @param a_password The password correlated with the
   *          user's ID
   * @return True if the password matches ID, false if
   *         otherwise
   */
  public boolean authenticate(final String a_user_id,
      final String a_password)
  {
    boolean is_correct = false;
    if (my_authenticated_users.containsKey(a_user_id))
    {
      is_correct =
          my_authenticated_users.get
        (a_user_id).authenticate(a_password);
    }
    return is_correct;
  }

  /**
   * 
   * Gathers feedback by processing the schedule by
   * iterating over the UserCommunity's list of students.
   * The feedback is then stored and ready to be returned
   * when prompted.
   * 
   * <br>
   * <br>
   * <b>Preconditions:</b>
   * <ul>
   * <li>The schedule has been processed and is nonnull</li>
   * </ul>
   * <b>Postconditions:</b>
   * <ul>
   * <li>Internal data representations of feedback ready to
   * be prompted for.</li>
   * </ul>
   * 
   * @param the_schedule The schedule to be processed.
   * 
   */
  public void gatherFeedback(final Schedule the_schedule)
  {
    my_instructor_feedback =
        new ArrayList<InstructorFeedback>();
    my_advisor_feedback = new ArrayList<AdvisorFeedback>();
    final Map<StudentFeedbackSummary, Integer> sfs_map =
        new HashMap<StudentFeedbackSummary, Integer>();
    for (User user : my_authenticated_users.values())
    {
      // if (user.isInstructor())
      // {
      // my_instructor_feedback.add(user
      // .getInstructorFeedback(the_schedule));
      // }
      if (user.isAdvisor())
      {
        final AdvisorFeedback feedback =
            user.getAdvisorFeedback(the_schedule);
        if (!feedback.getCourses().isEmpty())
        {
          my_advisor_feedback.add(feedback);
        }
      }
      if (user.isStudent())
      {
        final Collection<StudentFeedbackSummary> sfs =
            user.getStudentFeedback(the_schedule,
                my_catalogue.getDaySlots());

        // if students actually have something to say
        if (!sfs.isEmpty())
        {
          for (StudentFeedbackSummary s : sfs)
          {
            if (sfs_map.containsKey(s))
            {
              sfs_map.put(s, sfs_map.get(s) + 1);
            }
            else
            {
              sfs_map.put(s, 1);
            }
          }
        }
      }
    }

    // make a list of studentFeedbackSummaries.
    my_student_feedback =
        new ArrayList<StudentFeedbackSummary>(
          sfs_map.size());
    for (StudentFeedbackSummary sfs : sfs_map.keySet())
    {
      my_student_feedback.add(new StudentFeedbackSummary(
        sfs.getCourse(), sfs.getDaySlot(), sfs
            .getGeneralTime(), sfs_map.get(sfs)));
    }
    Collections.sort(my_student_feedback,
        new Comparator<StudentFeedbackSummary>()
        {

          @Override
          public int compare(StudentFeedbackSummary the_o1,
              StudentFeedbackSummary the_o2)
          {

            return the_o2.getFrequency() -
                   the_o1.getFrequency();
          }

        });

  }

  /**
   * @return The Advisor feedback on the schedule.
   */
  public Collection<AdvisorFeedback> getAdvisorFeedback()
  {
    return new ArrayList<AdvisorFeedback>(
      my_advisor_feedback);

  }

  /**
   * @return The instructor feedback on the schedule.
   */
  public Collection<InstructorFeedback>
  getInstructorFeedback()
  {
    return new ArrayList<InstructorFeedback>(
      my_instructor_feedback);

  }

  /**
   * Attempts to return the instructor from the list
   * of users.
   * 
   * @param the_name The instructors name.
   * @return The User representation of the instructor,
   *    null if not found.
   */
  public User getInstructor(final String the_name)
  {
    // TODO this is not a good implementation.
    for (User user : my_authenticated_users.values())
    {
      if (user.getName().equals(the_name))
      {
        return user;
      }
    }
    return null;
  }

  /**
   * @return The student feedback.
   */
  public List<StudentFeedbackSummary> getStudentFeedback()
  {

    return
    Collections.unmodifiableList(my_student_feedback);
  }
}
