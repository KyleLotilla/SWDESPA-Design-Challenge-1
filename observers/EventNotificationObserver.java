package observers;

import model.*;
import notifications.EventNotifier;

import java.util.*;

public class EventNotificationObserver implements Observer {
	private ArrayList<EventNotifier> enAdapters;
	
	public EventNotificationObserver() {
		enAdapters = new ArrayList<EventNotifier>();
	}
	
	public void addAdapters(EventNotifier enNew) {
		enAdapters.add(enNew);
	}
	
	public void update(Subject subChanged) {
		ArrayList<CalendarEvent> ceEvents = ((CalendarEventList) subChanged).getCalendarEventList();
		GregorianCalendar gcCal = new GregorianCalendar();
		boolean bEventFound = false;
		
		for (int i = 0; i < ceEvents.size() && !bEventFound; i++)
			if (ceEvents.get(i).equalToEventDate(gcCal.get(GregorianCalendar.MONTH), gcCal.get(GregorianCalendar.DAY_OF_MONTH), gcCal.get(GregorianCalendar.YEAR))) {
				for (EventNotifier enCounter : enAdapters)
					enCounter.notifyEvent(ceEvents.get(i));
			}
	}

}
