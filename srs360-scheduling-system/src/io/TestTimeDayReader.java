/*
 * Simple Random Sample
 * 
 * TCSS 360 Dr. Tenenberg
 * 
 * srs360-scheduling-system
 */

package io;

import static org.junit.Assert.*;

import java.util.Map;
import java.util.Scanner;

import org.junit.*;

import courses.Day;

/**
 * Contains a series of tests for TimeDayReader.
 * 
 * @author Jonathan Caddey
 * @version May 28, 2011: Class created.
 */
public class TestTimeDayReader
{

  /**
   * A reader to be used for tests.
   */
  private TimeDayReader my_reader;

  /**
   * Sets up tests.
   */
  @Before
  public void setup()
  {
    my_reader = new TimeDayReader();
  }

  /**
   * readDays when everything works fine.
   */
  @Test
  public void testWorkingReadDays()
  {
    final Map<String, Day> day_map =
        my_reader.readDays("M, T, W ,Th,F,S,Sn");
    assertEquals(Day.MONDAY, day_map.get("M"));
    assertEquals(Day.TUESDAY, day_map.get("T"));
    assertEquals(Day.WEDNESDAY, day_map.get("W"));
    assertEquals(Day.THURSDAY, day_map.get("Th"));
    assertEquals(Day.FRIDAY, day_map.get("F"));
    assertEquals(Day.SATURDAY, day_map.get("S"));
    assertEquals(Day.SUNDAY, day_map.get("Sn"));
  }

  /**
   * readDays when null String.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNullStringReadDays()
  {
    my_reader.readDays(null);
  }

  /**
   * readDays when too few days.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testTooFewDaysReadDays()
  {
    my_reader.readDays("M,T,W,R,F,S");
  }

  /**
   * readDays when repeated day and not enough days.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testTooFewRepeatReadDays()
  {
    my_reader.readDays("M,T,W,R,F,S,S");
  }

  /**
   * readDays when repeated day but all represented.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testTooManyDaysReadDays()
  {
    my_reader.readDays("M,T,W,R,F,S,S,N");
  }

  /**
   * parseTimeString when null string.
   */
  @Test(expected = NullPointerException.class)
  public void testNullParseTimeString()
  {
    my_reader.parseTimeString(null);
  }

  /**
   * parseTimeString when not an integer.
   */
  @Test(expected = NumberFormatException.class)
  public void testNoIntParseTimeString()
  {
    my_reader.parseTimeString("123Batman!");
  }

  /**
   * parseTimeString when not a time.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNotATimeParseTimeString()
  {
    my_reader.parseTimeString("1260");
  }

}
