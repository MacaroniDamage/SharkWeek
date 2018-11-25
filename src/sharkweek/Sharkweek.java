package sharkweek;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Sharkweek {
	public static final String FILE_LOCATION = "periodData.csv";
	
	public static void main(String[] args) {
		
		
		
		int zyklus = 0;
		
		if(args.length > 0) {
			if(args[0].equals("show"))
			{
				System.out.println(args.length);
				if(args.length == 1)
				{
					show();
				}
				else if(args.length > 2)
				{	
					if(args[1].equals("prognosis"))
					{
						if(args.length == 2) 
						{
							showPrognosis(30);
						}
						else if(args.length == 3) 
						{
							//Intervall vom String in ein Integer konvertiert
							zyklus = Integer.parseInt(args[2]);
							//Gibt den gespeicherten Zyklus aus
							System.out.println("Ein neuer Zyklus wurde definiert!");
							System.out.println("Intervall: " + zyklus);
							showPrognosis(zyklus);
						}
					}
				}
			}//END OF ARGUMENT: SHOW
			if(args[0].equals("setperiod"))
			{
				if(args.length == 3) {
					Date firstDate = parseDate(args[1]);
					Date secondDate = parseDate(args[2]);
					
					new SaveDates(firstDate, secondDate);
				}
				else if(args.length == 2) {
					Date firstDate = parseDate(args[1]);
					new SaveDates(firstDate);		
				}
				else {
					System.out.println("");
				}
				
			}
		}//END OF ARGUMENTS
		
	}

	public static Date parseDate(String dateString) {
		  	Date date = null;
		  	String pattern = "dd-MM-yyyy";
		    SimpleDateFormat format = new SimpleDateFormat(pattern);
		    try {
		      date = format.parse(dateString);
		      System.out.println(date);
		    } catch (ParseException e) {
		      System.out.println("Entspricht nicht dem Format");
		      
		    }
		    // formatting
		    System.out.println(format.format(date));
		    return date;
	  }
	
	private static void show() {
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
}
