package com.example.administrator.listlv2.Utils;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
/**
 * 工具类：重写ViewPager，禁止ViewPager+Fragment左右滑动切页面
 * 用法：创建实例，调用setNoScroll()方法，false为禁止滑动
 *
 * 原理：重写ViewPager并重写覆盖ViewPager的onInterceptTouchEvent(MotionEvent arg0)方法
 * 和onTouchEvent(MotionEvent arg0)方法，这两个方法的返回值都是boolean类型的，
 * 只需要将返回值改为false，那么ViewPager就不会消耗掉手指滑动的事件了。
 * */
public class NonSlipViewPager extends ViewPager {
	private boolean noScroll = false;

    public NonSlipViewPager(Context context, AttributeSet attrs) {
 		 super(context, attrs);
    }


    public NonSlipViewPager(Context context) {
		 super(context);
	}

	/**
	 * 设置其是否能滑动换页
	 * @param noScroll false 不能， true 可以滑动换页
	 */
  	public void setNoScroll(boolean noScroll) {
  	 	this.noScroll = noScroll;
 	}

	@Override
	public void scrollTo(int x, int y) {
		super.scrollTo(x, y);
	}

	@Override
	public boolean onTouchEvent(MotionEvent ev) {
		if (!noScroll)
			return false;
		else
			return super.onTouchEvent(ev);
	}

	@Override
	public boolean onInterceptTouchEvent(MotionEvent ev) {
		if (!noScroll)
			return false;
		else
			return super.onInterceptTouchEvent(ev);
	}

	@Override
	public void setCurrentItem(int item, boolean smoothScroll) {
		super.setCurrentItem(item, smoothScroll);
	}

	@Override
	public void setCurrentItem(int item) {
		super.setCurrentItem(item,false);//false表示切换的时候，不需要切换时间
	}
}
