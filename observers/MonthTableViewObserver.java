package observers;

import model.MonthSelected;
import model.Subject;
import renderer.CalendarTableViewRenderer;

public class MonthTableViewObserver implements Observer {
	CalendarTableViewRenderer ctvrTableRenderer;
	
	public MonthTableViewObserver (CalendarTableViewRenderer ctvrTableRenderer) {
		this.ctvrTableRenderer = ctvrTableRenderer;
	}

	public void update(Subject subChanged) {
		ctvrTableRenderer.setMonth(((MonthSelected)subChanged).getMonth());
	}
}
