package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import model.MonthSelected;
import model.YearSelected;

public class PrevMonthBtn extends JButton{
	private MonthSelected msMonth;
	private YearSelected ysYear;
		
	public PrevMonthBtn (MonthSelected msMonth, YearSelected ysYear) {
		super("<<");
		this.msMonth = msMonth;
		this.ysYear = ysYear;
		this.addActionListener(new PrevBtnListener());
	}
	
	private class PrevBtnListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			msMonth.decMonth(ysYear);
		}
	}
}

