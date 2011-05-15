import java.util.ArrayList;
import java.util.List;


public abstract class UserPreferences
{
  private List<Course> my_course_list;
  
  public UserPreferences()
  {
    my_course_list = new ArrayList<Course>();
  }
  
  public void addCourse(Course the_course)
  {
    my_course_list.add(the_course);
  }

  public void removeCourse(Course the_course)
  {
    my_course_list.remove(the_course);
  }
}
