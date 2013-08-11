package com.dollars4scholars.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.dollars4scholars.adapters.ScholarshipsAdapter;
import com.dollars4scholars.utils.Api;
import com.example.dollars4scholars.R;

public class ScholarshipsFragment extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_scholarships, container, false);
		ListView scholarship = (ListView) view.findViewById(R.id.scholarships);
		scholarship.setAdapter(new ScholarshipsAdapter(Api.getScholarships(), getActivity()));
		return view;
	}

}