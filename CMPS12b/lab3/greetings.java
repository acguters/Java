//greetings.java
//reads text document takes name and number, splits from comma, prints name

import static java.lang.System.*;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;

class greetings {
	 public static void main( String[] args ) throws IOException {
	
		BufferedReader in = new BufferedReader(
		new FileReader("directory.txt"));
		try{
		while(true) {
			String name = in.readLine();
			
		if (name == null) break;
			 String[] matches = name.split(",");
			 System.out.println("Hello, " + matches[0] + ".");
		 }
		} catch(IOException io) {
			io.printStackTrace();
		}
		
		 in.close();
	 }

}

