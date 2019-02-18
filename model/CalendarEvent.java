package model;

import java.awt.Color;

public class CalendarEvent {
	private int nMonth;
	private int nDay;
	private int nYear;
	private Color cColor;
	private String sEventName;
	
	public CalendarEvent (int nMonth, int nDay, int nYear, Color cColor, String sEventName) {
		this.nMonth = nMonth;
		this.nDay = nDay;
		this.nYear = nYear;
		this.cColor = cColor;
		this.sEventName = sEventName;
	}
	
	public boolean equalToEventDate (int nMonth, int nDay, int nYear) {
		if (this.nMonth == nMonth && this.nDay == nDay && this.nYear == nYear)
			return true;
		else
			return false;
	}
	
	public String getEventName() {
		return sEventName;
	}
	
	public Color getColor () {
		return cColor;
	}
}
