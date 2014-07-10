package com.mingyuanchen.youkumenu.utils;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.RotateAnimation;
import android.widget.RelativeLayout;

public class Utils {
	/**
	 * ִ�г�����
	 * @param view
	 * @param startOffset
	 */
	public static void startOutAnimation(RelativeLayout view, int startOffset) {
		//���ó�ȥ�󲻿ɱ����
		int childCount = view.getChildCount();
		for (int i = 0; i < childCount; i++) {
			view.getChildAt(i).setEnabled(false);
		}
		RotateAnimation ra = new RotateAnimation(0, -180,
				Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 1);
		ra.setDuration(500);
		ra.setFillAfter(true);//ִ����ɺ�ͣ�������λ��
		ra.setStartOffset(startOffset);//������ʱ
		
		view.startAnimation(ra);
		ra.setAnimationListener(new MyAnimationListener());
	}

	public static void startInAnimation(RelativeLayout view, int startOffset) {
		//���ý�����ɱ����
		int childCount = view.getChildCount();
		for (int i = 0; i < childCount; i++) {
			view.getChildAt(i).setEnabled(true);
		}
		
		RotateAnimation ra = new RotateAnimation( -180,0,
				Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 1);
		ra.setDuration(500);
		ra.setFillAfter(true);//ִ����ɺ�ͣ�������λ��
		ra.setStartOffset(startOffset);
		
		view.startAnimation(ra);
	}
	public static int runningAnimationCount = 0;
	static class MyAnimationListener implements AnimationListener{

		@Override
		public void onAnimationStart(Animation animation) {
			runningAnimationCount++;
		}

		@Override
		public void onAnimationEnd(Animation animation) {
			runningAnimationCount--;
		}

		@Override
		public void onAnimationRepeat(Animation animation) {
			
		}
		
	}
	
}
