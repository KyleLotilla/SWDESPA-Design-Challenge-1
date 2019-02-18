package calendartableview;

import javax.swing.table.DefaultTableModel;

public class CalendarModelTable extends DefaultTableModel {
	public CalendarModelTable () {
		super();
		String[] headers = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"}; //All headers
		for (int i=0; i<7; i++){
			super.addColumn(headers[i]);
		}
		super.setColumnCount(7);
		super.setRowCount(6);
	}
	
	public boolean isCellEditable(int rowIndex, int mColIndex)
    {
        return true;
    }
}
