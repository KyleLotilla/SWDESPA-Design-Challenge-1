package importevents;

import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import controller.ColorString;
import model.CalendarEvent;

public class PSVImporter extends EventImporter {
	private File fImportedPSV;
	private Scanner scScanPSV;
		
	public void openData() {
		JFileChooser fileChooserPSV = new JFileChooser();
		FileNameExtensionFilter extenfilterPSV = new FileNameExtensionFilter("PSV Files", "psv");
		fileChooserPSV.setFileFilter(extenfilterPSV);
			
		int nAccepted = fileChooserPSV.showOpenDialog(null);
		if (nAccepted == fileChooserPSV.APPROVE_OPTION)
			fImportedPSV = fileChooserPSV.getSelectedFile();
		else
			fImportedPSV = null;
	}
	
	public ArrayList<CalendarEvent> parseData() {
		ArrayList<CalendarEvent> ceEvents = new ArrayList<CalendarEvent>();
		scScanPSV = null;
		if (fImportedPSV == null)
			ceEvents = null;
		else {
			try {
				scScanPSV = new Scanner(fImportedPSV);
				
				while (scScanPSV.hasNextLine()) {
					String sEvent = scScanPSV.nextLine();
					String sSeparated[] = sEvent.split("\\|");
					String sDate[] = sSeparated[1].split("/");
					String sColor = (sSeparated[2].toUpperCase()).replaceAll(" ", "");
					Color cColor = (ColorString.valueOf(sColor)).getColor();
					
					ceEvents.add(new CalendarEvent(Integer.parseInt(sDate[0].replaceAll(" ", "")) - 1, Integer.parseInt(sDate[1]), Integer.parseInt(sDate[2].replaceAll(" ", "")), cColor, sSeparated[0]));
				}
			} catch (FileNotFoundException e) {}
		}
		return ceEvents;
	}
	
	public void closeData() {
		if (scScanPSV != null)
			scScanPSV.close();
	}
}
