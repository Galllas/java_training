package com.fdmgroup.cracking.FirstCommonAncestor;

import com.fdmgroup.cracking.MinimalTree.Node;

public class FirstCommonAncestor {

	
	public static Node findAncestor(Node head, Node n1, Node n2){
		
		if (!covers(head, n1) || !covers(head, n2)) return null;
		return commonAncestor(head, n1, n2);
	}
	
	
	static Node commonAncestor(Node root, Node p, Node q){
		
		if (root == null) return null;
		
		if (root == p || root == q) return root;
		
		
		
		
		
		return p;
	}
	
	static boolean covers(Node root, Node p){
		
		if (root == null) return false;
		if (root == p) return true;
		
		return covers(root.rightChild, p) || covers(root.leftChild, p);
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

		System.out.println(findAncestor(a, e, g).value);
		
	}

}