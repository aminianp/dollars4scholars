package com.dollars4scholars.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.dollars4scholars.utils.FragmentUtils;
import com.example.dollars4scholars.R;

public class MainActivity extends FragmentActivity {

	private String[] planetTitles;
	private DrawerLayout drawerLayout;
	private ListView drawerList;
	private Fragment activeFragment;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		planetTitles = getResources().getStringArray(R.array.navigation_options);
		drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		initNavigationDrawer();
		activeFragment = FragmentUtils.pushScholarshipsFragment(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	private void initNavigationDrawer() {
		drawerList = (ListView) findViewById(R.id.navigation_drawer);
		drawerList.setAdapter(new ArrayAdapter<String>(this, R.layout.list_item_navigation, planetTitles));
		drawerList.setOnItemClickListener(new DrawerItemClickListener());
	}

	private class DrawerItemClickListener implements OnItemClickListener {

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
			selectItem(position);
		}
	}

	/** Swaps fragments in the main content view */
	private void selectItem(int position) {
		
		Toast.makeText(this, "Do the Fragment Replacement Magic!", Toast.LENGTH_SHORT).show();
		pushFragment(position);

		// Highlight the selected item, update the title, and close the drawer
		drawerList.setItemChecked(position, true);
		setTitle(planetTitles[position]);
		drawerLayout.closeDrawer(drawerList);
	}

	private void pushFragment(int position) {
		switch (position) {
		case 0:
			FragmentUtils.pushScholarshipsFragment(MainActivity.this);
			break;

		default:
			break;
		}
	}

}