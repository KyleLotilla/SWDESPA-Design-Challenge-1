package controller;

import java.awt.event.*;

import javax.swing.*;

import model.*;

public class AddEventBtn extends JButton {
	private MonthSelected msMonth;
	private YearSelected ysYear;
	private CalendarEventList celCalendarEvents;
	
	public AddEventBtn (MonthSelected msMonth, YearSelected ysYear, CalendarEventList celCalendarEvents) {
		super("Add Event");
		this.msMonth = msMonth;
		this.ysYear = ysYear;
		this.celCalendarEvents = celCalendarEvents;
		addActionListener(new AddEventListener());
	}
	
	private class AddEventListener implements ActionListener {
		public void actionPerformed(ActionEvent aeAction) {
			AddEventWindow aewEventWindow = new AddEventWindow(celCalendarEvents, msMonth.getMonth(), ysYear.getYear());
			aewEventWindow.setVisible(true);
		}
	}
}
