package calendartableview;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import controller.AddEventBtn;
import controller.EventAdderWindowView;
import controller.ImportBtn;
import controller.NextMonthBtn;
import controller.PrevMonthBtn;
import controller.YearCmb;
import importevents.CSVImporter;
import importevents.PSVImporter;
import model.CalendarEventList;
import model.MonthSelected;
import model.YearSelected;

import java.util.*;

public class CalendarTableView extends JPanel {
	private MonthSelectedLabel mslMonthLabel;
	private CalendarModelTable cmtCalendarModel;
	private CalendarTable ctCalendarTable;
	private JScrollPane scrollCalendarPane;
	private NextMonthBtn nbtnNext;
	private PrevMonthBtn pbtnPrev;
	private YearCmb ycmbYear;
	private AddEventBtn aebEvent;
	private ImportBtn ibImportCSV;
	private ImportBtn ibImportPSV;
	
	public CalendarTableView (MonthSelected msMonth, YearSelected ysYear, CalendarEventList celCalendarEvents) {
		super(null);
		setBorder(BorderFactory.createTitledBorder("Calendar"));
		setBounds(0, 0, 1440, 1080);
		
		mslMonthLabel = new MonthSelectedLabel(msMonth);
		add(mslMonthLabel);
		
		cmtCalendarModel = new CalendarModelTable();
		ctCalendarTable = new CalendarTable(cmtCalendarModel);
		scrollCalendarPane = new JScrollPane(ctCalendarTable);
		add(scrollCalendarPane);
		ctCalendarTable.getParent().setBackground(ctCalendarTable.getBackground());
		scrollCalendarPane.setBounds(20, 100, 600, 500);
		
		nbtnNext = new NextMonthBtn(msMonth, ysYear);
		add(nbtnNext);
		nbtnNext.setBounds(520, 50, 100, 50);
		
		pbtnPrev = new PrevMonthBtn(msMonth, ysYear);
		add(pbtnPrev);
		pbtnPrev.setBounds(20, 50, 100, 50);
		
		ycmbYear = new YearCmb(ysYear);
		add(ycmbYear);
		ycmbYear.setBounds(460, 610, 160, 40);
		
		aebEvent = new AddEventBtn(new EventAdderWindowView(celCalendarEvents, msMonth, ysYear));
		add(aebEvent);
		aebEvent.setBounds(460, 660, 160, 40);
		
		ibImportCSV = new ImportBtn("Import CSV", new CSVImporter(), celCalendarEvents);
		add(ibImportCSV);
		ibImportCSV.setBounds(50, 610, 160, 40);
		
		ibImportPSV = new ImportBtn("Import PSV", new PSVImporter(), celCalendarEvents);
		add(ibImportPSV);
		ibImportPSV.setBounds(250, 610, 160, 40);
		
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
