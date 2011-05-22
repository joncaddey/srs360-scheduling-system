import java.awt.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Simple Random Sample
 * 
 * TCSS 360 Dr. Tenenberg
 * 
 * srs360-scheduling-system
 */

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
   * @param a_list_of_users List of authenticated users.
   */
  public UserCommunity
  (final Collection<User> a_list_of_users)
  {
    // Under Construction
    my_authenticated_users = new HashMap<String, User>();
    for (User u : a_list_of_users)
    {
      my_authenticated_users.put(u.getUserName(), u);
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
          my_authenticated_users.get(a_user_id)
              .authenticate(a_password);
    }
    return is_correct;
  }
}
