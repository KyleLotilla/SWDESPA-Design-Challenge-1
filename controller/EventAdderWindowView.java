package controller;

import model.CalendarEventList;
import model.MonthSelected;
import model.YearSelected;

public class EventAdderWindowView extends EventAdder {
	private CalendarEventList celCalendarEvents;
	private MonthSelected msMonth;
	private YearSelected ysYear;
	
	public EventAdderWindowView (CalendarEventList celCalendarEvents, MonthSelected msMonth, YearSelected ysYear) {
		super(celCalendarEvents);
		this.msMonth = msMonth;
		this.ysYear = ysYear;
		this.celCalendarEvents = celCalendarEvents;
	}
	
	public void addEvent() {
		AddEventWindow aewEventWindow = new AddEventWindow(celCalendarEvents, msMonth.getMonth(), ysYear.getYear());
	}
}
