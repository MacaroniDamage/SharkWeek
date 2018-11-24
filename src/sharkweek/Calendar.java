package sharkweek;

public class Calendar { 
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
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

	    public static void printCalendar(
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
	        System.out.println("   " + months[month] + " " + year);
	        System.out.println(ANSI_RED + "Su Mo Tu We Th Fr Sa" + ANSI_RESET);

	        // starting day
	        int d = day(month, 1, year);

	        // print the calendar
	        for (int i = 0; i < d; i++)
	            System.out.print("   ");
	        for (int i = 1; i <= days[month]; i++) {
	            System.out.printf("%2d ", i);
	            if (((i + d) % 7 == 0) || (i == days[month])) System.out.println();
	        }
	        
	    }
	    // print whole year
	    public static void main(String args[]) {
	    	printCalendar(1, 2018);
	    	printCalendar(2, 2018);
	    	printCalendar(3, 2018);
	    	printCalendar(4, 2018);
	    	printCalendar(5, 2018);
	    	printCalendar(6, 2018);
	    	printCalendar(7, 2018);
	    	printCalendar(8, 2018);
	    	printCalendar(9, 2018);
	    	printCalendar(10, 2018);
	    	printCalendar(11, 2018);
	    	printCalendar(12, 2018);
	    	
	    	
	    }
	}