package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;

import importevents.EventImporter;
import model.CalendarEvent;
import model.CalendarEventList;

public class ImportBtn extends JButton {
	private EventImporter eiImporter;
	private CalendarEventList celCalendarEvents;
	
	public ImportBtn (String sButtonName, EventImporter eiImporter, CalendarEventList celCalendarEvents) {
		super(sButtonName);
		this.eiImporter = eiImporter;
		this.celCalendarEvents = celCalendarEvents;
		addActionListener(new ImportBtnListener());
	}
	
	private class ImportBtnListener implements ActionListener {

		public void actionPerformed(ActionEvent aeAction) {
			ArrayList<CalendarEvent> ceTemp = eiImporter.importEvents();
			
			if (ceTemp != null)
				celCalendarEvents.setCalendarEventList(ceTemp);
		}
		
	}
}
