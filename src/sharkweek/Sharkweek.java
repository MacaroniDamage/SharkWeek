package sharkweek;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Sharkweek {
	//Defines the file location of the saved periodData
	public static final String FILE_LOCATION = "periodData.csv";
	
	
	//This is the first Methode that will be executed.
	//"args" is an Array and saves the Arguments that the user made.
	public static void main(String[] args) {
		int zyklus = 0;
		if(args.length > 0) {
			//This Argument will be used to show the calendar
			if(args[0].equals("show"))
			{
				System.out.println(args.length);
				if(args.length == 1)
				{
					//Showes the calendar with saved period Dates
					show();
				}
				else if(args.length > 2)
				{	
					//This will compare the third argument whether is "prognosis"
					if(args[1].equals("prognosis"))
					{
						//Now it shows a self defined time period after menstruation
						if(args.length == 2) 
						{
							showPrognosis(30);
						}
						else if(args.length == 3) 
						{
							//The cycle can be definded, ist will be saved in "zyklus"
							
							//The definded cycle will be converted into an Integer
							zyklus = Integer.parseInt(args[2]);
							
							
							//After saving the self defined cycle it shows the self defined cycle
							showPrognosis(zyklus);
						}
					}
				}
			}//END OF ARGUMENT: SHOW
			
			//The user is able to set its menstruation
			if(args[0].equals("setperiod"))
			{
				//The user can define a timespan that goes at least over a day
				if(args.length == 3) {
					
					//This will get the two defined dates and will convert them into a Date Object
					Date firstDate = parseDate(args[1]);
					Date secondDate = parseDate(args[2]);
					
					//This will executed inside SaveDates
					//This will get the Dates and will save them inside a .csv file 
					//that is defined above.
					new SaveDates(firstDate, secondDate);
				}
				else if(args.length == 2) {
					//If the user defines just one Date, the program will save just one Date
					Date firstDate = parseDate(args[1]);
					new SaveDates(firstDate);		
				}
				else {
					System.out.println("Bitte gebe einen Zeitraum oder wenigstens ein Datum an.");
				}
				
			}
		}//END OF ARGUMENT setperiod
	}//END OF MAIN Function

	public static Date parseDate(String dateString) {
			
		  	Date date = null;
		  	//This specifies a pattern
		  	String pattern = "dd-MM-yyyy";
		  	//This creates an object that can be used to specify a pattern of a date object
		    SimpleDateFormat format = new SimpleDateFormat(pattern);
		    try {
		      date = format.parse(dateString);
		    } catch (ParseException e) {
		      System.out.println("Entspricht nicht dem Format");
		      
		    }
		    //This will convert a Date with the specified pattern above
		    //System.out.println(format.format(date));
		    return date;
	  }
	
	private static void show() {
		//
		ReadDates file = new ReadDates();
		ArrayList<Calendar> dates = file.datesAsCalendar();
		
		PeriodCalendar period = new PeriodCalendar(dates);
		
		period.printCalendar();
	}
	
	private static void showPrognosis(int cycleLength) {
		ReadDates file = new ReadDates();
		ArrayList<Calendar> dates = file.datesAsCalendar();
		
		PeriodCalendar period = new PeriodCalendar(dates);
		period.cycleLength = cycleLength;
		period.prognosis = true;
		
		period.printCalendar();
	}
}//END of class Sharkweek
