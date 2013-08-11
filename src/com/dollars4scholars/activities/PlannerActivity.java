package com.dollars4scholars.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import com.dollars4scholars.adapters.CoursesPagerAdapter;
import com.example.dollars4scholars.R;

public class PlannerActivity extends FragmentActivity {

	private static final String SCHOLARSHIP_ID = "scholarship_id";

	public static void newInstance(Context context, String scholarshipId) {
		Intent intent = new Intent(context, PlannerActivity.class);
		intent.putExtra(SCHOLARSHIP_ID, scholarshipId);
		context.startActivity(intent);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_planner);
		ViewPager pager = (ViewPager) findViewById(R.id.planner_view_pager);
		pager.setAdapter(new CoursesPagerAdapter(getSupportFragmentManager()));
	}
}