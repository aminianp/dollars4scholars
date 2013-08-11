package com.dollars4scholars.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.dollars4scholars.adapters.ScholarshipsAdapter;
import com.dollars4scholars.models.Scholarship;
import com.dollars4scholars.utils.JSONFactory;
import com.example.dollars4scholars.R;
import com.google.gson.Gson;

public class ScholarshipsFragment extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_scholarships, container, false);
		ListView scholarship = (ListView) view.findViewById(R.id.scholarships);
		Scholarship[] scholarships = parseResponse(JSONFactory.getScholarships());
		scholarship.setAdapter(new ScholarshipsAdapter(scholarships));
		return view;
	}

	private Scholarship[] parseResponse(String scholarships) {
		Gson gson = new Gson();
		Log.d("Scholarship", "Hello: " + scholarships);
		return gson.fromJson(scholarships, Scholarship[].class);
	}

}