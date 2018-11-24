package test;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {
	  public static void main(String[] args) {
	    String pattern = "MM-dd-yyyy";
	    SimpleDateFormat format = new SimpleDateFormat(pattern);
	    try {
	      Date date = format.parse("12/31-2006");
	      System.out.println(date);
	    } catch (ParseException e) {
	      System.out.println("Entspricht nicht dem Format");
	    }
	    // formatting
	    System.out.println(format.format(new Date()));
	  }
}
