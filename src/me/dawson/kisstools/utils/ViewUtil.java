package me.dawson.kisstools.utils;

import android.graphics.Point;
import android.graphics.Rect;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

public class ViewUtil {
	public static final String TAG = "ViewUtil";

	public final static int measureTextWidth(TextView view, String text) {
		if (TextUtils.isEmpty(text)) {
			return 0;
		}

		TextPaint paint = view.getPaint();
		int width = (int) paint.measureText(text);
		return width;
	}

	public static boolean eventInView(MotionEvent event, View view) {
		if (event == null || view == null) {
			return false;
		}

		int eventX = (int) event.getRawX();
		int eventY = (int) event.getRawY();

		int[] location = new int[2];
		view.getLocationOnScreen(location);

		int width = view.getWidth();
		int height = view.getHeight();
		int left = location[0];
		int top = location[1];
		int right = left + width;
		int bottom = top + height;

		Rect rect = new Rect(left, top, right, bottom);
		boolean contains = rect.contains(eventX, eventY);
		return contains;
	}

	public static Point getViewCenter(View view) {
		if (view == null) {
			return new Point();
		}

		int[] location = new int[2];
		view.getLocationOnScreen(location);
		int x = location[0] + view.getWidth() / 2;
		int y = location[1] + view.getHeight() / 2;
		return new Point(x, y);
	}
}
