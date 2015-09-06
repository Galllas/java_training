package com.fdmgroup.cracking.SortStack;

import java.util.Stack;

public class SortStack {
	
	private static Stack<Integer> temp = new Stack<Integer>();
	
	public static Stack<Integer> SortStack(Stack s){
		
		while(!s.isEmpty()){
			
			int val = (Integer) s.pop();
			if (temp.isEmpty()) temp.push(val);
			else{
				int count = 0;
				while(!temp.isEmpty() && temp.peek() > val){
					s.push(temp.pop());
					count ++;
				}
				temp.push(val);
				while (count>0){
					temp.push((Integer) s.pop());
					count --;
				}
				
				
				
			}
		}

		while(!temp.isEmpty()){
			s.push(temp.pop());
		}
		
		return s;
	} 
	
	public static void main(String[] args) {
		Stack<Integer> s = new Stack<Integer>();
		s.push(8);
		s.push(5);
		s.push(9);		
		s.push(5);
		s.push(6);
		s.push(7);
		System.out.println(SortStack(s).toString());
		System.out.println(s.pop());

	}

}
