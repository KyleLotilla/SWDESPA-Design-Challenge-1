package controller;

import java.awt.event.*;

import javax.swing.*;

import model.*;

public class AddEventBtn extends JButton {
	private EventAdder eaAdder;
	
	public AddEventBtn (EventAdder eaAdder) {
		super("Add Event");
		this.eaAdder = eaAdder;
		addActionListener(new AddEventListener());
	}
	
	private class AddEventListener implements ActionListener {
		public void actionPerformed(ActionEvent aeAction) {
			eaAdder.addEvent();
		}
	}
}
