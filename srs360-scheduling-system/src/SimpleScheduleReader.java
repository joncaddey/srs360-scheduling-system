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
import java.util.List;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

/**
 * TODO this must be revised now that it is no longer a
 * utility class.
 * 
 * A SimpleScheduleReader reads a given .csv file to produce
 * a Schedule. Cells that start with the COMMENT_STRING are
 * treated as comments and ignored by the
 * SimpleScheduleReader. Entire lines rows are commented by
 * commenting the first cell in that row. Every row after
 * SKIP_LINES non-commented lines have been skipped is
 * assumed to represent a Section on a Schedule with the
 * following format:
 * 
 * <br>
 * <br>
 * <code>
 * COURSE_ID  SECTION CLASS_TITLE INSTRUCTOR DAYS 
 * START_TIME END_TIME  CREDITS
 * </code> <br>
 * <br>
 * 
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
public final class SimpleScheduleReader
{

  /**
   * Cells that start with this String are treated as a
   * comment and ignored by the reader.
   */
  public static final String DEFAULT_COMMENT_STRING = "%";

  /**
   * Fields identified with this String indicate that their
   * contents have yet to be announced.
   */
  public static final String DEFAULT_TBA = "TBA";

  /**
   * The delimiter which separates cells in the file.
   */
  public static final String DEFAULT_DELIMITER = ",";

  /**
   * The number of lines that are skipped before Sections
   * are read.
   */
  public static final int DEFAULT_ROW_OFFSET = 2;

  private final String my_delimiter;
  private final String my_comment_string;
  private final int my_row_offset;
  private final String my_tba;

  public SimpleScheduleReader(final String the_delimiter,
                              final String the_comment_string,
                              final int the_row_offset,
                              final String the_tba)
  {
    my_delimiter = the_delimiter;
    my_comment_string = the_comment_string;
    my_row_offset = the_row_offset;
    my_tba = the_tba;
  }

  public SimpleScheduleReader()
  {
    this(DEFAULT_DELIMITER, DEFAULT_COMMENT_STRING,
         DEFAULT_ROW_OFFSET, DEFAULT_TBA);
  }

  public static void read(File the_file) throws IOException
  {
    BufferedReader reader;
    reader = new BufferedReader(new FileReader(the_file));
    String line;
    int to_skip = DEFAULT_ROW_OFFSET;
    StringTokenizer tk;

    String course_id;
    String section;
    String class_title;
    String instructor;
    String days;
    String start_time;
    String end_time;
    String credits;
    line = reader.readLine();

    // Must skip first few lines.
    while (null != line && to_skip > 0)
    {
      if (!line.startsWith(DEFAULT_COMMENT_STRING))
      {
        to_skip--;
        System.out.println("Skipped line: " + line);
      }
      line = reader.readLine();
    }

    // now treat each non-commented line as a Section.
    while (null != line)
    {
      if (!line.startsWith(DEFAULT_COMMENT_STRING))
      {
        tk =
            new StringTokenizer(line, DEFAULT_DELIMITER,
              true);
        //course_id = nextCell(tk);

      }
      line = reader.readLine();
    }

    reader.close();
  }


  /**
   * Returns an array containing the Strings that appear
   * from right to left separated by the reader's delimiter.
   * If the ith cell is empty, commented, or TBA, the ith
   * element of the returned array is null. If the last
   * cells are blank they will not be added to the end of
   * the returned array.
   * 
   * <br>
   * <br>
   * <b>Preconditions: </b>
   * <ul>
   * <li>the_line != null</li>
   * </ul>
   * <b>Postconditions:</b>
   * <ul>
   * <li>The returned array contains the cells of the_line
   * as interpreted as a .csv file.</li>
   * </ul>
   * 
   * @param the_line a line of cells, separated by this
   *          reader's delimiter.
   * @return the cells represented in the_line, with null
   *         for blank or otherwise ignored cells.
   * @throws NullPointerException if the_line is null.
   */
  protected String[] parseCells(final String the_line)
      throws NullPointerException
  {
    final String[] r = the_line.split(my_delimiter);
    for (int i = 0; i < r.length; i++)
    {
      if ("".equals(r[i]) || r[i].equals(my_tba) ||
          r[i].startsWith(my_comment_string))
      {
        r[i] = null;
      }
    }
    return r;
  }

  public static void main(final String[] the_args)
  {
    String string = ",Hello,,";
    String[] parts = string.split(",");
    System.out.println(parts.length);
    for (int i = 0; i < parts.length; i++)
    {
      System.out.println(parts[i]);
    }

  }

}
