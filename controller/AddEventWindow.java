package controller;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import javax.swing.*;

import model.*;

public class AddEventWindow extends JFrame {
	private JTextField textEventName;
	private JComboBox cmbMonth;
	private JComboBox cmbYear;
	private JComboBox cmbDay;
	private JComboBox cmbColor;
	private JButton btnSubmit;
	private CalendarEventList celCalendarEvents;
	
	public AddEventWindow(CalendarEventList celCalendarEvents, int nMonth, int nYear) {
		super("Add Event");
		this.celCalendarEvents = celCalendarEvents;
		setLayout(new FlowLayout());
		setSize(500, 300);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		add(new JLabel("Event Name:"));
		textEventName = new JTextField(40);
		add(textEventName);
		
		
		add(new JLabel("Month:"));
		cmbMonth = new JComboBox();
		String sMonths[] = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
		for (int i = 0; i < sMonths.length; i++)
			cmbMonth.addItem(sMonths[i]);
		cmbMonth.setSelectedIndex(nMonth);
		add(cmbMonth);
		
		
		cmbYear = new JComboBox();
		GregorianCalendar gcCal = new GregorianCalendar();
		int nCurYear = gcCal.get(GregorianCalendar.YEAR);
		for (int i = nCurYear-100; i <= nCurYear+100; i++)
			cmbYear.addItem(String.valueOf(i));
		cmbYear.setSelectedItem(String.valueOf(nYear));
		
		add(new JLabel("Day:"));
		cmbDay = new JComboBox();
		filterDayItems();
		add(cmbDay);
		add(new JLabel("Year:"));
		add(cmbYear);
		
		add(new JLabel("Color:"));
		cmbColor = new JComboBox();
		for (ColorString csCounter : ColorString.values())
			cmbColor.addItem(csCounter.toString());
		add(cmbColor);
		
		btnSubmit = new JButton("Add");
		add(btnSubmit);
		
		ColorEventWindowListener cewlListener = new ColorEventWindowListener();
		cmbMonth.addActionListener(cewlListener);
		cmbYear.addActionListener(cewlListener);
		btnSubmit.addActionListener(cewlListener);
		
		setVisible(true);
	}
	
	private void filterDayItems() {
		int nMonth = cmbMonth.getSelectedIndex();
		int nYear = Integer.parseInt((String)cmbYear.getSelectedItem());
		GregorianCalendar gcCal = new GregorianCalendar(nYear, nMonth, 1);
		int nNod = gcCal.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
		
		cmbDay.removeAllItems();
		cmbDay.setEnabled(true);
		
		for (int i = 1; i <= nNod; i++) {
			boolean bEventFound = false;
			ArrayList<CalendarEvent> ceEvents = celCalendarEvents.getCalendarEventList();
			
			for (int j = 0; j < ceEvents.size() && !bEventFound; j++)
				if (ceEvents.get(j).equalToEventDate(nMonth, i, nYear))
					bEventFound = true;
			
			if (!bEventFound)
				cmbDay.addItem(String.valueOf(i));
		}
		
		if (cmbDay.getItemCount() <= 0)
			cmbDay.setEnabled(false);
		else
			cmbDay.setSelectedIndex(0);
	}
	
	private class ColorEventWindowListener implements ActionListener {
		public void actionPerformed (ActionEvent aeAction) {
			if (aeAction.getSource() == cmbMonth || aeAction.getSource() == cmbYear)
				filterDayItems();
			else if (aeAction.getSource() == btnSubmit) {
				celCalendarEvents.addEvent(cmbMonth.getSelectedIndex(), Integer.parseInt((String)cmbDay.getSelectedItem()), Integer.parseInt((String)cmbYear.getSelectedItem()), 
						(ColorString.valueOf((String)cmbColor.getSelectedItem())).getColor(), textEventName.getText());
				dispose();
			}
		}
	}
}
