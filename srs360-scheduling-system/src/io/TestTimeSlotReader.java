/*
 * Simple Random Sample
 * 
 * TCSS 360 Dr. Tenenberg
 * 
 * srs360-scheduling-system
 */

package io;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Scanner;

import org.junit.*;

import courses.Day;
import courses.DaySlot;

/**
 * Contains a series of tests for TimeSlotReader.
 * 
 * @author Jonathan Caddey
 * @version May 28, 2011: Class created.
 */
public class TestTimeSlotReader
{

  /**
   * A reader to be used for tests.
   */
  private TimeSlotReader my_reader;

  /**
   * A simple scanner with correct input.
   */
  private Scanner my_scanner;

  /**
   * A mapping of day names to their Days for tests.
   */
  private Map<String, Day> my_day_map;

  /**
   * Sets up tests.
   */
  @Before
  public void setup()
  {
    my_reader = new TimeSlotReader();
    my_day_map = my_reader.readDays("M,T,W,Th,F,S,Sn");
    my_scanner =
        new Scanner("M,T,W,Th,F,S,Sn\n" + "1615\n" + "MW\n"
                    + "TTh");
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

  /**
   * parseDayString when two days start with same character
   * and appear out of order.
   */
  @Test
  public void testSamePrefixParseDayString()
  {
    Day[] days = new Day[0];
    days =
        my_reader.parseDayString("MThT",
            my_reader.readDays("M,T,W,Th,Friday,S,N"))
            .toArray(days);
    assertArrayEquals("Misinterpreted prefix", new Day[] {
        Day.MONDAY, Day.THURSDAY, Day.TUESDAY}, days);
  }

  /**
   * parseDayString when the String is null.
   */
  @Test(expected = NullPointerException.class)
  public void testNullParseDayString()
  {
    my_reader.parseDayString(null,
        (Map<String, Day>) Collections.EMPTY_MAP);
  }

  /**
   * parseDayString when the String is empty.
   */
  @Test
  public void testWhiteSpaceParseDayString()
  {
    assertEquals("Should have found 0 days", 0, my_reader
        .parseDayString("", my_day_map).size());
  }

  /**
   * parseDayString when unrecognized characters.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testUnrecognizedDayParseDayString()
  {
    my_reader.parseDayString("MonTeuWedTh",
        my_reader.readDays("Mon,Teu,Wed,Thu,Fri,Sat,Sun"));
  }

  /**
   * read(Scanner) when works properly, for
   * test-dayslots.txt
   */
  @Test
  public void testWorksOkayRead()
  {
    my_reader.read(my_scanner);
    assertEquals("Wrong cutoff hour", 16, my_reader
        .getCutoffTime().getHour());
    assertEquals("Wrong cutoff minute", 15, my_reader
        .getCutoffTime().getMinute());
    Collection<DaySlot> day_slots = my_reader.getDaySlots();
    assertEquals("Wrong number dayslots", 2,
        day_slots.size());

  }

  /**
   * read(Scanner) after already having called read.
   */
  @Test(expected = IllegalStateException.class)
  public void testSecondReadRead()
  {
    my_reader.read(my_scanner);
    my_reader.read(my_scanner);

  }
}
