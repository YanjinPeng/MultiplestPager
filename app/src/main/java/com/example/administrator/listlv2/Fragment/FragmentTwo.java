package com.example.administrator.listlv2.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.listlv2.Adapter.FragmentAdapter;
import com.example.administrator.listlv2.R;

/**
 * 次级页面(二级ViewPager，适配器中设置二级TabLayout对应页面)
 * */
public class FragmentTwo  extends Fragment {

	TabLayout tabLayout;
	@Nullable
	@Override
	public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_two, container, false);


		//viewPager = (ViewPager)findViewById(R.id.view_pager2);
		tabLayout= (TabLayout) view.findViewById(R.id.tabLayout2);

		//添加标签
		tabLayout.addTab(tabLayout.newTab().setText("tab1"));
		tabLayout.addTab(tabLayout.newTab().setText("tab2"));
		tabLayout.addTab(tabLayout.newTab().setText("tab3"));
		tabLayout.addTab(tabLayout.newTab().setText("tab4"));

		//创建实例
		final ViewPager viewPager = (ViewPager)view.findViewById(R.id.view_pager2);

		/**多级嵌套关键将getSupportFragmentManager()，替换成getChildFragmentManager()即可**/
		viewPager.setAdapter(new FragmentAdapter(getChildFragmentManager(), tabLayout.getTabCount()));
		/**************次级配置***************/

		viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

		//绑定tab点击事件
		tabLayout.addOnTabSelectedListener(new TabLayout.BaseOnTabSelectedListener() {
			@Override
			public void onTabSelected(TabLayout.Tab tab) {
				viewPager.setCurrentItem(tab.getPosition());
			}

			@Override
			public void onTabUnselected(TabLayout.Tab tab) {

			}

			@Override
			public void onTabReselected(TabLayout.Tab tab) {

			}
		});

		return view;
	}
}