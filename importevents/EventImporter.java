package importevents;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import model.CalendarEvent;

public abstract class EventImporter {
	public ArrayList<CalendarEvent> importEvents() {
		openData();
		ArrayList<CalendarEvent> ceEvents = parseData();
		closeData();
		return ceEvents;
	}
	public abstract void openData();
	public abstract ArrayList<CalendarEvent> parseData();
	public abstract void closeData();
}
