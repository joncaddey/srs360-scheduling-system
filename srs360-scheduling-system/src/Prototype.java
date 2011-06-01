/*
 * Simple Random Sample
 * 
 * TCSS 360 Dr. Tenenberg
 * 
 * srs360-scheduling-system
 */
import io.CourseListReader;
import io.SimpleScheduleReader;
import io.TimeSlotReader;
import io.UserReader;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import users.User;
import users.UserCommunity;
import courses.Catalogue;
import courses.Schedule;

/**
 * Performs a test run of the system so far. <br>
 * <br>
 * <b>Invariants:</b>
 * <ul>
 * <li>none</li>
 * </ul>
 * 
 * @author Jonathan Caddey
 * @version May 31, 2011: Class created.
 */
public class Prototype
{

  private String my_time_slot_file_path =
      "src/timeslots.txt";
  private String my_course_list_file_path =
      "src/master_course_list.txt";
  private String my_user_list_file_path =
      "src/user_list.txt";
  private String my_schedule_path = "src/schedule.csv";

  private UserCommunity my_user_community;
  private Catalogue my_catalogue;
  private SimpleScheduleReader my_schedule_reader;

  private Schedule my_schedule;

  public void initialize() throws IOException
  {
    TimeSlotReader time_slot_reader = new TimeSlotReader();
    time_slot_reader.read(new Scanner(new File(
      my_time_slot_file_path)));
    CourseListReader course_list_reader =
        new CourseListReader();
    course_list_reader.read(new Scanner(new File(
      my_course_list_file_path)));
    UserReader user_reader =
        new UserReader(time_slot_reader,
          course_list_reader.getCourseMap());
    user_reader.read(new Scanner(new File(
      my_user_list_file_path)));
    my_catalogue =
        new Catalogue(course_list_reader.getCourseMap(),
          time_slot_reader.getDaySlots(),
          time_slot_reader.getCutoffTime());
    my_user_community =
        new UserCommunity(
          user_reader.getUserMap().values(), my_catalogue);
    my_schedule_reader =
        new SimpleScheduleReader(time_slot_reader,
          my_catalogue, my_user_community);
    my_schedule_reader.read(new Scanner(new File(
      my_schedule_path)));
    my_schedule = my_schedule_reader.getSchedule();

  }

  public Catalogue getCatalogue()
  {
    return my_catalogue;
  }

  public UserCommunity getUserCommunity()
  {
    return my_user_community;
  }

  public Schedule getSchedule()
  {
    return my_schedule;
  }

  public static void main(final String[] the_args)
  {
    Prototype prototype = new Prototype();
    try
    {
      prototype.initialize();
    }
    catch (final IOException the_e)
    {
      System.err.println(the_e.getMessage());
    }  

  }
}
