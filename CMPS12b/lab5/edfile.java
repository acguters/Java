// edfile.java
// A line-oriented text editor inspired by ed.

import java.util.Scanner;
import static java.lang.System.*;
import java.io.*;

class edfile{

  public static void main (String[] args) throws FileNotFoundException {
    System.out.println("Welcome to edfile!");
    boolean want_echo = false;
    dllist lines = new dllist ();
    Scanner stdin = new Scanner (in);
    dllist text = new dllist();
    
    
    if(args.length > 0){
      if(args[0]=="-e"){
      want_echo=true;
      System.out.println("-e option used");
        if(args.length > 1){
        System.out.println("Operand: "+ args[1]);
        readIn(args[1], text);
        }
      } else {
        System.out.println("Operand: "+ args[0]);
        readIn(args[0], text);
      }
    }

    for (;;) {
      if (! stdin.hasNextLine()) break;
        String inputline = stdin.nextLine();
      if (want_echo) out.printf ("%s%n", inputline);
      if (inputline.matches ("^\\s*$")) continue;
      char command = inputline.charAt(0);
      String input = inputline.substring(1, inputline.length());
      switch (command) {
        case '#': break;
        
        case '$': 
          text.setPosition(dllist.position.LAST); 
          System.out.println(text.getItem());
          break;
        
        case '*':
          text.setPosition(dllist.position.LAST);
          int lastPos = text.getPosition();
          text.setPosition(dllist.position.FIRST);
          System.out.println(text.getItem());
          while(true){
            text.setPosition(dllist.position.FOLLOWING);
            System.out.println(text.getItem());
            if(text.getPosition() == lastPos) break;
          }
          break;
        
        case '.': 
          System.out.println(text.getItem());
          break;
        
        case '0':
          text.setPosition(dllist.position.FIRST); 
          System.out.println(text.getItem());
          break;
        
        case '<':
          text.setPosition(dllist.position.PREVIOUS); 
          System.out.println(text.getItem());
          break;
        
        case '>': 
          text.setPosition(dllist.position.FOLLOWING); 
          System.out.println(text.getItem());
          break;
        
        case 'a':
          text.insert(input, dllist.position.FOLLOWING);
          text.setPosition(dllist.position.FOLLOWING);
          System.out.println(text.getItem());
          break;
        
        case 'd': 
          text.delete();
          break;
        
        case 'i': 
          text.insert(input, dllist.position.PREVIOUS);
          System.out.println(text.getItem());
          break;
        
        case 'r': 
          int first = text.getLastPos()+1;
          readIn(input, text);
          System.out.println(text.getPosition()+1 - first);
          break;
        
        case 'w':
          text.setPosition(dllist.position.FIRST);
          
          try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                                    new FileOutputStream(input), "utf-8"))) {
            writer.write(text.getItem() + "\n");
            while(true){
              text.setPosition(dllist.position.FOLLOWING);
              writer.write(text.getItem() + "\n");
              
              if(text.getPosition() == text.getLastPos()) break;
            }
             writer.close();
          }catch(IOException e) {
            System.err.println("Problem writing to the file "+ input);
          }

          System.out.println(text.getLastPos() + 1);
          break;
        
        default : auxlib.STUB ("Print invalid command."); break;
      }
    }
  }

  public static void readIn(String file, dllist text) throws FileNotFoundException{
    Scanner scan = new Scanner(new File(file));
    while(scan.hasNextLine()){
      text.insert(scan.nextLine(), dllist.position.FOLLOWING);
    }
  }
}

