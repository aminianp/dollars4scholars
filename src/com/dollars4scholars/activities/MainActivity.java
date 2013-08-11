package com.dollars4scholars.activities;

import android.app.ActionBar;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.dollars4scholars.utils.FragmentHelper;
import com.example.dollars4scholars.R;

public class MainActivity extends FragmentActivity {

	private String[] menuTitles;
	private ActionBarDrawerToggle drawerToggle;
	private DrawerLayout drawerLayout;
	private ListView drawerList;
	private FragmentHelper helper;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		menuTitles = getResources().getStringArray(R.array.navigation_options);
		drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		helper = FragmentHelper.newInstance(this);

		initNavigationDrawer();

		if (savedInstanceState == null) {
			selectItem(0);
		}
	}

	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		drawerToggle.syncState();
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (drawerToggle.onOptionsItemSelected(item))
			return true;
		else
			return super.onOptionsItemSelected(item);
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		drawerToggle.onConfigurationChanged(newConfig);
	}

	private void initNavigationDrawer() {
		drawerList = (ListView) findViewById(R.id.navigation_drawer);
		drawerList.setAdapter(new ArrayAdapter<String>(this, R.layout.list_item_navigation, menuTitles));
		drawerList.setOnItemClickListener(new DrawerItemClickListener());

		ActionBar actionBar = getActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);
		actionBar.setHomeButtonEnabled(true);

		drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.drawable.ic_drawer, R.string.drawer_open, R.string.drawer_close);
		drawerLayout.setDrawerShadow(R.drawable.drawer_shadow, GravityCompat.START);
		drawerLayout.setDrawerListener(drawerToggle);
	}

	private void selectItem(int position) {
		pushFragment(position);

		drawerList.setItemChecked(position, true);
		setTitle(menuTitles[position]);
		drawerLayout.closeDrawers();
	}

	private void pushFragment(int position) {
		switch (position) {
			case 0:
				helper.pushScholarshipsFragment();
				break;

			default:
				Toast.makeText(this, "Do the Fragment Replacement Magic!", Toast.LENGTH_SHORT).show();
				break;
		}
	}

	private class DrawerItemClickListener implements OnItemClickListener {
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
			selectItem(position);
		}
	}

}