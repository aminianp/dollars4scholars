package com.dollars4scholars.models;

public class Scholarship {

	private String id;
	private String name;
	private String dueDate;
	private boolean isOnTrack;
	private boolean isFavourite;

	public String getId() {
		return id;
	}

	public String getDueDate() {
		return dueDate;
	}

	public String getName() {
		return name;
	}

	public boolean isOnTrack() {
		return isOnTrack;
	}

	public boolean isFavourite() {
		return isFavourite;
	}

}