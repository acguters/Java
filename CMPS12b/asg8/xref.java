//xref.java
//Set of functions used in the printing out of binary tree in asg8
//Special Instructions: type "make test" to run test, to print out tree, however, type
// "java xref -d test.java" or whatever .txt file you are testing
//type make clean to clean class files as well as executable

import java.io.*;
import java.util.Scanner;
import static java.lang.System.*;

class xref {

    static void processFile(String filename, boolean debug) throws IOException {
        Scanner scan = new Scanner (new File(filename));
        Tree tree = new Tree();
        for (int linenr = 1; scan.hasNextLine (); ++linenr) {
            for (String word: scan.nextLine().split ("\\W+")) {
                //out.printf ("%s: %d: %s%n", filename, linenr, word);
                tree.insert(word, linenr);
            }
        }
        scan.close();
        if (debug) {
            tree.debug();
        } else {
            tree.output();
        }
    }

    public static void main(String[] args) {
        // This code does handle -d option   
   
	boolean debug = false;
	String filename = null;
        
        if (args.length == 0){ //no file referenced
          System.out.println("Usage: java xref -d filename.txt");
          System.exit(1); 
        } 
        
        else if (args[0].compareTo("-d") != 0){ //if specified, set equal to filename
          filename = args[0];
     	}	
        else{
          filename = args[1]; 
          debug = true;
	  	  
        }
        try {									
            processFile(filename, debug);	 //Given to us in zip
        }
        catch (IOException error) {
            auxlib.warn (error.getMessage());
        }
        auxlib.exit();
    }

}
