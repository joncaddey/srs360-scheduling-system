/*
 * Simple Random Sample
 * 
 * TCSS 360 Dr. Tenenberg
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
 * <li>List of users</li>
 * </ul>
 * 
 * @author Gregory Cloutier
 * @version 05/16/11 Made class
 * @version 05/18/11 Updated authenticate() and constructor
 *          method.
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

  private List<StudentFeedbackSummary> my_student_feedback;
  private Collection<InstructorFeedback> my_instructor_feedback;
  private Collection<AdvisorFeedback> my_advisor_feedback;

  /**
   * @param the_catalogue The catalogue of courses possibly
   *          offered.
   * @param a_list_of_users List of authenticated users.
   */
  public UserCommunity(final Collection<User> a_list_of_users,
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
   * @author Gregory Cloutier
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
          my_authenticated_users.get(a_user_id)
              .authenticate(a_password);
    }
    return is_correct;
  }

  /**
   * 
   * TODO add Description
   * 
   * <br>
   * <br>
   * <b>Preconditions:</b>
   * <ul>
   * <li>TODO</li>
   * </ul>
   * <b>Postconditions:</b>
   * <ul>
   * <li>TODO</li>
   * </ul>
   * 
   * @author Jonathan Caddey
   */
  public void gatherFeedback(final Schedule the_schedule)
  {
    my_instructor_feedback =
        new ArrayList<InstructorFeedback>();
    my_advisor_feedback = new ArrayList<AdvisorFeedback>();
    Map<StudentFeedbackSummary, Integer> sfs_map =
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

  public Collection<AdvisorFeedback> getAdvisorFeedback()
  {
    return new ArrayList<AdvisorFeedback>(
      my_advisor_feedback);

  }

  public Collection<InstructorFeedback> getInstructorFeedback()
  {
    return new ArrayList<InstructorFeedback>(
      my_instructor_feedback);

  }

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

  public List<StudentFeedbackSummary> getStudentFeedback()
  {

    return Collections
        .unmodifiableList(my_student_feedback);
  }
}
