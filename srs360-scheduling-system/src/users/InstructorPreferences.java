/**
 * Simple Random Sample
 * 
 * srs360-scheduling-system
 */   
package users;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import courses.Course;
import courses.Day;
import courses.GeneralTime;
import courses.Schedule;
import courses.Section;

/**
 * Provides the instructor's preferences of courses he wants
 * to teach and days and times he wants to work.
 * <br>
 * <b>Invariants:</b>
 * <ul>
 * <li>none</li>
 * </ul>
 * 
 * @author David
 * @version May 27, 2011: Class created.
 */
public class InstructorPreferences
{
  private final Collection<Day> my_pref_days;
  private final Collection<GeneralTime> my_pref_times;
  private final Collection<Course> my_pref_courses;
  private int my_max_credit_hours;

  /**
   * Constructs an InstructorPreferences.
   */
  public InstructorPreferences(final Collection<Day> the_days,
                    final Collection<GeneralTime> the_times,
                    final Collection<Course> the_courses,
                    int the_max_hours)
  {
    my_pref_days = the_days;
    my_pref_times = the_times;
    my_pref_courses = the_courses;
    my_max_credit_hours = the_max_hours;
  }

    /**
     * Adds a course to the instructor's course list.
     * <br>
     * <b>Preconditions:</b>
     * <ul>
     * <li>The added course is not null</li>
     * </ul>
     * <b>Postconditions:</b>
     * <ul>
     * <li>the course is added to the list</li>
     * </ul>
     * @param the_course The course to be added
     * @throws IllegalArgumentException if the course == null
     */
    public void addCourse(final Course the_course)
                             throws IllegalArgumentException
    {
      if (the_course == null)
      {
        throw new IllegalArgumentException();
      }
      my_pref_courses.add(the_course);
    }
    
    /**
     * Removes a course from the instructor's course list.
     * <br>
     * <b>Preconditions:</b>
     * <ul>
     * <li>The removed course is not null</li>
     * </ul>
     * <b>Postconditions:</b>
     * <ul>
     * <li>the course is removed from the list</li>
     * </ul>
     * @param the_course The course to be removed
     * @throws IllegalArgumentException if the course == null
     */
    public void removeCourse(final Course the_course)
                             throws IllegalArgumentException
    {
      if (the_course == null)
      {
        throw new IllegalArgumentException();
      }
      my_pref_courses.remove(the_course);
    }

    public List<Course> getPreferredCourses()
    {
      return my_pref_courses;
    }

    /**
     * Adds a day to the instructor's day list.
     * <br>
     * <b>Preconditions:</b>
     * <ul>
     * <li>The added day is not null</li>
     * </ul>
     * <b>Postconditions:</b>
     * <ul>
     * <li>the day is added to the list</li>
     * </ul>
     * @param the_day The day to be added
     * @throws IllegalArgumentException if the day == null
     */
    public void addDay(final Day the_day)
                             throws IllegalArgumentException
    {
      if (the_day == null)
      {
        throw new IllegalArgumentException();
      }
      my_pref_days.add(the_day);
    }

    /**
     * Removes a day from the instructor's day list.
     * <br>
     * <b>Preconditions:</b>
     * <ul>
     * <li>The removed day is not null</li>
     * </ul>
     * <b>Postconditions:</b>
     * <ul>
     * <li>the day is removed from the list</li>
     * </ul>
     * @param the_day The day to be removed
     * @throws IllegalArgumentException if the day == null
     */
    public void removeDay(final Day the_day)
                             throws IllegalArgumentException
    {
      if (the_day == null)
      {
        throw new IllegalArgumentException();
      }
      my_pref_days.remove(the_day);
    }

    public List<Day> getPreferredDays()
    {
      return my_pref_days;
    }

    /**
     * Adds a time to the instructor's time list.
     * <br>
     * <b>Preconditions:</b>
     * <ul>
     * <li>The added time is not null</li>
     * </ul>
     * <b>Postconditions:</b>
     * <ul>
     * <li>the time is added to the list</li>
     * </ul>
     * @param the_time The time to be added
     * @throws IllegalArgumentException if the time == null
     */
    public void addTime(final GeneralTime the_time)
                             throws IllegalArgumentException
    {
      if (the_time == null)
      {
        throw new IllegalArgumentException();
      }
      my_pref_times.add(the_time);
    }

    /**
     * Removes a time from the instructor's time list.
     * <br>
     * <b>Preconditions:</b>
     * <ul>
     * <li>The removed time is not null</li>
     * </ul>
     * <b>Postconditions:</b>
     * <ul>
     * <li>the time is removed from the list</li>
     * </ul>
     * @param the_time The time to be removed
     * @throws IllegalArgumentException if the time == null
     */
    public void removeTime(final GeneralTime the_time)
                             throws IllegalArgumentException
    {
      if (the_time == null)
      {
        throw new IllegalArgumentException();
      }
      my_pref_times.remove(the_time);
    }

    public List<GeneralTime> getPreferredGeneralTimes()
    {
      return my_pref_times;
    }
        
    /**
     * This method compares every course/day/time assigned
     * to this instructor with the courses/days/times he
     * wants to teach and returns a collection of course
     * sections that do not match.
     * <br>
     * <b>Preconditions:</b>
     * <ul>
     * <li>the schedule != null</li>
     * <li>the instructor != null</li>
     * </ul>
     * <b>Postconditions:</b>
     * <ul>
     * <li>the collection of unwanted sections != null</li>
     * </ul>
     * @param the_schedule The schedule of courses
     * @param the_instructor The instructor for whom the
     * collection of unwanted sections is prepared
     * @return The collection of unwanted sections
     * @throws IllegalArgumentException if the schedule or
     * the instructor == null
     */
  public Collection<Section> getInstructorFeedback
                               (final Schedule the_schedule,
                                final User the_instructor)
  { 
    if (the_schedule == null)
    {
      throw new IllegalArgumentException
                            ("the schedule cannot be null");
    }
    if (the_instructor == null)
    {
      throw new IllegalArgumentException
                          ("the instructor cannot be null");
    }
    final Collection<Section> scheduled_sections =
           the_schedule.getSectionsTaughtBy(the_instructor);
 
    final Collection<Section> unwanted_sections =
                                   new ArrayList<Section>();
    
    for (Section each_section : scheduled_sections)
    {
      if (!my_pref_courses.contains
                               (each_section.getCourse()) ||
          !my_pref_days.contains(each_section.getDays())  ||
          !my_pref_times.contains
                            (each_section.getGeneralTime()))
      {
        unwanted_sections.add(each_section);
      }    
    }   
    return unwanted_sections;
    
  }
  
}
