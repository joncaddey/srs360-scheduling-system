/*
 * Simple Random Sample
 * 
 * srs360-scheduling-system
 */

package users;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Gregory Cloutier
 * @version 05/16/11 Made Test class
 * @version 05/18/11 Made Changes to testAuthenticate()
 *          method.
 * @version 06/01/11 Made minor modifications to the class.
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
    my_users.add(new User("bill", "123456", null,
                          null, null, false));
    my_community = new UserCommunity(my_users, null);
  }

  /**
   * Test method for UserCommunity's authenticate method .
   */
  @Test
  public void testAuthenticate()
  {
    assertTrue("bcstereo is not within the system",
        my_community.authenticate("bill", "123456"));
    assertFalse("lisa1997 is within the system",
        my_community.authenticate("lisa1997", "098765"));
  }

}
