//Trinh To, CS141, Fall 2019, Section A
//Homework Assignment 14, 11/13/19

//This program's behavior is for each person on the list, 
//find their total salary for the week and print out the vital info.

import java.util.Scanner;
import java.io.*;

public class HW14 {//open class
   public static void main(String[] args) throws FileNotFoundException
   {//open main 
	
	   
	   Scanner input = new Scanner(new File ("CS141Assign14.txt"));//scanning read the file
	   
      PrintStream  out = new PrintStream(new File ("CS141Assign14_out.txt"));//prepare to write to the file
	   
	   while(input.hasNextLine()) {//while loop each line
      
		   String line = input.nextLine();
         
		   Scanner scanLine = new Scanner(line);
		  
         while(scanLine.hasNext()) {//while loop for lines that have information
         
			   double totalSal = 0;//declare total salary
			   String name = scanLine.next();//read name from file
			   double salary = scanLine.nextDouble();//read salary from file 
			   int hours = 0;//declare hours
			   
            while(scanLine.hasNextInt()) {//while loop to find the total number of hours
				   hours += scanLine.nextInt();
			   }
			   
            totalSal = Math.round(salary*hours*100.0)/100.0; //round up number to decimal 2 points
			   if(totalSal > 400) {//if clause for a person has a gross pay of $400 or more 
				   out.println(name+" worked for a total of: "+hours+" hours at $"+
		                   salary +" an hour for a gross pay of $"+(totalSal)+
                         ".After 33% taxes their total net pay should be $"+
                          Math.round(salary * hours * 0.67 * 100.0 )/100.0 +".");
               out.println("");
			   }
			   else {
				   out.println(name+" worked for a total of: "+hours+" hours at $"+
		                   salary +" an hour for a gross pay of $"+(totalSal)+
                         ".After 25% taxes their total net pay should be $"+ 
                         Math.round(salary * hours * 0.75 * 100.0) / 100.0+".");
               out.println("");

			   }
			   
		   }
	   }//end while loop for each line
		
	}//end  main
	

}//end class
