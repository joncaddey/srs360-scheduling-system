import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;

/**
 * Simple Random Sample
 * 
 * TCSS 360 Dr. Tenenberg
 * 
 * srs360-scheduling-system
 */

/**
 * 
 * <br>
 * <br>
 * <b>Invariants:</b>
 * <ul>
 * <li>invariant1</li>
 * </ul>
 * 
 * @author Gregory Cloutier
 * @version May 16, 2011
 */
public class TestUserCommunity
{
  /**
   * Test community.
   */
  private UserCommunity my_community;

  /**
   * Test list of users.
   */
  private Collection<User> my_users;

  /**
   * @throws java.lang.Exception shouldn't happen
   */
  @Before
  public void setUp() throws Exception
  {
    my_users = new ArrayList<User>();
    my_users.add(new User("bill"));
    my_community = new UserCommunity(my_users);
  }

  /**
   * Test method for
   * {@link UserCommunity#authenticate
   *   (java.lang.String, java.lang.String)}
   * .
   */
  @Test
  public void testAuthenticate()
  {
    assertTrue(my_community.authenticate("bill", "123456"));
    assertFalse(my_community.authenticate("lisa",
                                          "098765"));
  }

}
