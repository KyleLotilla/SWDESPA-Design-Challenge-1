/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package renderer;

import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

import calendartableview.CalendarModelTable;
import model.CalendarEvent;

/**
 *
 * @author Arturo III
 */
public class TableRenderer extends DefaultTableCellRenderer
{
	private int nMonth;
	private int nYear;
	private ArrayList<CalendarEvent> ceEvents;
	private CalendarModelTable cmtCalendarModel;
	
	public TableRenderer (int nMonth, int nYear, ArrayList<CalendarEvent> ceEvents, CalendarModelTable cmtCalendarModel) {
		super();
		this.nMonth = nMonth;
		this.nYear = nYear;
		this.ceEvents = ceEvents;
		this.cmtCalendarModel = cmtCalendarModel;
	}
	
    public Component getTableCellRendererComponent (JTable table, Object value, boolean selected, boolean focused, int row, int column)
    {
    	super.getTableCellRendererComponent(table, value, selected, focused, row, column);
        
    	boolean bEventFound = false;
    	String sDay = (String) cmtCalendarModel.getValueAt(row, column);
    	
    	if (sDay != null) {
	    	String sParsed[] = sDay.split("\\<html>|<br>");
	    	int nDay = Integer.parseInt(sParsed[1]);
	    	
	    	for (int i = 0; i < ceEvents.size() && !bEventFound; i++)
	    		if (ceEvents.get(i).equalToEventDate(nMonth, nDay, nYear)) {
	    			setBackground(ceEvents.get(i).getColor());
	    			bEventFound = true;
	    		}
    	}
    	
    	if (!bEventFound) {
	    	if (column == 0 || column == 6)
	    		setBackground(new Color(220,220,255));
	        else
	            setBackground(Color.WHITE);
    	}
    	
        setBorder(null);
        setForeground(Color.black);
        return this;  
    }
}
