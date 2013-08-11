package com.dollars4scholars.models;

public class Scholarship {

	private String id;
	private String name;
	private boolean isOnTrack;
	private boolean isFavourite;
	private String dueDate;

	public Scholarship(String id, String name, boolean isOnTrack, boolean isFavourite, String dueDate) {
		this.id = id;
		this.name = name;
		this.dueDate = dueDate;
		this.isOnTrack = isOnTrack;
		this.isFavourite = isFavourite;
	}

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