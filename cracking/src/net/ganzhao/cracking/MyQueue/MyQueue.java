package net.ganzhao.cracking.MyQueue;

import java.util.Stack;

public class MyQueue {

	Stack<Object> s = new Stack<Object>();
	Stack<Object> temp = new Stack<Object>();
	
	public void push(Object o){
		while (!s.isEmpty()){
			temp.push(s.pop());
		}
		s.push(o);
		while (!temp.isEmpty()){
			s.push(temp.pop());
		}
		
	}
	
	
	public Object pop(){
		if(!s.isEmpty()){
		return s.pop();}
		return null;
	}
	
	public Object peek(){
		if(!s.isEmpty()){
			return s.peek();}
			return null;
	}
	
	
	
	public static void main(String[] args) {
		MyQueue q = new MyQueue();
		q.push(4);
		q.push(3);
		q.push(2);
		q.push(1);
		System.out.println(q.pop());
		System.out.println(q.pop());
		System.out.println(q.pop());
		System.out.println(q.pop());
		System.out.println(q.pop());
	}

}
