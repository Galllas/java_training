package com.fdmgroup.cracking.StringCompression;

public class StringCompression {

	public static String compressString(String s){
		
		StringBuilder compress = new StringBuilder();  
		int count = 0;
		
		for (int i = 0; i < s.length(); i++){
			
		count ++;	
			
		if ( i == s.length() - 1 || s.charAt(i) != s.charAt(i+1)){
			compress.append(s.charAt(i));
			compress.append(count);
			count = 0;
			}
		}
		
		return compress.length() < s.length() ? compress.toString() : s;
	}
	
	public static void main(String[] args) {
		System.out.println(compressString("abbbbbbccdsfff"));	
	}

}
