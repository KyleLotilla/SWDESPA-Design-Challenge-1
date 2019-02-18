package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.GregorianCalendar;

import javax.swing.JComboBox;

import model.Subject;
import model.YearSelected;
import observers.Observer;

public class YearCmb extends JComboBox implements Observer {
	private YearSelected ysYear;
	
	public YearCmb (YearSelected ysYear) {
		this.ysYear = ysYear;
		ysYear.attach(this);
		
		GregorianCalendar gcCal = new GregorianCalendar();
		int nCurYear = gcCal.get(GregorianCalendar.YEAR);
		for (int i = nCurYear-100; i <= nCurYear+100; i++) {
			this.addItem(String.valueOf(i));
		}
		
		super.setSelectedItem("" + ysYear.getYear());
		super.addActionListener(new YearCmbListener());
	}
	
	class YearCmbListener implements ActionListener {
		public void actionPerformed (ActionEvent e) {
			if (YearCmb.this.getSelectedItem() != null) {
				String sYearSelected = YearCmb.this.getSelectedItem().toString();
				ysYear.setYear(Integer.parseInt(sYearSelected));
            }
		}
	}

	public void update(Subject subChanged) {
		super.setSelectedItem("" + ysYear.getYear());
	}
}
