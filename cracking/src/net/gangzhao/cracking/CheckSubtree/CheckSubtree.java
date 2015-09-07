package net.gangzhao.cracking.CheckSubtree;

import net.ganzhao.cracking.MinimalTree.Node;

public class CheckSubtree {

	static boolean checkSubtree(Node p, Node q){
		
		if (q == null) return true;
		if (p == null) return false;
		
		if (p.value == q.value && matchTree(p, q)){
			return true;
			}
		else return checkSubtree(p.leftChild, q) || checkSubtree(p.rightChild, q);
		
	}
	
	static boolean matchTree(Node p, Node q){
		
		if (p == null && q == null){
			return true;
		}
		else if ( p == null || q == null) return false;
		else if (p.value != q.value){
			return false;
		}
		else return matchTree(p.leftChild, q.leftChild) && matchTree(p.rightChild, q.rightChild);
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
		
		Node h = new Node(3);
		Node i = new Node(6);
		Node j = new Node(7);
		
		h.leftChild = i;
	//	h.rightChild = j;		
		
		System.out.println(checkSubtree(a, h));
		

	}

}
