package com.dollars4scholars.utils;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.dollars4scholars.fragment.ScholarshipsFragment;
import com.example.dollars4scholars.R;

public final class FragmentHelper {

	private Fragment activeFragment;
	private FragmentManager fragmentManager;
	
	public static FragmentHelper newInstance(FragmentActivity activity) {
		return new FragmentHelper(activity.getSupportFragmentManager());
	}
	
	private FragmentHelper(FragmentManager fragmentManager) {
		this.fragmentManager = fragmentManager;
	}

	public void pushScholarshipsFragment() {
		if (activeFragment instanceof ScholarshipsFragment)
			return;

		activeFragment = new ScholarshipsFragment();
		replaceActiveFragment();
	}

	private void replaceActiveFragment() {
		FragmentTransaction transaction = fragmentManager.beginTransaction();
		transaction.replace(R.id.content_frame, activeFragment);
		transaction.addToBackStack(null);
		transaction.commit();
	}
}