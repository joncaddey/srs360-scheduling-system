import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Simple Random Sample
 * 
 * TCSS 360 Dr. Tenenberg
 * 
 * srs360-scheduling-system
 */

public class AdvisorPreferences
{
  private List<Section> my_preferred_sections;
  
  public AdvisorPreferences()
  {
    my_preferred_sections = new ArrayList<Section>();
  } 

  public void addSection(Section the_section)
  {
    my_preferred_sections.add(the_section);
  }
  
  public void removeCourse(Section the_section)
  {
    my_preferred_sections.remove(the_section);
  }
  
  public List<Section> getPreferredSections()
  {
    return my_preferred_sections;
  }

}
