package com.dollars4scholars.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.dollars4scholars.R;

public class PlannerActivity extends Activity {

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
		TextView fake = (TextView) findViewById(R.id.fake);
		fake.setText(getIntent().getStringExtra(SCHOLARSHIP_ID));
	}
}