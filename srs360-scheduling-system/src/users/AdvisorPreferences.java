/*
 * Simple Random Sample
 * 
 * srs360-scheduling-system
 */
package users;

import java.util.ArrayList;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import courses.Course;
import courses.Schedule;
import courses.Section;

/**
 * Provides the advisor's preferences of sections for the 
 * schedule. 
 * <br>
 * <b>Invariants:</b>
 * <ul>
 * <li>none</li>
 * </ul>
 * 
 * @author David
 * @version May 27, 2011: Class created.
 */
public class AdvisorPreferences
{
  private final List<Section> my_pref_sections;
  
  /**
   * Constructs an AdvisorPreferences.
   */
  public AdvisorPreferences()
  {
    my_pref_sections = new ArrayList<Section>();
  } 

  /**
   * Adds a section to the advisor's section list.
   * <br>
   * <b>Preconditions:</b>
   * <ul>
   * <li>The added section is not null</li>
   * </ul>
   * <b>Postconditions:</b>
   * <ul>
   * <li>the section is added to the list</li>
   * </ul>
   * @param the_section The section to be added
   * @throws IllegalArgumentException if the section == null
   */
  public void addsection(final Section the_section)
                             throws IllegalArgumentException
  {
    if (the_section == null)
    {
      throw new IllegalArgumentException();
    }
    my_pref_sections.add(the_section);
  }
  
  /**
   * Removes a section from the advisor's section list.
   * <br>
   * <b>Preconditions:</b>
   * <ul>
   * <li>The removed section is not null</li>
   * </ul>
   * <b>Postconditions:</b>
   * <ul>
   * <li>the section is removed from the list</li>
   * </ul>
   * @param the_section The section to be removed
   * @throws IllegalArgumentException if the section == null
   */
  public void removesection(final Section the_section)
                             throws IllegalArgumentException
  {
    if (the_section == null)
    {
      throw new IllegalArgumentException();
    }
    my_pref_sections.remove(the_section);
  }

  public List<Section> getPreferredsections()
  {
    return my_pref_sections;
  }

  /**
   * Returns a collection of sections the advisor wants on 
   * the schedule that it does not presently have.
   * <br>
   * <b>Preconditions:</b>
   * <ul>
   * <li>the schedule is not null</li>
   * </ul>
   * <b>Postconditions:</b>
   * <ul>
   * <li>none</li>
   * </ul>
   * @param the_schedule The schedule of courses
   * @return A collection of missing sections
   * @throws IllegalArgumentException if the schedule == null
   */
  public Collection<Section> getAdvisorFeedback
                               (final Schedule the_schedule)
                             throws IllegalArgumentException
  {
    if (the_schedule == null)
    {
      throw new IllegalArgumentException();
    } 
      final List<Section> missing_sections =
                                   new ArrayList<Section>();
      for (Section each_section : my_pref_sections)
      {
        if (!the_schedule.hasSection(each_section))
        {
          missing_sections.add(each_section);
        }
      }
      return missing_sections;
    }

}
