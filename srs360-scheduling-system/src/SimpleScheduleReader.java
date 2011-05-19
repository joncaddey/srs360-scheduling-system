/*
 * Simple Random Sample
 * 
 * TCSS 360 Dr. Tenenberg
 * 
 * srs360-scheduling-system
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * This is super sketchy; I'm just playing around.
 * TODO <br>
 * <br>
 * <b>Invariants:</b>
 * <ul>
 * <li>TODO invariant1</li>
 * </ul>
 * 
 * @author Jonathan Caddey
 * @version 2011-05-19: Class created.
 */
public class SimpleScheduleReader
{

  public static void read(File the_file) throws IOException
  {
    BufferedReader reader;

    reader = new BufferedReader(new FileReader(the_file));

    String line;

    line = reader.readLine();
    while (null != line)
    {
      System.out.println(line);
      line = reader.readLine();

    }

    reader.close();
  }

  public static final void main(final String[] the_args)
  {
    final File file = new File("../officialScheduleFormat.csv");
    try{
      read(file);
    }
    catch (final IOException the_e)
    {
      System.out.println(the_e.getMessage());
    }

  }

}
