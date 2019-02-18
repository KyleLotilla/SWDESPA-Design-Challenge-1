package model;
import java.util.*;

import observers.Observer;

public abstract class Subject {
	private ArrayList<Observer> oObserverList;
	
	public Subject () {
		oObserverList = new ArrayList<Observer>();
	}
	public void attach (Observer o) {
		oObserverList.add(o);
	}
	
	public void detach (Observer o) {
		oObserverList.remove(o);
	}
	
	public void notifyObservers () {
		for (Observer oIndex: oObserverList) {
			oIndex.update(this);
		}
	}
}
