package com.fdmgroup.cracking.BuildOrder;

import java.util.Arrays;

public class BuildOrder {
	
	public static String buildOrder(String de){
		String[] des = de.split(", ");
		System.out.println(Arrays.toString(des));
		
		
		for (String s: des){
			System.out.println(s.split(" ")[0]);
			
		}
		
		
		
		
		
		
		return "";
	}
	
	
	public static void main(String[] args) {
		String de = "d a, b f, d b, a f, c d";
		System.out.println(buildOrder(de));
	}

}
