package calendartableview;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;

public class CalendarTable extends JTable {
	public CalendarTable (CalendarModelTable cmtCalendarModel) {
		super(cmtCalendarModel);

		super.getTableHeader().setResizingAllowed(false);
		super.getTableHeader().setReorderingAllowed(false);

		super.setColumnSelectionAllowed(true);
		super.setRowSelectionAllowed(true);
		super.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		super.setRowHeight(76);
		super.addMouseListener(new TableMouseAdapter());
	}
	
	private class TableMouseAdapter extends MouseAdapter {  
            public void mouseClicked(MouseEvent evt)  
            {  
                int col = CalendarTable.this.getSelectedColumn();  
                int row = CalendarTable.this.getSelectedRow();  
            }
    }
}
