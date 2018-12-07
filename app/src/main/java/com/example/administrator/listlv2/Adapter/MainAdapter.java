package com.example.administrator.listlv2.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

import com.example.administrator.listlv2.Fragment.FragmentOne;
import com.example.administrator.listlv2.Fragment.FragmentThree;
import com.example.administrator.listlv2.Fragment.FragmentTwo;

import java.util.HashMap;
/**
 *  MainActivity的适配器
 * 只适用于TabLayout+ViewPager+Fragment
 * */
public class MainAdapter extends FragmentPagerAdapter {

	private int num;
	private HashMap<Integer, Fragment> mFragmentHashMap = new HashMap<>();

	public MainAdapter(FragmentManager fm, int num) {
		super(fm);
		this.num = num;
	}

	@Override
	public Fragment getItem(int position) {

		return createFragment(position);
	}

	@Override
	public int getCount() {
		return num;
	}

	private Fragment createFragment(int pos) {
		Fragment fragment = mFragmentHashMap.get(pos);

		if (fragment == null) {
			switch (pos) {
				case 0:
					fragment = new FragmentOne();
					Log.i("fragment", "fragment1");
					break;
				case 1:
					fragment = new FragmentTwo();
					Log.i("fragment", "fragment2");
					break;
				case 2:
					fragment = new FragmentThree();
					Log.i("fragment", "fragment3");
					break;
				case 3:
					fragment = new FragmentThree();
					Log.i("fragment", "fragment4");
					break;
			}
			mFragmentHashMap.put(pos, fragment);
		}
		return fragment;
	}
}