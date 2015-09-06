package com.fdmgroup.cracking.StackMin;

import java.util.Stack;

public class StackWithMin {
	
	private Stack<Integer> vals = new Stack<Integer>();
	private Stack<Integer> mins = new Stack<Integer>();
	
	public void push(int val){
		
		if (val <= getMin()){
			mins.push(val);
		}
		vals.push(val);
	}
	
	public int pop(){
		int val = vals.pop();
		if (mins.peek() == val){
			mins.pop();
		}
		return val;
	}
	
	public int getMin(){
		if (mins.isEmpty()){return Integer.MAX_VALUE;}
		else{
		return mins.pop();}
	}

	public static void main(String[] args) {
				
		StackWithMin sm = new StackWithMin();
		System.out.println(sm.getMin());
		
		
	}

}
