package net.ganzhao.cracking.StackOfPlates;

import java.util.ArrayList;
import java.util.Stack;

public class SetOfStacks {
	
	public int getThreshold() {
		return threshold;
	}

	public ArrayList<Stack<Object>> getStacks() {
		return stacks;
	}



	private int threshold = 0;
	private ArrayList<Stack<Object>> stacks = new ArrayList<Stack<Object>>();
	
	public SetOfStacks(int threshold){
		this.threshold = threshold;
	}
	
	public void push(Object o){
		if (stacks.isEmpty() || stacks.get(stacks.size() -1).size() == threshold){
			Stack<Object> nstack = new Stack<Object>();
			nstack.push(o);
			stacks.add(nstack);
		}
		else{
			stacks.get(stacks.size()-1).push(o);
		}
	}
 	
	public Object pop(){
		if (stacks.get(stacks.size() -1).size() == 0){
			stacks.remove(stacks.size()-1);
		}
		return stacks.get(stacks.size()-1).pop();
	}
	
	public Object popAt(int index){
		if (stacks.size() < index + 1) return null;
		Object val = stacks.get(index).pop();
		
		Stack<Object> temp = new Stack<Object>();
		int count = (stacks.size()-1)*threshold + stacks.get(stacks.size()-1).size() - (index+1)*threshold;
		while (count >0){
			
			temp.push(this.pop());
			count --;
		}
		
		while (stacks.get(stacks.size()-1).size() ==0 )
	{
		stacks.remove(stacks.size()-1);
	}
		
		while (!temp.isEmpty()){
			push(temp.pop());	
		}
		
		return val;
	}	
	
	public Object peek(){
		return stacks.get(stacks.size() -1).peek();
		
	}
	
	
		
	public static void main(String[] args) {
		SetOfStacks st = new SetOfStacks(2);
		
		st.push(1);
		st.push(2);
		st.push(3);
		st.push(4);
		System.out.println(st.popAt(0));
		System.out.println(st.popAt(0));
		System.out.println(st.pop());
		
		System.out.println(st.getStacks().size());
	}

}
