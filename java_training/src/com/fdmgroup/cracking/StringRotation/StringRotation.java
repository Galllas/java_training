package com.fdmgroup.cracking.StringRotation;

public class StringRotation {

	
	public static boolean isSubstring(String s1, String s2){
		return s2.contains(s1);
		
	}
	
	public static boolean isRotation(String s1, String s2){
		
		if (s1.length() != s2.length()) return false;
			
		if (isSubstring(s2, s1 + s1)){
				
				return true;	
				
		}
		return false;
	}
	
	public static void main(String[] args) {
		
		System.out.println(isRotation("waterbottle", "bottlewater"));
		

	}

}
