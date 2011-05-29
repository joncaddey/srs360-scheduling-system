/*
 * Simple Random Sample
 *
 * TCSS 360 Dr. Tenenberg
 *
 * srs360-scheduling-system
 */
package io;

/**
 * Thrown when an input file is not properly organized.
 * @author Jonathan Caddey
 * @version May 28, 2011: Class created.
 */
public class FileFormatException extends RuntimeException
{
  public FileFormatException() {
    super();
  }
  public FileFormatException(final String the_message) {
    super(" " + the_message);    
  }

}
