package com.dollars4scholars.adapters;

import java.util.Arrays;
import java.util.Locale;
import java.util.Random;

public class Course {

	private final String id;
	private final String name;

	private final Assessment[] assessments = new Assessment[] {
		new Assessment("1st Midterm", getRandomMark()),
		new Assessment("2nd Midterm", getRandomMark()),
		new Assessment("1st Assignment", getRandomMark()),
		new Assessment("2nd Assignment", getRandomMark()),
		new Assessment("3rd Assignment", getRandomMark()),
		new Assessment("4th Assignment", getRandomMark()),
		new Assessment("Final", getRandomMark()) };

	public Course(String id, String name) {
		this.name = name;
		this.id = id;
	}

	public int getAssessmentCount() {
		return assessments.length;
	}

	public Assessment getAssessment(int position) {
		return assessments[position];
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return String.format(Locale.CANADA, "%s - %s: \n%s", id, name, Arrays.toString(assessments));
	}

	private static final Random random = new Random();
	private static final float getRandomMark() {
		return random.nextFloat() * 100f;
	}

}
