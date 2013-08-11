package com.dollars4scholars.adapters;

import java.util.Locale;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.dollars4scholars.utils.Api;
import com.example.dollars4scholars.R;

public final class CourseFragment extends Fragment {

	private static final class Keys {
		private static final String COURSE_ID = "course_id";
	}

	public static CourseFragment newInstance(String courseId) {
		CourseFragment fragment = new CourseFragment();
		Bundle args = new Bundle();
		args.putString(Keys.COURSE_ID, courseId);
		fragment.setArguments(args);
		return fragment;
	}

	private String courseId;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.courseId = getArguments().getString(Keys.COURSE_ID);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		super.onCreateView(inflater, container, savedInstanceState);
		return inflater.inflate(R.layout.fragment_course, container, false);
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		Course course = Api.getCourse(courseId);

		ListView assessments = (ListView) view.findViewById(R.id.course_list_view);
		assessments.setAdapter(new CourseAdapter(course));

		TextView courseInfo = (TextView) view.findViewById(R.id.course_info);
		courseInfo.setText(String.format(Locale.CANADA, "%s - %s", course.getId(), course.getName()));
	}

}
