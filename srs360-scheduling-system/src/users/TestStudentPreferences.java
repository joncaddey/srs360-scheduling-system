/*
 * Simple Random Sample
 * 
 * TCSS 360 Dr. Tenenberg
 * 
 * srs360-scheduling-system
 */

package users;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;

import courses.Course;
import courses.Day;
import courses.DaySlot;
import courses.GeneralTime;
import courses.Schedule;
import courses.Section;

public class TestStudentPreferences
{
  private StudentPreferences my_student_prefs;
  private Course my_test_course;
  private Day my_test_day;
  private GeneralTime my_test_time;
  
  @Before
  public void setUp()
  {
    my_student_prefs = new StudentPreferences();
    my_test_course = new Course("100", "CSS360", 5);
    my_test_day = Day.MONDAY;
    my_test_time = GeneralTime.MORNING;
  }
  
  @Test
  public void testAddandRemoveMethods()
  {
    // test add and remove Courses
    my_student_prefs.addCourse(my_test_course);
    assertTrue("addCourse failed", my_student_prefs.
            getPreferredCourses().contains(my_test_course));
    my_student_prefs.removeCourse(my_test_course);
    assertFalse("removeCourse failed", my_student_prefs.
            getPreferredCourses().contains(my_test_course));
 
    // test add and remove Days
    my_student_prefs.addDay(my_test_day);
    assertTrue("addDay failed", my_student_prefs.
                  getPreferredDays().contains(my_test_day));
    my_student_prefs.removeDay(my_test_day);
    assertFalse("removeDay failed", my_student_prefs.
                  getPreferredDays().contains(my_test_day));
 
    // test add and remove Times
    my_student_prefs.addTime(my_test_time);
    assertTrue("addTime failed", my_student_prefs.
             getPreferredGeneralTimes().contains(my_test_time));
    my_student_prefs.removeTime(my_test_time);
    assertFalse("removeTime failed", my_student_prefs.
             getPreferredGeneralTimes().contains(my_test_time));
  }
  
  @Test
  public void testGetStudentFeedback()
  {
    Collection<Section> sections = new ArrayList<Section>();
    Schedule schedule = new Schedule(sections);
    Collection<DaySlot> dayslots = new ArrayList<DaySlot>();
    Collection<StudentFeedbackSummary> fbk =
                    new ArrayList<StudentFeedbackSummary>();
    Collection<Course> pref_courses = new ArrayList<Course>();
    Collection<>

    
  }
  
 
  
  public Collection<StudentFeedbackSummary> getStudentFeedback
  (final Schedule the_schedule,
   final Collection<DaySlot> the_dayslot_collection)

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
