package com.dollars4scholars.listeners;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

public class AlertButtonListener implements OnClickListener {

	private String id;

	public AlertButtonListener(String id) {
		this.id = id;
	}
	
	@Override
	public void onClick(View view) {
		Toast.makeText(view.getContext(), "Dat Scholarship: " + id , Toast.LENGTH_SHORT).show();
	}
	
}