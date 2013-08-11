package com.dollars4scholars.listeners;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

import com.dollars4scholars.activities.PlannerActivity;
import com.example.dollars4scholars.R;

public class AlertButtonListener implements OnClickListener {

	private String scholarshipId;
	private FragmentActivity activity;

	public AlertButtonListener(String scholarshipId, FragmentActivity activity) {
		this.activity = activity;
		this.scholarshipId = scholarshipId;
	}

	@Override
	public void onClick(View view) {
		showTrackerAlert();
		Toast.makeText(activity, "Dat Scholarship: " + scholarshipId, Toast.LENGTH_SHORT).show();
	}

	private void showTrackerAlert() {
		AlertDialog.Builder builder = new AlertDialog.Builder(activity);
		builder.setTitle(activity.getString(R.string.uh_oh));
		builder.setMessage(activity.getString(R.string.tracker_alert));
		builder.setPositiveButton(activity.getString(R.string.help), new AlertTrackerListener(activity));
		builder.setNegativeButton(activity.getString(R.string.forget_it), new AlertTrackerListener(activity));
		builder.show();
	}

	private class AlertTrackerListener implements DialogInterface.OnClickListener {

		private FragmentActivity activity;

		public AlertTrackerListener(FragmentActivity activity) {
			this.activity = activity;
		}

		@Override
		public void onClick(DialogInterface dialog, int which) {
			switch (which) {
				case DialogInterface.BUTTON_POSITIVE:
					PlannerActivity.newInstance(activity, scholarshipId);
					dialog.dismiss();
					break;

				case DialogInterface.BUTTON_NEGATIVE:
					dialog.dismiss();
					break;

				default:
					break;
			}
		}

	}
}