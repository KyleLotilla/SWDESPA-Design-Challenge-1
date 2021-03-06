/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package designchallenge1;

/**
 *
 * @author Arturo III
 */

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;

import calendartableview.CalendarTableView;
import model.CalendarEventList;
import model.MonthSelected;
import model.YearSelected;
import notifications.FBAdapter;
import notifications.SMSAdapter;
import observers.ColorEventViewObserver;
import observers.EventNotificationObserver;
import observers.MonthTableViewObserver;
import observers.YearTableViewObserver;
import renderer.ColorEventViewRenderer;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class CalendarProgram{
	
        /**** Model Components ****/
	private MonthSelected msMonth;
	private YearSelected ysYear;
	private CalendarEventList celCalendarEvents;

        /**** Calendar Table View Components ****/
	private CalendarWindow cwWindow;
	private CalendarTableView ctvTableView;
	private ColorEventViewRenderer cevrTableRenderer;
	
	   /**** Observers ****/
	private MonthTableViewObserver mtvoMonthObserver;
	private YearTableViewObserver ytvoYearObserver;
	private ColorEventViewObserver cevoEventsObserver;
	private EventNotificationObserver cnoNotificationObserver;
        
	public CalendarProgram() {
		GregorianCalendar gcCal = new GregorianCalendar();
		msMonth = new MonthSelected(gcCal.get(GregorianCalendar.MONTH));
		ysYear = new YearSelected(gcCal.get(GregorianCalendar.YEAR));
		celCalendarEvents = new CalendarEventList();
		
		cwWindow = new CalendarWindow();
		ctvTableView = new CalendarTableView(msMonth, ysYear, celCalendarEvents);
		cwWindow.add(ctvTableView);
		
		cevrTableRenderer = new ColorEventViewRenderer(ctvTableView, msMonth.getMonth(), ysYear.getYear(), celCalendarEvents.getCalendarEventList());
		mtvoMonthObserver = new MonthTableViewObserver(cevrTableRenderer);
		ytvoYearObserver = new YearTableViewObserver(cevrTableRenderer);
		cevoEventsObserver = new ColorEventViewObserver(cevrTableRenderer);
		cnoNotificationObserver = new EventNotificationObserver();
		
		msMonth.attach(mtvoMonthObserver);
		msMonth.attach(ctvTableView.getMonthSelectedLabel());
		ysYear.attach(ytvoYearObserver);
		ysYear.attach(ctvTableView.getYearCmb());
		celCalendarEvents.attach(cevoEventsObserver);
		celCalendarEvents.attach(cnoNotificationObserver);
		
		cnoNotificationObserver.addAdapters(new SMSAdapter());
		cnoNotificationObserver.addAdapters(new FBAdapter());
		
		cwWindow.setResizable(false);
		cwWindow.setVisible(true);
	}
	
}
