package net.ganzhao.cracking.CheckBalanced;

import net.ganzhao.cracking.MinimalTree.Node;

public class CheckBalanced {
	
	
	public static boolean isBalanced(Node head){
		if (checkHeight(head) == -1) return false;
		else return true;
	}

	
	public static int checkHeight(Node head){
		
		if (head == null) return 0;
		
		int lh = checkHeight(head.leftChild);
		if (lh == -1) return -1;
		
		int rh = checkHeight(head.rightChild);
		if (rh == -1) return -1;
		
		if (Math.abs(lh - rh) >1) return -1;
		else return Math.max(lh, rh) + 1;
		
	}
	
	
	public static void main(String[] args) {
		
		Node a = new Node(1);
		Node b = new Node(2);
		Node c = new Node(3);
		Node d = new Node(4);
		Node e = new Node(5);
		Node f = new Node(6);
		Node g = new Node(7);
		
		a.leftChild = b;
		a.rightChild = c;
		b.leftChild = d;
		b.rightChild = e;
		c.leftChild = f;
		c.rightChild = g;

		System.out.println(isBalanced(a));
		

	}

}
