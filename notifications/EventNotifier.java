package notifications;

import model.CalendarEvent;

public interface EventNotifier {
	public void notifyEvent(CalendarEvent ceEvent);
}
