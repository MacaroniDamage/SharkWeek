package sharkweek;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Calendar;

public class PeriodCalendar { 
	//Verschiedene Farben
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";
	//Hintergrundfarbe Rot vordergrund Grün
	public static final String BACKGROUND_GREEN_RED = "\u001B[32;41;1m";
	
	private static final String MONTH = null;
	
	private ArrayList<Calendar> periodRecords;
	
	   /**********************************************
	    *  Given the month, day, and year, return which day
	    *  of the week it falls on according to the Gregorian calendar.
	    *  For month, use 1 for January, 2 for February, and so forth.
	    *  Returns 0 for Sunday, 1 for Monday, and so forth.
	    ***************************************************************************/
	    public static int day(int month, int day, int year) {
	        int y = year - (14 - month) / 12;
	        int x = y + y/4 - y/100 + y/400;
	        int m = month + 12 * ((14 - month) / 12) - 2;
	        int d = (day + x + (31*m)/12) % 7;
	        return d;
	    }

	    // return true if the given year is a leap year
	    public static boolean isLeapYear(int year) {
	        if  ((year % 4 == 0) && (year % 100 != 0)) return true;
	        if  (year % 400 == 0) return true;
	        return false;
	    }

	    public void printMonth(
	    	int month,
	    	int year ) {
	        // months[i] = name of month i
	        String[] months = {
	            "",                               // leave empty so that months[1] = "January"
	            "January", "February", "March",
	            "April", "May", "June",
	            "July", "August", "September",
	            "October", "November", "December"
	        };

	        // days[i] = number of days in month i
	        int[] days = {
	            0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31
	        };

	        // check for leap year
	        if (month == 2 && isLeapYear(year)) days[month] = 29;


	        // print calendar header
	        System.out.println(ANSI_BLUE + "   " + months[month] + " " + year + ANSI_RESET);
	        System.out.println(ANSI_CYAN + "Su Mo Tu We Th Fr Sa" + ANSI_RESET);

	        // starting day
	        int d = day(month, 1, year);

	        // print the calendar
	        for (int i = 0; i < d; i++)
	            System.out.print("   ");
	        for (int i = 1; i <= days[month]; i++) {
	        	// 5. Tag anders faerben
	        	if (isPeriod(i, month, year)) {
	            	System.out.printf(BACKGROUND_GREEN_RED + "%2d " + ANSI_RESET, i);
	            	if (((i + d) % 7 == 0) || (i == days[month])) System.out.println();
	        	}
	        	else {
	        		System.out.printf(ANSI_GREEN + "%2d " + ANSI_RESET, i);
	            	if (((i + d) % 7 == 0) || (i == days[month])) System.out.println();
	        		
	        	}
	        }
	        
	    }
	    
	    public void printCalendar() {
	    	Calendar newDate = Calendar.getInstance();
	    	
	    	for(int i = -12; i <= 0; i++)
	    	{
	    		newDate = Calendar.getInstance();
	    		newDate.add(Calendar.MONTH,  i);
	    		printMonth(newDate.get(Calendar.MONTH) + 1, newDate.get(Calendar.YEAR));
	    	}
	    }
	    
	    public PeriodCalendar(ArrayList<Calendar> periodRecords) {
	    	this.periodRecords = periodRecords;
	    }
	    
	    private boolean isPeriod(int day, int month, int year) {
	    	
	    	boolean exists = false;
	    	Iterator<Calendar> itr = periodRecords.iterator();
	    	int periodYear = 0; 
	    	int periodMonth = 0; 
	    	int periodDay = 0; 
	    	
	    	while(itr.hasNext()) {
	    		Calendar c = itr.next();
	    		periodYear = c.get(Calendar.YEAR);
	    		periodMonth = c.get(Calendar.MONTH) + 1 ;
	    		periodDay = c.get(Calendar.DAY_OF_MONTH);
	    		
	    		if(periodYear == year && periodMonth == month && periodDay == day) {
	    			exists = true;
	    		}
	    	}
	    	
	    	return exists; 
	    	 
	    }
	    // print whole year
//	    public static void main(String args[]) {
//	    	printCalendar(1, 2018);
//	    	printCalendar(2, 2018);
//	    	printCalendar(3, 2018);
//	    	printCalendar(4, 2018);
//	    	printCalendar(5, 2018);
//	    	printCalendar(6, 2018);
//	    	printCalendar(7, 2018);
//	    	printCalendar(8, 2018);
//	    	printCalendar(9, 2018);
//	    	printCalendar(10, 2018);
//	    	printCalendar(11, 2018);
//	    	printCalendar(12, 2018);
//	    	
//	    }
	    
	    
	}