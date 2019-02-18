package controller;

import java.awt.Color;

public enum ColorString {
	WHITE (Color.WHITE),
	RED (Color.RED),
	GREEN (Color.GREEN),
	BLUE (Color.BLUE),
	YELLOW (Color.YELLOW);
	
	private Color cColor;
	
	ColorString(Color cColor) {
		this.cColor = cColor;
	}
	
	public Color getColor() {
		return cColor;
	}
}
