/*
 * Simple Random Sample
 * 
 * srs360-scheduling-system
 */

package users;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import courses.Course;
import courses.Schedule;

/**
 * Contains tests for methods in the User class.
 * 
 * <br>
 * <br>
 * <b>Invariants:</b>
 * <ul>
 * <li>invariant1</li>
 * </ul>
 * 
 * @author David
 * @version May 16, 2011
 */
public class TestUser
{
  @Test(expected = IllegalArgumentException.class)
  public void testNullNameUser()
  {
    new User(null, "password", null, null, null, false);
  }
  
  @Test(expected = IllegalArgumentException.class)
  public void testNullPasswordUser()
  {
    new User("name", null, null, null, null, false);
  }
  
  /**
   * Tests the authenticate method.
   * <br>
   * <b>Preconditions:</b>
   * <ul>
   * <li>name is not null</li>
   * <li>password is not null</li>
   * </ul>
   * <b>Postconditions:</b>
   * <ul>
   * <li>returns verification of user by password</li>
   * </ul>
   */
  @Test
  public void testAuthenticate()
  {
    User user = new User
              ("user", "password", null, null, null, false);
    String password = "password";
    assertTrue(user.authenticate("password"));  
  }

}
