package edu.towson.cis.cosc603.alghareeb.project2;

import java.io.*;
/**
 * @author Josh Dehlinger
 * @version 1.0
 */

/**
 * The Class Stutter.
 */
public class Stutter{   
   /**
    * The main method.
    * Get the file name from the first argument or keyboard.
    * Call checkStutter.
    * If no file name is given, alert the user.
    * 
    * @param args the arguments
    */
   public static void main (String args[]){
     // Print out header to consnole
     System.out.println("COSC 603 - Software Testing and Maintenance");
     System.out.println("*******************************************");       
     
     //  Check to make sure only a single file argument was provided
     if (args.length > 1)
       System.out.println ("Too many arguments.\nUsage: java stutter <input file>");
     else if (args.length > 0){
       // Read in file argument
       try{
         BufferedReader reader = new BufferedReader (new FileReader (args[0]));
         checkStutter (reader);
         reader.close();
       }
       catch (Exception e){
         System.err.println ("Error reading from file " + args[0] + ": " + e.getMessage());
       }
     }
    }
   
    /**
    * Check stutter.
    * 
    * Reads the input file one line, then one word at a time.
    * Looks for repeated words and informs users.
    * 
    * @param input the input file argument
    * 
    * @throws IOException Signals that an I/O exception has occurred.
    */
    public static void checkStutter (BufferedReader input) throws IOException {
      int    numberOfLines = 1;
      String line     = null;
      String lastWord = null;

    // Get the first line from the file argument
      line = input.readLine();
      
      // Keep reading and analyzing lines until end of file
      while (line != null){
        // Remove all non alpha-numeric characters
        line = line.replaceAll ("[^a-zA-Z0-9 ]", "");
        // Convert the input line to lower case
        line = line.toLowerCase();

        // Splits the line into words and puts in an array of strings
        String[] words = line.split (" ");

        // Compare with the last word on the previous line
        if (words [0].equals (lastWord))
          System.out.println ("Repeated word on line " + numberOfLines + ": " + words[0]);

        // Stop before the end, nothing to compare the last word with
        for (int i = 0; i < (words.length-1); i++){
          // Check to see if the current and subsequent words are the same
          if (words [i].equals (words [i+1]))
            System.out.println ("Repeated word on line " + numberOfLines + ": " + words [i]);
            }
        
        // Save last word in the line
        lastWord = words [words.length-1];
        // Get the next line from the file argument
        line = input.readLine();
        // Increment line counter
        numberOfLines++;
      }
    }
}
