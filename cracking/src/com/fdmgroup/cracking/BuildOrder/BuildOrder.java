package com.fdmgroup.cracking.BuildOrder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class BuildOrder {
	
	private static StringBuilder res = new StringBuilder();
	private static boolean circle = false;
	private static HashMap<String, ArrayList<String>> nodes = new HashMap<String, ArrayList<String>>();
	private static HashMap<String, Integer> stats = new HashMap<String, Integer>();

	public static String buildOrder(String[] projects, String[][] des){
		
		
		for (String[] s : des){
			if (nodes.containsKey(s[1])){
				nodes.get(s[1]).add(s[0]);
				}
			else{
				ArrayList<String> temp = new ArrayList<String>();
				temp.add(s[0]);
				nodes.put(s[1], temp);
				}
			}
		
		for (String s : projects) stats.put(s, 0);
		
		for (String s : projects){
			
			if (stats.get(s) != 1){
				Dfs(s);
			}
			if (circle) return null;
		}
		
		return res.reverse().toString();
	}
	
	
	public static void Dfs(String s){
		
		if (stats.get(s) == 1) return;
		if (stats.get(s) == 2) return;
		
		stats.put(s, 1);
		
		if (nodes.containsKey(s)){
			for (String one : nodes.get(s)){
				Dfs(one);	
			}
		}
		stats.put(s, 2);
		res.append(s);
		return;
		
	}
	
	public static void main(String[] args) {
		String[] projects = {"a", "b", "c", "d", "e", "f"};
		String[][] des = {{"d", "a"}, {"b", "f"}, {"d", "b"}, {"a", "f"}, {"c", "d"}};
		
		System.out.println(buildOrder(projects, des));
	}
}
