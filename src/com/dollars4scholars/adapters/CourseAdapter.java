package com.dollars4scholars.adapters;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public final class CourseAdapter extends BaseAdapter {

	private Course course;

	public CourseAdapter(Course course) {
		this.course = course;
	}

	@Override
	public int getCount() {
		return course.getAssessmentCount();
	}

	@Override
	public Assessment getItem(int position) {
		return course.getAssessment(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		TextView textView = (TextView) convertView;
		
		if(textView == null)
			textView = new TextView(parent.getContext());
		
		Assessment assessment = getItem(position);
		textView.setText(assessment.toString());
		
		return textView;
	}

}
