package net.ganzhao.cracking.ValidateBST;

import java.util.Stack;

import net.ganzhao.cracking.MinimalTree.Node;

public class ValidateBST {
	
	public static boolean isValidBST(Node head){
		
		Stack<Node> s = new Stack<Node>();
		int temp = Integer.MIN_VALUE;
		
		while(head != null || !s.isEmpty()){
			
			if (head != null) {
				s.add(head);
				head = head.leftChild;
			}
			
			else{
				head = s.pop();
				if (temp >= head.value) return false;
				temp = head.value;
				head = head.rightChild;
			}
		}
		return true;
	}
	
	public static boolean checkBST(Node head){
		
		return checkBST(head, null, null);
	}
	
	public static boolean checkBST(Node head, Integer min, Integer max){
		
		if (head == null) return true;
		
		if ((min != null && head.value <= min) || (max != null && head.value >= max)) return false;
	
		if (!(checkBST(head.leftChild, min, head.value)) || !(checkBST(head.rightChild, head.value, max))) return false;
		
		return true;
	}
	
	public static void main(String[] args) {	
		Node a = new Node(1);
		Node b = new Node(2);
		Node c = new Node(3);
		Node d = new Node(4);
		Node e = new Node(5);
		
		a.leftChild = d;
		a.rightChild = e;
		d.leftChild = b;
		d.rightChild = c;

		System.out.println(isValidBST(a));
	}
}
