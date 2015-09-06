package com.fdmgroup.cracking.FixedMultiStack;

public class FixedMultiStack {
	
	private int stackNum = 3;
	private int stackSize;
	private int[] values;
	private int[] sizes;
	
	public FixedMultiStack(int size){
		stackSize = size;
		values = new int[size * stackNum];
		sizes = new int[stackNum];
	}
	
	public void push(int stackNum, int value) throws FullStackException{
		if(isFull(stackNum)){
			throw new FullStackException();
		}
		sizes[stackNum] ++;
		values[indexOfTop(stackNum)] = value;
	}
	
	public int pop(int stackNum) throws EmptyStackException{
		if (isFull(stackNum)){
			throw new EmptyStackException();
		}
		int value = values[indexOfTop(stackNum)];
		values[indexOfTop(stackNum)] = 0;
		sizes[stackNum] --;
		return value;
	}
	
	public int peek(int stackNum) throws EmptyStackException{
		if (isFull(stackNum)){
			throw new EmptyStackException();
		}
		return values[indexOfTop(stackNum)];
	}
	
	public boolean isFull(int stackNum){
		return sizes[stackNum] == stackSize;
	}
	
	public boolean isEmpty(int stackNum){
		return sizes[stackNum] == 0;
	}
	
	public int indexOfTop(int stackNum){
		int start = stackNum * stackSize;
		int size = sizes[stackNum];
		return start + size - 1;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
