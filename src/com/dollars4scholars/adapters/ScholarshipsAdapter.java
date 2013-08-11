package com.dollars4scholars.adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.TextView;

import com.dollars4scholars.listeners.AlertButtonListener;
import com.dollars4scholars.listeners.ApplyButtonListener;
import com.dollars4scholars.models.Scholarship;
import com.example.dollars4scholars.R;

public class ScholarshipsAdapter extends BaseAdapter {

	private final Scholarship[] scholarships;
	private final Activity activity;

	public ScholarshipsAdapter(Scholarship[] scholarships, Activity activity) {
		this.scholarships = scholarships;
		this.activity = activity;
	}

	@Override
	public int getCount() {
		return scholarships != null ? scholarships.length : 0;
	}

	@Override
	public Scholarship getItem(int position) {
		if (scholarships == null) {
			return null;
		}

		return scholarships[position];
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;

		if (convertView == null) {
			LayoutInflater inflater = LayoutInflater.from(parent.getContext());
			convertView = inflater.inflate(R.layout.list_item_scholarship, parent, false);
			holder = new ViewHolder(convertView);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		setViewValues(holder, position);
		return convertView;
	}

	private void setViewValues(ViewHolder holder, int position) {
		Scholarship scholarship = getItem(position);
		String scholarshipId = scholarship.getId();
		
		holder.name.setText(scholarship.getName());
		holder.dueDate.setText(scholarship.getDueDate());
		holder.tracker.setVisibility(scholarship.isOnTrack() ? View.GONE : View.VISIBLE);
		holder.tracker.setOnClickListener(new AlertButtonListener(scholarshipId, activity));
		holder.favourite.setChecked(scholarship.isFavourite());
		holder.apply.setOnClickListener(new ApplyButtonListener(scholarshipId));
	}

	private class ViewHolder {

		private TextView name;
		private TextView dueDate;
		private ImageButton tracker;
		private CheckBox favourite;
		private Button apply;

		public ViewHolder(View convertView) {
			this.name = (TextView) convertView.findViewById(R.id.name);
			this.dueDate = (TextView) convertView.findViewById(R.id.due_date);
			this.tracker = (ImageButton) convertView.findViewById(R.id.tracker);
			this.favourite = (CheckBox) convertView.findViewById(R.id.favourite);
			this.apply = (Button) convertView.findViewById(R.id.apply);
		}
	}
}