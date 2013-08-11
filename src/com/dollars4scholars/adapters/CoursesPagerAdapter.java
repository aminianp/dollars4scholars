package com.dollars4scholars.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.dollars4scholars.utils.Api;

public final class CoursesPagerAdapter extends FragmentPagerAdapter {
	
	private String[] courseIds;

	public CoursesPagerAdapter(FragmentManager fragmentManager) {
		super(fragmentManager);
		this.courseIds = Api.getCourseIds();
	}

	@Override
	public Fragment getItem(int position) {
		String courseId = courseIds[position];
		return CourseFragment.newInstance(courseId);
	}
	
	@Override
	public int getCount() {
		return courseIds.length;
	}

}
