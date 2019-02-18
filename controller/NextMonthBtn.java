package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import model.MonthSelected;
import model.YearSelected;


public class NextMonthBtn extends JButton {
	private MonthSelected msMonth;
	private YearSelected ysYear;
	
	public NextMonthBtn (MonthSelected msMonth, YearSelected ysYear) {
		super(">>");
		this.msMonth = msMonth;
		this.ysYear = ysYear;
		this.addActionListener(new NextBtnListener());
	}
	
	private class NextBtnListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			msMonth.incMonth(ysYear);
		}
	}
}
