package model;

import java.util.GregorianCalendar;

public class MonthSelected extends Subject {
	private int nMonth;
	
	public MonthSelected(int nMonth) {
		this.nMonth = nMonth;
	}
	
	public int getMonthSelected() {
		return nMonth;
	}
	
	public void decMonth(YearSelected ysYear) {
		GregorianCalendar gcCal = new GregorianCalendar();
		if (nMonth == 0) {
			if (ysYear.getYear() == gcCal.get(GregorianCalendar.YEAR) - 100)
				ysYear.setYear(gcCal.get(GregorianCalendar.YEAR) + 100);
			else
				ysYear.decYear();
			nMonth = 11;
		}
		else
			nMonth--;
		notifyObservers();
	}
	
	public void incMonth (YearSelected ysYear) {
		GregorianCalendar gcCal = new GregorianCalendar();
		if (nMonth == 11) {
			if (ysYear.getYear() == gcCal.get(GregorianCalendar.YEAR) + 100)
				ysYear.setYear(gcCal.get(GregorianCalendar.YEAR) - 100);
			else
				ysYear.incYear();
			nMonth = 0;
		}
		else
			nMonth++;
		notifyObservers();
	}
	
	public int getMonth () {
		return nMonth;
	}
}
