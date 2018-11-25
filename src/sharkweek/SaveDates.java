package sharkweek;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

public class SaveDates {
	//Der Constructur wurde überladen, sodass man auch nur einen Tag speichern kann in der man Menstruiert
	public SaveDates(Date firstDate) {
		//Führt die Hauptfunktion(Construktor) mit dem selber von/bis Wert aus
		this(firstDate, firstDate);
	}
	//Dies ist der eigendliche Construktur(Hauptfunktion)
	public SaveDates(Date firstDate, Date endDate){
		//Ein Filewriter wird Initialisiert
		FileWriter daysFile;
		try {
			//Der Speicherort der wird definiert. Dieser ist als konstante Variable in Sharkweek.class definiert
			daysFile = new FileWriter(Sharkweek.FILE_LOCATION, true);
			
			//In das werden die Von/Bis werte auf addiert und als String gespeichert
			String[] days = dateArray(firstDate, endDate);
			
			//Das einzele Datum wird mit einem Komma getrennt und untereinander gespeichert
			for(int i = 0; i < days.length; i++)
			{
				daysFile.append(days[i]);
				daysFile.append(",");
			}
			//Am Ende wird ein "New Line" angehängt
			daysFile.append("\n");
			daysFile.flush();//Die Buffer Spülung ^^
			//File Writer wird gesch
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
