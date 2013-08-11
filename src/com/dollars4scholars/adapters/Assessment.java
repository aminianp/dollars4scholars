package com.dollars4scholars.adapters;

import java.util.Locale;

public class Assessment {

	private final String title;
	private final float mark;

	public Assessment(String title, float mark) {
		this.title = title;
		this.mark = mark;
	}
	
	@Override
	public String toString() {
		return String.format(Locale.CANADA, "%s: %.2f%%", title, mark);
	}

}
