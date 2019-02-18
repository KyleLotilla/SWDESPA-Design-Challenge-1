package observers;

import model.CalendarEventList;
import model.Subject;
import renderer.ColorEventViewRenderer;

public class ColorEventViewObserver implements Observer {
	ColorEventViewRenderer cevrTableRenderer;
	
	public ColorEventViewObserver (ColorEventViewRenderer cevrTableRenderer) {
		this.cevrTableRenderer = cevrTableRenderer;
	}

	public void update(Subject subChanged) {
		cevrTableRenderer.setCalendarEvents(((CalendarEventList)subChanged).getCalendarEventList());
	}
}
