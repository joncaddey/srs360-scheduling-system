/*
 * Simple Random Sample
 * 
 * srs360-scheduling-system
 */
package users;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Test;

import courses.Course;
import courses.Schedule;
import courses.Section;
import static org.junit.Assert.*;

/**
 * Tests the getAdvisorFeedback method.
 * <br>
 * <b>Invariants:</b>
 * <ul>
 * <li>none</li>
 * </ul>
 * 
 * @author David
 * @version May 30, 2011: Class created.
 */
public class TestAdvisorPreferences
{
   /**
    * Tests the getAdvisorFeedback method.
    * <br>
    * <b>Preconditions:</b>
    * <ul>
    * <li>none</li>
    * </ul>
    * <b>Postconditions:</b>
    * <ul>
    * <li>assertions for expected output</li>
    * </ul>
    */
  @Test
  public void testGetAdvisorFeedback()
  {
    // This Collection<Course> contains 305 and 142. 
    Collection<Course> courseCollection =
                                    new ArrayList<Course>();
    Course course305 = new Course
                           ("TCSS305", "PROG PRACTICUM", 5);
    Course course142 = new Course
                               ("TCSS142", "INTRO PROG", 5);
    courseCollection.add(course305);
    courseCollection.add(course142);
     
    // This Collection<Section> contains only 305.
    Collection<Section> sectionCollection =
                                   new ArrayList<Section>();
    Section section305 = new Section
                              (course305, null, null, null, null, null);
    sectionCollection.add(section305);
    
    // This schedule contains only 305.
    Schedule schedule = new Schedule(sectionCollection);
    
    // The Advisor wants both 305 and 142.
    AdvisorPreferences adv_prefs =
                   new AdvisorPreferences(courseCollection);
    
    // This missing Collection<Course> has the courses
    // wanted by the Advisor but not on the Schedule. It is
    // returned by the getAdvisorFeedback method which is
    // being tested.
    Collection<Course> missing_courses =
                     adv_prefs.getAdvisorFeedback(schedule);
    
    // 305 is not missing from the Schedule.
    assertTrue(!missing_courses.contains(course305));
    // 142 is missing from the Schedule.
    assertTrue(missing_courses.contains(course142));
  } 
  
}