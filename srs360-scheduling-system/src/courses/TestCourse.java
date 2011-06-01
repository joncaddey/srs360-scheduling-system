/*
 * Simple Random Sample
 * 
 * srs360-scheduling-system
 */

package courses;

import static org.junit.Assert.*;

import org.junit.*;

/**
 * A series of tests.
 * 
 * @author Jonathan Caddey
 * @version May 30, 2011: Class created.
 */
public class TestCourse
{
  final Course my_course = new Course("TCSS360", "QA", 5);

  /**
   * equals when not same type of object.
   */
  @Test
  public void testWrongTypesEquals()
  {
    assertFalse("Wrong type", my_course.equals("TCSS360"));
  }

  /**
   * equals when same reference.
   */
  @Test
  public void testSameReferenceEquals()
  {
    assertTrue("Same reference",
        my_course.equals(my_course));
  }

  /**
   * equals when same fields.
   */
  @Test
  public void testSameFieldsEquals()
  {
    assertTrue("Same fields",
        my_course.equals(new Course("TCSS360", "QA", 5)));
  }

}
