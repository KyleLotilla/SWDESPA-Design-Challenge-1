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
	
	public TableRenderer (int nMonth, int nYear, ArrayList<CalendarEvent> ceEvents) {
		super();
		this.nMonth = nMonth;
		this.nYear = nYear;
		this.ceEvents = ceEvents;
	}
	
    public Component getTableCellRendererComponent (JTable table, Object value, boolean selected, boolean focused, int row, int column)
    {
    	super.getTableCellRendererComponent(table, value, selected, focused, row, column);
            
    	/*String sDay = (String) cmtCalendarModel.getValueAt(row, column);
    	String sParsed[] = sDay.split("\n", 1);
    	int nDay = Integer.parseInt(sParsed[0])
    	boolean bEventFound = false;
    	
    	for (int i = 0; i < ceEvents.size() && !bEventFound; i++)
    		if (ceEvents.get(i).equalToEventDate(nMonth, nDay, nYear)) {
    			setBackground(ceEvents.get(i).getColor());
    			bEventFound = true;
    		}
    	if (!bEventFound) {
	    	if (column == 0 || column == 6)
	    		setBackground(new Color(220,220,255));
	        else
	            setBackground(Color.WHITE);
    	} */
    	if (column == 0 || column == 6)
    		setBackground(new Color(220,220,255));
        else
            setBackground(Color.WHITE);
        setBorder(null);
        setForeground(Color.black);
        return this;  
    }
}
