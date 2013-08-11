package com.dollars4scholars.utils;

import com.dollars4scholars.adapters.Course;
import com.dollars4scholars.models.Scholarship;

public final class Api {
	private Api() {}

	private static final Scholarship[] SCHOLARSHIPS = new Scholarship[] {
		new Scholarship("5644a6dd-e38d-40c7-8aee-4092c9626869", "Luella Sears Scholarship", false, false, "2006-07-17"),
		new Scholarship("507534b9-76ed-4bde-bb58-fa394225b674", "Harrison Burt Scholarship", true, true, "1990-10-13"),
		new Scholarship("a510a5b5-f307-4974-96a0-0dabae04c467", "Eliza Monroe Scholarship", false, true, "1996-05-05"),
		new Scholarship("6eaff7bd-4e2c-4099-8a8a-d2a9a34fc604", "Lamb Boyd Scholarship", false, false, "2000-10-13"),
		new Scholarship("819d211a-0fba-4f08-84e6-10ef28e861f2", "Rosalinda Kinney Scholarship", false, false, "2002-11-18"),
		new Scholarship("9f8385b7-5e41-4a52-869b-9a8c1aba7f5e", "Mcintosh Moon Scholarship", false, true, "2002-02-01") };

	private static final Course[] COURSES = new Course[] {
		new Course("MAT140", "Advandced Mathematics"),
		new Course("CSC100", "Introduction to Computer Science"),
		new Course("APS111", "Really bad useless course"),
		new Course("CAL101", "Calculus I"),
		new Course("CAL102", "Calculus II"),
		new Course("CAL103", "Calculus III"), };

	public static Scholarship[] getScholarships() {
		return SCHOLARSHIPS;
	}

	public static Course[] getCourses() {
		return COURSES;
	}

	public static String[] getCourseIds() {
		return new String[] {
			"MAT140",
			"CSC100",
			"APS111",
			"CAL101",
			"CAL102",
			"CAL103" };
	}

	public static Course getCourse(String courseId) {
		Course[] courses = getCourses();
		for (Course course : courses) {
			if (course.getId().equals(courseId))
				return course;
		}
		return null;
	}

}