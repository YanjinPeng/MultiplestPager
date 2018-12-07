package com.example.administrator.listlv2;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.administrator.listlv2.Adapter.MainAdapter;
import com.example.administrator.listlv2.Utils.NonSlipViewPager;
/**
 * TabLayout+ViewPager+Fragment实现多级嵌套页面(次级页面设置都一样)
 * 适配器设置对应页面(适配器除了对应Fragment不一样，其他一样)
 *
 * 一级页面
 * */
public class MainActivity extends AppCompatActivity {
	TabLayout tabLayout;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		//viewPager = (ViewPager)findViewById(R.id.view_pager2);
		tabLayout= (TabLayout) findViewById(R.id.tabLayout);

		//添加标签
		tabLayout.addTab(tabLayout.newTab().setText("tab1"));
		tabLayout.addTab(tabLayout.newTab().setText("tab2"));
		tabLayout.addTab(tabLayout.newTab().setText("tab3"));
		tabLayout.addTab(tabLayout.newTab().setText("tab4"));

		//重写ViewPager，使之不能滑动
		final NonSlipViewPager viewPager = (NonSlipViewPager) findViewById(R.id.view_pager);
		//禁止滑动切换页面
		viewPager.setNoScroll(false);

		/**一级页面getSupportFragmentManager(),二级以上(即Fragment里)替换成getChildFragmentManager()方法即可实现多级嵌套**/
		viewPager.setAdapter(new MainAdapter(getSupportFragmentManager(), tabLayout.getTabCount()));
		/**********一级配置*********/

		viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

		//绑定tab点击事件
		tabLayout.addOnTabSelectedListener(new TabLayout.BaseOnTabSelectedListener() {
			@Override
			public void onTabSelected(TabLayout.Tab tab) {
				//选中逻辑
				viewPager.setCurrentItem(tab.getPosition());
				//Toast.makeText(MainActivity.this,""+tab.getPosition(),Toast.LENGTH_SHORT).show();
			}

			@Override
			public void onTabUnselected(TabLayout.Tab tab) {
				//未选中逻辑
			}

			@Override
			public void onTabReselected(TabLayout.Tab tab) {
				//再次选中逻辑
			}
		});
	}
}
/**
 * TabLayout  xml中可设置属性
 * app:tabIndicatorColor    指示器(下标)颜色
 * app:tabTextColor         tab栏字体颜色
 * app:tabSelectedTextColor tab栏字体被选颜色
 * app:tabIndicatorHeight   指示器(下标)高度
 * app:tabBackground        tab背景颜色
 * app:tabMaxWidth          tab栏最大宽度
 * app:tabTextAppearance    tab栏字体样式
 * app:tabMinWidth          tab栏最小宽度
 * app:tabPadding           tab内部子控件边距
 * app:tabContentStart      TabLayout开始位置的偏移量
 * app:paddingEnd           设置整个TabLayout的Padding：
 * app:paddingStart         设置整个TabLayout的Padding：
 * app:tabMode              设置可滑动(默认不可滑动，scrollable可滑动)
 * app:tabGravity           内容的显示模式(center居中，fill充满.可滑动时无效)
 */