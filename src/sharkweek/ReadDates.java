package sharkweek;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class ReadDates {
	public ReadDates() {
		BufferedReader br = new BufferedReader(new FileReader(Sharkweek.FILE_LOCATION));
		
		String bufferRow = null;
		int counter = 0;
		String line = "";
		ArrayList File = new ArrayList<String>();
		
		while((line = br.readLine()) != null) {
			//File = add(br.readLine());
			String[] dates = line.split(",");
			File.addAll(dates);
			counter++;
		}
	}
}
