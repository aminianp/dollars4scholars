package com.dollars4scholars.listeners;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

public class ApplyButtonListener implements OnClickListener {

	private String id;

	public ApplyButtonListener(String id) {
		this.id = id;
	}
	
	@Override
	public void onClick(View view) {
		Toast.makeText(view.getContext(), "Though Shalt Apply: " + id , Toast.LENGTH_SHORT).show();
	}
	
}