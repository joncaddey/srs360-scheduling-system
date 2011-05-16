/**
 * Simple Random Sample
 * 
 * TCSS 360 Dr. Tenenberg
 * 
 * srs360-scheduling-system
 */

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.junit.*;

/**
 * Contains a series of tests for the Schedule class.
 * 
 * @author Jonathan Caddey
 * @version 2011-05-15
 */
public class TestSchedule
{

  /**
   * A Course representing TCSS 360.
   */
  private final Course my_course_360 = new Course("TCSS",
    360, "QA");

  /**
   * An instructor User.
   */
  private final User my_instructor = new User();

  /**
   * A Section for TCSS 360.
   */
  private final Section my_section_360 = new Section(
    my_course_360, my_instructor, new TimeSlot(new Day[] {
        Day.MONDAY, Day.WEDNESDAY}, new Time(8, 0),
      new Time(10, 5)));

  /**
   * Preferred time--contains MORNING.
   */
  private Collection<GeneralTime> my_times;

  /**
   * Preferred days--contains MONDAY, WEDNESDAY.
   */
  private Collection<Day> my_days;

  /**
   * A Schedule with no Sections.
   */
  private Schedule my_empty;

  /**
   * A Schedule with a single Section of 360.
   */
  private final Schedule my_schedule_360 = new Schedule(
    Arrays.asList(new Section[] {my_section_360}));

  /**
   * Initializes each test case.
   */
  @Before
  public void before()
  {
    my_empty = new Schedule(new ArrayList<Section>());
    my_times = new ArrayList<GeneralTime>();
    my_times.add(GeneralTime.MORNING);
    my_days = new ArrayList<Day>();
    my_days.add(Day.MONDAY);
    my_days.add(Day.WEDNESDAY);
  }

  /**
   * No Section which matches all parameters is found, but
   * one is of the right Course and meets on none other than
   * the desired days.
   */
  public void testBadTimeSection()
  {
    my_days.remove(Day.MONDAY);
    assertFalse(
        "Should not have found, wrong time",
        my_schedule_360.hasSection(
            my_course_360,
            my_days,
            Arrays.asList(new
                GeneralTime[]{GeneralTime.EVENING})));
  }

  /**
   * No matching Sections are found, but one is of the right
   * Course and meets at one of the desired times.
   */
  public void testMissingDaysHasSection()
  {
    my_days.remove(Day.MONDAY);
    assertFalse(
        "Should not have found, can't attend Monday",
        my_schedule_360.hasSection(my_course_360, my_days,
            my_times));
  }

  /**
   * No matching Sections are found, but one meets on none
   * other than the desired days and meets at one of the
   * desired times.
   */
  public void testMissingCourseHasSection()
  {
    my_days.remove(Day.MONDAY);
    assertFalse("Should not have found, no Course",
        my_schedule_360.hasSection(new Course("TCSS", 305,
          "Weed Out"), my_days, my_times));
  }

  /**
   * A Section matches, even though there are more given
   * days than it meets.
   */
  @Test
  public void testManyDaysHasSection()
  {
    my_days.add(Day.TUESDAY);
    assertTrue("Should still find, despite extra days",
        my_schedule_360.hasSection(my_course_360, my_days,
            my_times));
  }

  /**
   * A matching section is found.
   */
  @Test
  public void testFoundItHasSection()
  {
    assertTrue("Should have found the section",
        my_schedule_360.hasSection(my_course_360, my_days,
            my_times));
  }

  /**
   * the_course is null.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNullCourseHasSection()
  {
    my_empty.hasSection(null, my_days, my_times);
  }

  /**
   * the_days is null.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNullDaysHasSection()
  {
    my_empty.hasSection(my_course_360, null, my_times);
  }

  /**
   * the_days has null.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNullDayIncludedHasSection()
  {
    my_days.add(null);
    my_empty.hasSection(my_course_360, my_days, my_times);
  }

  /**
   * the_times is null.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNullTimesHasSection()
  {
    my_empty.hasSection(my_course_360, my_days, null);
  }

  /**
   * the_times has null.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNullTimeIncludedHasSection()
  {
    my_times.add(null);
    my_empty.hasSection(my_course_360, my_days, my_times);
  }

}
