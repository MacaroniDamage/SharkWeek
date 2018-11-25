package sharkweek;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

public class SaveDates {
	public SaveDates(Date firstDate) {
		this(firstDate, firstDate);
	}
	public SaveDates(Date firstDate, Date endDate){
		
		FileWriter daysFile;
		try {
			daysFile = new FileWriter(Sharkweek.FILE_LOCATION, true);

			String[] days = dateArray(firstDate, endDate);
			
			for(int i = 0; i < days.length; i++)
			{
				daysFile.append(days[i]);
				daysFile.append(",");
			}
			daysFile.append("\n");
			daysFile.flush();//Die Buffer Spülung ^^
			daysFile.close();
			
			System.out.println("Speichern erfolgreich!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Fehler beim Speichern der Werte!");
		}
	}
	
	public String[] dateArray(Date firstDate, Date endDate) {
		//Date Format
		String pattern = "dd-MM-yyyy";
	    SimpleDateFormat format = new SimpleDateFormat(pattern);
		
		long diff = getDifferenceDays(firstDate, endDate);
		String[] days = new String[(int) diff + 1];
		Calendar c = Calendar.getInstance();
		c.setTime(firstDate);
		
		for(int i = 0; i <= diff; i++)
		{
			days[i] = format.format(c.getTime());
			c.add(Calendar.DATE, 1);
		}
		return days;
	}
	public static long getDifferenceDays(Date d1, Date d2) {
		long diff = d2.getTime() - d1.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
		}
}
