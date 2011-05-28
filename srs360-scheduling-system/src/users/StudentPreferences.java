/*
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
import courses.DaySlot;
import courses.GeneralTime;
import courses.Schedule;

/**
 * Provides the student's preferences of courses he wants to
 * take and days and times he wants to attend.
 * <br>
 * <b>Invariants:</b>
 * <ul>
 * <li>none</li>
 * </ul>
 * 
 * @author David
 * @version May 27, 2011: Class created.
 */
public class StudentPreferences
{
  private final List<Course> my_pref_courses;
  private final List<Day> my_pref_days;
  private final List<GeneralTime> my_pref_times;

  /**
   * Constructs a StudentPreferences.
   */
  public StudentPreferences()
  {
    my_pref_courses = new ArrayList<Course>();
    my_pref_days = new ArrayList<Day>();
    my_pref_times = new ArrayList<GeneralTime>();
  }

  /**
   * Adds a course to the student's course list.
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
   * Removes a course from the student's course list.
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
   * Adds a day to the student's day list.
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
   * Removes a day from the student's day list.
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
   * Adds a time to the student's time list.
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
   * Removes a time from the student's time list.
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
   * For every course this student wants to take, this
   * method returns a "feedback collection" of "dayslots"
   * (MW, TR) and times (day, evening) he will be on campus
   * to take it. It doesn't return anything if he will be
   * on campus at the scheduled day/time anyway.
   * <br>
   * <b>Preconditions:</b>
   * <ul>
   * <li>the_schedule != null</li>
   * <li>the collection of dayslots (MW, TR) != null</li>
   * </ul>
   * <b>Postconditions:</b>
   * <ul>
   * <li>the feedback collection != null</li>
   * </ul>
   * @param the_schedule The schedule of courses
   * @param the_dayslot_collection A collection of dayslots
   * @return The collection of feedbacks
   * @throws IllegalArgumentException if the schedule or the
   * dayslot collection == null
   */
  public Collection<StudentFeedbackSummary> getStudentFeedback
          (final Schedule the_schedule,
           final Collection<DaySlot> the_dayslot_collection)
           throws IllegalArgumentException
  {
    if (the_schedule == null)
    {
      throw new IllegalArgumentException
                                ("schedule cannot be null");
    }
    if (the_dayslot_collection == null)
    {
      throw new IllegalArgumentException
                      ("dayslot collection cannot be null");
    }
    // the collection of feedbacks that will be returned
    final Collection<StudentFeedbackSummary> fbk_collection =
                    new ArrayList<StudentFeedbackSummary>();
    // In English: "For each course I want to take, if the 
    // schedule does not have it on a day and at a time I
    // am on campus, put every combination of meeting days
    // (MW, TR, etc) and time (day, evening) that I will be
    // on campus into a collection and return that." 
    for (Course each_course : my_pref_courses)
    {
      if (!the_schedule.hasSection(each_course,
                                   my_pref_days,
                                   my_pref_times))
      {
        for (DaySlot each_dayslot : the_dayslot_collection)
        {
          for (GeneralTime each_time :
                                  GeneralTime.getAllTimes())
          {
            if (my_pref_days.containsAll
                         (each_dayslot.getDays()) &&
                          my_pref_times.contains(each_time))
            {
              StudentFeedbackSummary stud_fbk =
                    new StudentFeedbackSummary(each_course,
                                               each_dayslot,
                                               each_time);
              fbk_collection.add(stud_fbk);
            }
          }
        }     
      }
    } 
    return fbk_collection;   
  }

}
