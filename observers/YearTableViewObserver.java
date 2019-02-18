package observers;

import model.Subject;
import model.YearSelected;
import renderer.CalendarTableViewRenderer;

public class YearTableViewObserver implements Observer {
	CalendarTableViewRenderer ctvrTableRenderer;
	
	public YearTableViewObserver (CalendarTableViewRenderer ctvrTableRenderer) {
		this.ctvrTableRenderer = ctvrTableRenderer;
	}

	public void update(Subject subChanged) {
		ctvrTableRenderer.setYear(((YearSelected)subChanged).getYear());
	}
}
