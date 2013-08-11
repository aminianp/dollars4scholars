package com.dollars4scholars.listeners;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

import com.dollars4scholars.activities.PlannerActivity;
import com.example.dollars4scholars.R;

public class AlertButtonListener implements OnClickListener {

	private String scholarshipId;

	public AlertButtonListener(String scholarshipId) {
		this.scholarshipId = scholarshipId;
	}

	@Override
	public void onClick(View view) {
		Context context = view.getContext();
		showTrackerAlert(context);
		Toast.makeText(view.getContext(), "Dat Scholarship: " + scholarshipId, Toast.LENGTH_SHORT).show();
	}

	private void showTrackerAlert(Context context) {
		AlertDialog.Builder builder = new AlertDialog.Builder(context);
		builder.setTitle(context.getString(R.string.uh_oh));
		builder.setMessage(context.getString(R.string.tracker_alert));
		builder.setPositiveButton(context.getString(R.string.help), new AlertTrackerListener(context));
		builder.setNegativeButton(context.getString(R.string.forget_it), new AlertTrackerListener(context));
		AlertDialog dialog = builder.create();
		dialog.show();
	}

	private class AlertTrackerListener implements DialogInterface.OnClickListener {

		// FIXME Am I leaking memory here?
		private Context context;

		public AlertTrackerListener(Context context) {
			this.context = context;
		}

		@Override
		public void onClick(DialogInterface dialog, int which) {
			switch (which) {
			case DialogInterface.BUTTON_POSITIVE:
				PlannerActivity.newInstance(context, scholarshipId);
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