package net.ganzhao.cracking.Successor;

import net.ganzhao.cracking.MinimalTree.Node;

public class Successor {

	public static Node findSuccessor(Node head){
		
		if (head.rightChild != null) return findMostLeft(head.rightChild); 
		else{
			
			Node q = head.parent;
			Node n = head;
			
			while(q != null && n != q.leftChild){
				n = q;
				q = q.parent;
			}
			return q;
		}
	}
	
	
	public static Node findMostLeft(Node head){
		
		if (head.leftChild != null){
			head = head.leftChild;
		}
		return head;
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
		
		System.out.println(findSuccessor(a).value);

	}

}
