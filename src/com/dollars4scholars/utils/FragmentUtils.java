package com.dollars4scholars.utils;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;

import com.dollars4scholars.fragment.ScholarshipsFragment;
import com.example.dollars4scholars.R;

public class FragmentUtils {
	
	public static String getScholarships() {		
		return "{ \"id\": 1, \"jsonrpc\": \"2.0\", \"total\": 6, \"result\": [ { \"id\": \"5644a6dd-e38d-40c7-8aee-4092c9626869\", \"name\": \"Luella Sears Scholarship\", \"isOnTrack\": false, \"isFavourite\": false, \"dueDate\": \"2006-07-17\" }, { \"id\": \"507534b9-76ed-4bde-bb58-fa394225b674\", \"name\": \"Harrison Burt Scholarship\", \"isOnTrack\": true, \"isFavourite\": true, \"dueDate\": \"1990-10-13\" }, { \"id\": \"a510a5b5-f307-4974-96a0-0dabae04c467\", \"name\": \"Eliza Monroe Scholarship\", \"isOnTrack\": false, \"isFavourite\": true, \"dueDate\": \"1996-05-05\" }, { \"id\": \"6eaff7bd-4e2c-4099-8a8a-d2a9a34fc604\", \"name\": \"Lamb Boyd Scholarship\", \"isOnTrack\": false, \"isFavourite\": false, \"dueDate\": \"2000-10-13\" }, { \"id\": \"819d211a-0fba-4f08-84e6-10ef28e861f2\", \"name\": \"Rosalinda Kinney Scholarship\", \"isOnTrack\": false, \"isFavourite\": false, \"dueDate\": \"2002-11-18\" }, { \"id\": \"9f8385b7-5e41-4a52-869b-9a8c1aba7f5e\", \"name\": \"Mcintosh Moon Scholarship\", \"isOnTrack\": false, \"isFavourite\": true, \"dueDate\": \"2002-02-01\" } ]}";	
	}

	public static Fragment pushScholarshipsFragment(FragmentActivity activity) {
		ScholarshipsFragment fragment = new ScholarshipsFragment();
		replaceFragment(activity, fragment);
		return fragment;
	}

	private static void replaceFragment(FragmentActivity activity, Fragment fragment) {
		FragmentTransaction transaction = activity.getSupportFragmentManager().beginTransaction();
		transaction.replace(R.id.content_frame, fragment);
		transaction.addToBackStack(null);
		transaction.commit();
	}
}