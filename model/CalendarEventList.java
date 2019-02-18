package model;
import java.awt.Color;
import java.util.*;

public class CalendarEventList extends Subject {
	private ArrayList<CalendarEvent> ceEvents;
	
	public CalendarEventList () {
		ceEvents = new ArrayList<CalendarEvent>();
	}
	
	public void addEvent(int nMonth, int nDay, int nYear, Color cColor, String sEventName) {
		ceEvents.add(new CalendarEvent(nMonth, nDay, nYear, cColor, sEventName));
		notifyObservers();
	}
	
	public CalendarEvent getEventAtDate (int nMonth, int nDay, int nYear) {
		CalendarEvent ceEventFound = null;
		boolean bEventFound = false;
		
		for (int i = 0; i < ceEvents.size() && !bEventFound; i++)
			if (ceEvents.get(i).equalToEventDate(nMonth, nDay, nYear)) {
				ceEventFound = ceEvents.get(i);
				bEventFound = true;
			}
		
		return ceEventFound;
	}
	
	public ArrayList<CalendarEvent> getCalendarEventList() {
		return ceEvents;
	}
	
	public void setCalendarEventList(ArrayList<CalendarEvent> ceEvents) {
		this.ceEvents = ceEvents;
		notifyObservers();
	}
}
