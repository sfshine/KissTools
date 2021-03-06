package me.dawson.kisstools.helper;

import android.content.Context;

public class ClipboardHelper {
	public static final String TAG = "ClipboardHelper";

	@SuppressWarnings("deprecation")
	public static boolean setClipboard(Context context, String text) {
		android.text.ClipboardManager clipboard = (android.text.ClipboardManager) context
				.getSystemService(Context.CLIPBOARD_SERVICE);
		clipboard.setText(text);
		return true;
	}

	@SuppressWarnings("deprecation")
	public static String getClipboard(Context context) {
		android.text.ClipboardManager clipboard = (android.text.ClipboardManager) context
				.getSystemService(Context.CLIPBOARD_SERVICE);
		return clipboard.getText().toString();
	}
}
