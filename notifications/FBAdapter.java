package notifications;

import facebook.FBView;
import model.CalendarEvent;

public class FBAdapter implements EventNotifier {

	public void notifyEvent(CalendarEvent ceEvent) {
		FBView fbWindow = new FBView();
		fbWindow.showNewEvent(ceEvent.getEventName(), ceEvent.getMonth() + 1, ceEvent.getDay(), ceEvent.getYear(), ceEvent.getColor());
	}
	
}
