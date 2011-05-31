/*
 * Simple Random Sample
 * 
 * TCSS 360 Dr. Tenenberg
 * 
 * srs360-scheduling-system
 */

package courses;

import static org.junit.Assert.*;

import org.junit.*;

/**
 * Tests the methods from Time class. It's testing Time.
 * 
 * @author Jonthan Caddey
 * @author David
 * @version May 20, 2011: Class created.
 * @version May 29, 2011: David added constructor tests.
 * @version May 30, 2011: Jonathan added compareTo tests.
 */
public class TestTime
{

  public final Time my_0 = new Time(0);
  public final Time my_100 = new Time(100);
  public final Time my_115 = new Time(115);
  public final Time my_200 = new Time(200);
  public final Time my_2200 = new Time(2200);
  public final Time my_2300 = new Time(2300);
  public final Time my_2315 = new Time(2315);

  /**
   * Time.overlap when the durations just barely overlap,
   * but neither lasts the other's entire duration.
   */
  @Test
  public void testEndToEndOverlap()
  {
    assertTrue("Should have overlapped end to end",
        Time.overlap(my_0, my_100, my_115, my_200, 16));
    assertTrue(
        "Should have overlapped end to end (reverse)",
        Time.overlap(my_115, my_200, my_0, my_100, 16));
  }

  /**
   * Time.overlap when the durations don't overlap, but are
   * within 1 minute of overlapping end to end.
   */
  @Test
  public void testEndToEndNoOverlap()
  {
    assertFalse("Should not have overlapped end to end",
        Time.overlap(my_0, my_100, my_115, my_200, 15));
    assertFalse(
        "Should not have overlapped end to end (reverse)",
        Time.overlap(my_115, my_200, my_0, my_100, 15));

  }

  /**
   * Time.overlap when the durations overlap, and one lasts
   * the other's entire duration.
   */
  @Test
  public void testWholeDurationOverlap()
  {
    assertTrue("Should have overlapped whole duration",
        Time.overlap(my_0, my_200, my_100, my_115, 0));
    assertTrue(
        "Should have overlapped whole duration (reversed)",
        Time.overlap(my_100, my_115, my_0, my_200, 0));
  }

  /**
   * Time.overlap when one duration crosses midnight and the
   * other duration just barely overlaps at the midnight
   * duration's end, but neither lasts the other's entire
   * duration.
   */
  // @Test
  public void testMidnightEndOverlap()
  {
    assertTrue("Should have overlapped midnight end",
        Time.overlap(my_2300, my_100, my_115, my_200, 16));
    assertTrue(
        "Should have overlapped midnight end (reversed)",
        Time.overlap(my_115, my_200, my_2300, my_100, 16));

  }

  /**
   * Time.overlap when one duration crosses midnight and the
   * other very nearly overlaps at the midnight duration's
   * end.
   */
  // @Test
  public void testMidnightEndNoOverlap()
  {

    assertFalse("Should not have overlapped midnight end",
        Time.overlap(my_2300, my_100, my_115, my_200, 15));
    assertFalse(
        "Should not have overlapped midnight end (reversed)",
        Time.overlap(my_115, my_200, my_2300, my_100, 15));

  }

  /**
   * Time.overlap when one duration crosses midnight and the
   * other duration just barely overlaps at the midnight
   * duration's start, but neither lasts the other's entire
   * duration.
   */
  // @Test
  public void testMidnightStartOverlap()
  {
    assertTrue("Should have overlapped midnight start",
        Time.overlap(my_2200, my_2300, my_2315, my_100, 16));
    assertTrue(
        "Should have overlapped midnight start (reversed)",
        Time.overlap(my_2315, my_100, my_2200, my_2300, 16));
  }

  /**
   * Time.overlap when one duration crosses midnight and the
   * other very nearly overlaps at the midnight duration's
   * start.
   */
  // @Test
  public void testMidnightStartNoOverlap()
  {
    assertFalse(
        "Should not have overlapped midnight start",
        Time.overlap(my_2200, my_2300, my_2315, my_100, 15));
    assertFalse(
        "Should not have overlapped midnight start (reversed)",
        Time.overlap(my_2315, my_100, my_2200, my_2300, 15));

  }

  /**
   * Time.overlap when the durations overlap and both cross
   * midnight.
   */
  // @Test
  public void testBothMidnightOverlap()
  {
    assertTrue("Should have overlapped over midnight",
        Time.overlap(my_2200, my_200, my_2300, my_100, 0));
    assertTrue(
        "Should have overlapped over midnight (reversed)",
        Time.overlap(my_2300, my_100, my_2200, my_200, 0));
  }

  /**
   * Time.overlap throws exception when transit time is
   * negative.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNegativeTransitOverlap()
  {
    Time.overlap(my_2300, my_100, my_2200, my_200, -1);
  }

  /**
   * Time(int, int) when the arguments are negative.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNegativeParametersTime()
  {
    new Time(-1, -1);
  }

  /**
   * Time(int, int) when the hours > 23 or the minutes > 59
   * time is normalized.
   */
  @Test
  public void testNormalizedHoursAndMinutesTime()
  {
    final Time time1 = new Time(25, 0);
    assertTrue("the hours are not normalized",
        time1.getHour() == 1);

    final Time time2 = new Time(0, 65);
    assertTrue("the minutes are not normalized",
        time2.getMinute() == 5);
  }

  /**
   * Time(int) when the argument < 0.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testIncorrectParameter1Time()
  {
    new Time(-1);
  }

  /**
   * Time(int) when the argument/100 > 23.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testIncorrectParameter2Time()
  {
    new Time(2400);
  }

  /**
   * Time(int) when the argument % 100 > 59.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testIncorrectParametersTime()
  {
    new Time(60);
  }

  /**
   * compareTo when not equal.
   */
  @Test
  public void testNotEqualCompareTo()
  {
    assertTrue("Wrong inequality",
        my_100.compareTo(my_115) < 0);
    assertTrue("Wrong inequality (reversed)",
        my_115.compareTo(my_100) > 0);
  }

  /**
   * compareTo and equals when equal but not same reference.
   */
  @Test
  public void testEqualCompareTo()
  {
    assertTrue("Should be equal",
        my_100.compareTo(new Time(100)) == 0);
    assertTrue("Should be equal by equal method",
        my_100.equals(new Time(100)));
  }
}
