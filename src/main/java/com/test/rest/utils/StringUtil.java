package com.test.rest.utils;

public class StringUtil {
	public static String revertString(String string) {
		char[] original = string.toCharArray();
		char[] reverted = new char[original.length];
		int j = 0;
		for(int i = string.length()-1; i>=0; i--){
			reverted[j++] = original[i];
			//System.out.println(original[i]);
		}
		string = String.valueOf(reverted);
		//System.out.println("s:" + string);
		return string; 
	}
}
