// edfile.java
// Template for a line-oriented text editor inspired by ed.
import java.io.*;
import java.util.*;
import static java.lang.System.*;

class edfile{

   public static void main (String[] args) throws IOException{
	dllist lines = new dllist();
	boolean want_echo = true;
	if (args[0].equals("-e")){
    	  		  want_echo = true;
			  try{
		   	  Scanner file =new Scanner(new File(args[1]));
		   	  while(file.hasNextLine()){
		   		  String item= file.nextLine();
		   		  lines.insert(item, dllist.position.LAST);
		   	  	}
			  }catch(FileNotFoundException e){
				System.out.println("No such file");
				System.exit(1);
				}
	}
	else{
		    	  want_echo = false;
                          try{
			  Scanner file =new Scanner(new File(args[0]));
                          while(file.hasNextLine()){
                                  String item= file.nextLine();
                                  lines.insert(item, dllist.position.LAST);
                         	 }
			  }catch(FileNotFoundException e){
				System.out.println("No such file");
				System.exit(1);
			   	}
	}
	System.out.println("welcome");
      Scanner stdin = new Scanner (in);
      for (;;) {
         if (! stdin.hasNextLine()) break;
         String inputline = stdin.nextLine();
         if (want_echo) out.printf ("%s%n", inputline);
         if (inputline.matches ("^\\s*$")) continue;
         char command = inputline.charAt(0);
         switch (command) {
		            case '#': 
				String comment = inputline.substring(1);
				System.out.println(comment);				
				break;
		            case '$':  
		            	String temp=lines.getItem();
		            	lines.delete();
		            	lines.insert(temp, dllist.position.LAST);
		            	
		            	System.out.println(lines.getItem());
		            	
		            	break;
		            case '*':  
		            	lines.setPosition(dllist.position.LAST);
		            	int a = lines.getPosition();
		            	lines.setPosition(dllist.position.FIRST);
		            	for (int i=0; i<=a;i++){
		            		System.out.println(lines.getItem());
		            		lines.setPosition(dllist.position.FOLLOWING);	
		            	}
		            	
		            	break;
		            case '.': 
		            	System.out.println(lines.getItem());
		            	break;
		            case '0': 
		            	String temp2=lines.getItem();
		            	lines.delete();
		            	lines.insert(temp2, dllist.position.FIRST);

		            	System.out.println(lines.getItem());
		            	break;
		            case '<':  
		            	lines.setPosition(dllist.position.PREVIOUS);
		            	
		            	System.out.println(lines.getItem());
		            	break;
		            case '>':
		            	lines.setPosition(dllist.position.FOLLOWING);
		            	
		            	System.out.println(lines.getItem());
		            	break;
		            case 'a':  
		            	String insertingtext = inputline.substring(1);
		            		lines.insert(insertingtext, dllist.position.FOLLOWING);
		            		System.out.println(lines.getItem());      
		            	break;
		            case 'd': 
		            	lines.delete();
		            	if (lines.isEmpty())
		            		System.out.println("empty");
		            	else
		            	System.out.println(lines.getItem());
		            	break;
		            case 'i':  
		            	String insertingtext2 = inputline.substring(1);
	            		lines.insert(insertingtext2, dllist.position.PREVIOUS);
	            		System.out.println(lines.getItem());      
	            	
		            	break;
		            case 'r':
		           	String insertingfile = inputline.substring(1);
				int numblines=0;
		            	try{
				Scanner file2 =new Scanner(new File(insertingfile));
		            	while(file2.hasNextLine()){
		  		   	String item= file2.nextLine();
		  		        lines.insert(item, dllist.position.LAST);
					numblines++;
		  		   } 
				System.out.println(numblines+" lines inserted");
				}catch(FileNotFoundException e){
					System.out.println("No such file");
				}
		            	break;
		            case 'w': 
		            	String createfile = inputline.substring(1);
		            	File newfile = new File(createfile);
		            	newfile.createNewFile();
		            	FileWriter writer = new FileWriter(newfile); 
		            	lines.setPosition(dllist.position.LAST);
		            	int b = lines.getPosition();
		            	lines.setPosition(dllist.position.FIRST);
		            	for (int i=0; i<=b;i++){
		            		writer.write(lines.getItem()+"\n");
		            		lines.setPosition(dllist.position.FOLLOWING);	
		            	}
		            	writer.close();
				break;
		            default : 
				System.out.println("No such commend");
				System.exit(1);			
				break;		
         }
      }
   }
}

