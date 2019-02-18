package calendartableview;

import javax.swing.JLabel;

import model.MonthSelected;
import model.Subject;
import observers.Observer;

public class MonthSelectedLabel extends JLabel implements Observer {
	private String sMonths[] = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};;
	
	public MonthSelectedLabel (MonthSelected msMonth) {
		super();
		super.setText(sMonths[msMonth.getMonth()]);
		super.setBounds(320-super.getPreferredSize().width/2, 50, 360, 50);
	}

	public void update(Subject subChanged) {
		super.setText(sMonths[((MonthSelected)subChanged).getMonth()]);
		super.setBounds(320-super.getPreferredSize().width/2, 50, 360, 50);
	}
}
