package notifications;

import java.util.GregorianCalendar;

import model.CalendarEvent;
import sms.SMS;
import sms.SMSView;

public class SMSAdapter implements EventNotifier {

	public void notifyEvent(CalendarEvent ceEvent) {
		SMS smsNotification = new SMS (ceEvent.getEventName(), new GregorianCalendar(ceEvent.getYear(), 
				ceEvent.getMonth(), ceEvent.getDay()),ceEvent.getColor());
		SMSView smsWindow = new SMSView();
		smsWindow.sendSMS(smsNotification);
	}
	
}
