package calendartableview;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import model.CalendarEventList;
import model.MonthSelected;
import model.YearSelected;

import java.util.*;

public class CalendarTableView extends JPanel {
	private MonthSelectedLabel mslMonthLabel;
	private JLabel labelYear;
	private CalendarModelTable cmtCalendarModel;
	private CalendarTable ctCalendarTable;
	private JScrollPane scrollCalendarPane;
	private NextMonthBtn nbtnNext;
	private PrevMonthBtn pbtnPrev;
	private YearCmb ycmbYear;
	
	public CalendarTableView (MonthSelected msMonth, YearSelected ysYear, CalendarEventList celEvents) {
		super(null);
		super.setBorder(BorderFactory.createTitledBorder("Calendar"));
		super.setBounds(0, 0, 640, 670);
		
		mslMonthLabel = new MonthSelectedLabel(msMonth);
		super.add(mslMonthLabel);
		
		cmtCalendarModel = new CalendarModelTable();
		ctCalendarTable = new CalendarTable(cmtCalendarModel);
		scrollCalendarPane = new JScrollPane(ctCalendarTable);
		super.add(scrollCalendarPane);
		ctCalendarTable.getParent().setBackground(ctCalendarTable.getBackground());
		scrollCalendarPane.setBounds(20, 100, 600, 500);
		
		labelYear = new JLabel("Change Year:");
		super.add(labelYear);
		labelYear.setBounds(20, 610, 160, 40);
		
		nbtnNext = new NextMonthBtn(msMonth, ysYear);
		super.add(nbtnNext);
		nbtnNext.setBounds(520, 50, 100, 50);
		
		pbtnPrev = new PrevMonthBtn(msMonth, ysYear);
		super.add(pbtnPrev);
		pbtnPrev.setBounds(20, 50, 100, 50);
		
		ycmbYear = new YearCmb(ysYear);
		super.add(ycmbYear);
		ycmbYear.setBounds(460, 610, 160, 40);
		
	}
	
	public CalendarModelTable getCalendarModel() {
		return cmtCalendarModel;
	}
	
	public CalendarTable getCalendarTable() {
		return ctCalendarTable;
	}
	
	public MonthSelectedLabel getMonthSelectedLabel() {
		return mslMonthLabel;
	}
	
	public YearCmb getYearCmb() {
		return ycmbYear;
	}
}
