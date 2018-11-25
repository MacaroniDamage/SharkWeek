package test;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {
	  public static void main(String[] args) {
		  
		  Date date = new Date();
		  date.plusDays(1);
		  
	  }
	  private static Date parseDate(String dateString) {
	  	Date date = null;
		String pattern = "MM-dd-yyyy";
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
}
