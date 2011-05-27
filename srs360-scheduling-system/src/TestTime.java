/*
 * Simple Random Sample
 * 
 * TCSS 360 Dr. Tenenberg
 * 
 * srs360-scheduling-system
 */

import static org.junit.Assert.*;

import org.junit.*;

/**
 * Tests the methods from Time class. It's testing Time.
 * 
 * @author Jonthan Caddey
 * @version May 20, 2011: Class created.
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
  //@Test
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
  //@Test
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
  //@Test
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
  //@Test
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
  //@Test
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

}
