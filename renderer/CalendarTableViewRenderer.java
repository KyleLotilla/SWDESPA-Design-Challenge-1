package renderer;

import calendartableview.CalendarTableView;

public abstract class CalendarTableViewRenderer {
	protected CalendarTableView ctvTableView;
	protected int nMonth;
	protected int nYear;
	
	public CalendarTableViewRenderer (CalendarTableView ctvTableView, int nMonth, int nYear) {
		this.ctvTableView = ctvTableView;
		this.nMonth = nMonth;
		this.nYear = nYear;
	}
	
	public void setMonth(int nMonth) {
		this.nMonth = nMonth;
		displayTable();
	}
	
	public void setYear (int nYear) {
		this.nYear = nYear;
		displayTable();
	}
	
	public void displayTable () {
		modelTable();
		renderTable();
	}
	
	public abstract void modelTable ();
	public abstract void renderTable();
}
