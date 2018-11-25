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
	
	public ReadDates() {
		BufferedReader br = null;
		try {
			//Initialisiert einen 
			br = new BufferedReader(new FileReader(Sharkweek.FILE_LOCATION));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		String line = "";
		
		ArrayList<String> dates = new ArrayList<String>();
		
		try {
			while((line = br.readLine()) != null) {
				dates = new ArrayList<String>(Arrays.asList(line.split(",")));
				file.addAll(dates);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<String> fileContent(){
		return file;
	}
	
	public ArrayList<Calendar> datesAsCalendar(){
		Iterator<String> itr = file.iterator();
		ArrayList<Calendar> dates = new ArrayList<Calendar>();
		
		
		while(itr.hasNext()) {
			Calendar c = Calendar.getInstance();
			
			c.setTime(Sharkweek.parseDate(itr.next()));
			
			dates.add(c);
		}
		
		return dates;
	}
	
}
