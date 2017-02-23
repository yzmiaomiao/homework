package com.mercury.util;

import org.apache.velocity.util.StringUtils;

public class MercuryStringUtils {

	public static String firstLetterUpper(String str) {
//		byte[] items = str.getBytes();
//		items[0] = (byte) ((char) items[0] - 'a' + 'A');
//		return new String(items);
		String[] temps = str.split("_");
		String result = "";
		for (int i = 0; i < temps.length; i++) {
			result += StringUtils.firstLetterCaps(temps[i]);
		}
		return result;
	}

	public static String firstLetterLower(String str) {
		String[] temps = str.split("_");
		String result = temps[0];
		for (int i = 1; i < temps.length; i++) {
			result += StringUtils.firstLetterCaps(temps[i]);
		}
		return result;
	}

}
