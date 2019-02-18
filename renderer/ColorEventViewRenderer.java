package renderer;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import calendartableview.CalendarModelTable;
import calendartableview.CalendarTable;
import calendartableview.CalendarTableView;
import model.CalendarEvent;

public class ColorEventViewRenderer extends CalendarTableViewRenderer {
	private ArrayList<CalendarEvent> ceEvents;
	
	public ColorEventViewRenderer (CalendarTableView ctvTableView, int nMonth, int nYear, ArrayList<CalendarEvent> ceEvents) {
		super(ctvTableView, nMonth, nYear);
		this.ceEvents = ceEvents;
		displayTable();
	}
	
	public void setCalendarEvents (ArrayList<CalendarEvent> ceEvents) {
		this.ceEvents = ceEvents;
		displayTable();
	}
	
	public void modelTable() {
		int nNod, nSom;
		GregorianCalendar gcCal = new GregorianCalendar(nYear, nMonth, 1);
		CalendarModelTable cmtCalendarModel = ctvTableView.getCalendarModel();
		
		for (int i = 0; i < 6; i++)
			for (int j = 0; j < 7; j++)
				cmtCalendarModel.setValueAt(null, i, j);
		
		nNod = gcCal.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
		nSom = gcCal.get(GregorianCalendar.DAY_OF_WEEK);
		
		for (int i = 1; i <= nNod; i++) {
			int row = new Integer((i+nSom-2)/7);
			int column  =  (i+nSom-2)%7;
			boolean bEventFound = false;
			
			for (int j = 0; j < ceEvents.size() && !bEventFound; j++)
				if (ceEvents.get(j).equalToEventDate(nMonth, i, nYear)) {
					cmtCalendarModel.setValueAt("<html>" + i + "<br>" + ceEvents.get(j).getEventName() + "</html>", row, column);
					bEventFound = true;
				}
			if (!bEventFound)
				cmtCalendarModel.setValueAt("<html>" + i + "<br>" + "</html>", row, column);
				
		}
	}

	public void renderTable() {
		CalendarTable ctCalendarTable = ctvTableView.getCalendarTable();
		CalendarModelTable cmtCalendarModel = ctvTableView.getCalendarModel();
		ctCalendarTable.setDefaultRenderer(ctCalendarTable.getColumnClass(0), new TableRenderer (nMonth, nYear, ceEvents, cmtCalendarModel));
	}
	
	
}
