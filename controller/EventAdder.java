package controller;

import model.CalendarEventList;

public abstract class EventAdder {
	private CalendarEventList celCalendarEvents;
	
	public EventAdder(CalendarEventList celCalendarEvents) {
		this.celCalendarEvents = celCalendarEvents;
	}
	
	public abstract void addEvent();
}
