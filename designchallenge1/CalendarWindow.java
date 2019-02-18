package designchallenge1;

import java.awt.Container;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;

public class CalendarWindow {
	public JFrame frmMain;
	public Container pane;
	
	public CalendarWindow() {
		try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {}
        
		frmMain = new JFrame ("Calendar Application");
	        frmMain.setSize(660, 750);
		pane = frmMain.getContentPane();
		pane.setLayout(null);
		frmMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	public void add(JComponent compNew) {
		pane.add(compNew);
	}
	
	public void setVisible(boolean bFlag) {
		frmMain.setVisible(bFlag);
	}
	
	public void setResizable(boolean bFlag) {
		frmMain.setResizable(bFlag);
	}
}
