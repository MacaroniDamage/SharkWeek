package sharkweek;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Calendar;

public class ReadDates {
	private ArrayList<String> file = new ArrayList<String>();
																										    
//This method reads the lines inside the specified file and will safe them inside the ArrayList called "file". This is initialized above.
//This method is a constructor and will be executed every time the class will be executed.
	public ReadDates() {
		
		//This will be initialized before the try-catch call because the code after it can't access it, when it is
		//initialized inside the try-catch call
		BufferedReader br = null;
		try
		{
			//This will save the File in the Object br
			 br = new BufferedReader(new FileReader(Sharkweek.FILE_LOCATION));
		} 
		catch (FileNotFoundException e) 
		{
			//If the File is not existing, it will say that there is no File
			e.printStackTrace();
			System.out.println("Es wurde keine Datei gefunden!");
		}
		
		 
		
		
		//There will be saved the dates as a String
		ArrayList<String> dates = new ArrayList<String>();
		
		//There will be stored a line of the file so it can be compared in the while loop 
		String line = "";
		try
		{
			//This reads every line till there is no data left.
			while((line = br.readLine()) != null) 
			{
				//ArrayList<String>: Says what kind of Object is is
				//line.split: This returns every Date as Array
				//Arrays.asList: This converts the returned Array into an ArrayList
				dates = new ArrayList<String>(Arrays.asList(line.split(",")));
				
				//This will add the Dated to the global ArrayList file 
				file.addAll(dates);
			}
		}
		catch (IOException e) 
		{
			// If something goes wrong, it will return the error on the console
			e.printStackTrace();
		}
		
	}//END of Method ReadDates
	
	//This converts 
	public ArrayList<Calendar> datesAsCalendar(){
		//(NOT SURE) This initializes an iterator. Is is able to save an element of an ArrayList so it can be showed.
		//It reads the information from the global ArrayList "file"
		Iterator<String> itr = file.iterator();
		
		//Initializes a Calender object as a ArrayList, where the Dates from the file will be converted (into an Date from a Sting) and returned
		ArrayList<Calendar> dates = new ArrayList<Calendar>();
		
		//This loop will be executed till the last saved element
		//.hasNext(): This is a function that returns a true or a false.
		//true -> If there is a element left
		//false -> If it was the last element
		while(itr.hasNext()) {
			
			//This Object will be initialized with the actual data.
			Calendar c = Calendar.getInstance();
			
			//The Object will be set to the Time from the File
			//c.setTime: Sets the time of the calendar object "c"
			//Sharkweek.parseDate: This executes the method parseDate() from the class Sharkweek.java 
			//It converts a Sting into a Date object
			//itr.next(): This returns the element of the ArrayList File
			c.setTime(Sharkweek.parseDate(itr.next()));
			
			//It adds the converted element "c" to the ArrayList dates
			dates.add(c);
		}
		
		//After there is no element left it returns the ArrayList, where all dates are saved
		return dates;
	}
	
	//This returns the all saved Information inside the "file".cvs as is was read from the constructur and function ReadDates as a ArrayList
	public ArrayList<String> fileContent(){
		return file;
	}
	
	
	
}
//-----Why an ArrayList?------
//Because it has the ability to save unlimited elements inside.
//The Size hasn't to be declared 
