package model;

public class YearSelected extends Subject{
	private int nYear;
	
	public YearSelected(int nYear) {
		this.nYear = nYear;
	}
	
	public void decYear() {
		this.nYear--;
		notifyObservers();
	}
	
	public void incYear() {
		this.nYear++;
		notifyObservers();
	}
	
	public void setYear(int nYear) {
		this.nYear = nYear;
		notifyObservers();
	}
	
	public int getYear() {
		return nYear;
	}
}
