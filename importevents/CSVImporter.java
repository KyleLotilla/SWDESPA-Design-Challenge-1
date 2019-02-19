package importevents;

import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import controller.ColorString;
import model.CalendarEvent;

public class CSVImporter extends EventImporter{
	private File fImportedCSV;
	private Scanner scScanCSV;
	
	public void openData() {
		JFileChooser fileChooserCSV = new JFileChooser();
		FileNameExtensionFilter extenfilterCSV = new FileNameExtensionFilter("CSV Files", "csv");
		fileChooserCSV.setFileFilter(extenfilterCSV);
		
		int nAccepted = fileChooserCSV.showOpenDialog(null);
		
		if (nAccepted == fileChooserCSV.APPROVE_OPTION) {
			fImportedCSV = fileChooserCSV.getSelectedFile();
		}
		else
			fImportedCSV = null;
	}

	
	public ArrayList<CalendarEvent> parseData() {
		ArrayList<CalendarEvent> ceEvents = new ArrayList<CalendarEvent>();
		scScanCSV = null;
		if (fImportedCSV == null)
			ceEvents = null;
		else {
			try {
				scScanCSV = new Scanner(fImportedCSV);
			
				while (scScanCSV.hasNextLine()) {
					String sEvent = scScanCSV.nextLine();
					String sSeparated[] = sEvent.split(",");
					String sDate[] = sSeparated[0].split("/");
					String sColor = (sSeparated[2].toUpperCase()).replaceAll(" ", "");
					Color cColor = (ColorString.valueOf(sColor)).getColor();
					
					ceEvents.add(new CalendarEvent(Integer.parseInt(sDate[0]) - 1, Integer.parseInt(sDate[1]), Integer.parseInt(sDate[2]), cColor, sSeparated[1]));
				}
			} catch (FileNotFoundException e) {}
		}
		return ceEvents;
	}

	
	public void closeData() {
		if (scScanCSV != null)
			scScanCSV.close();
	}
	
}
