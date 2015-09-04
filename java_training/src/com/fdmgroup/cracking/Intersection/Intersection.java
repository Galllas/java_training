package com.fdmgroup.cracking.Intersection;

import com.fdmgroup.cracking.RemoveDups.Node;

public class Intersection {

	public static Node findIntersection(Node h1, Node h2){
		
		int l1 = getLength(h1);
		int l2 = getLength(h2);
		
		if (l1 < l2) return findIntersection(h2, h1);
		
		int diff = l1 -l2;
		
		while (diff != 0){
			h1 = h1.next;
			diff --;
		}
		
		
		while (h1 != null){
			
			if (h1.data == h2.data){
				
				return h1;
			}
			h1 = h1.next;
			h2 = h2.next;		
		}
		
		
		return null;
		
	}
	
	
	public static int getLength(Node head){
		int count = 0;
		
		while (head != null){
			count ++;
			head = head.next;	
		}
		return count;
	}
	
	
	public static void main(String[] args) {
		
		Node l1 = new Node(10);
		l1.appendToTail(15);
		l1.appendToTail(7);
		l1.appendToTail(3);
		l1.appendToTail(2);
		
		Node l2 = new Node(8);
		l2.appendToTail(9);
		l2.appendToTail(7);
		l2.appendToTail(3);
		l2.appendToTail(2);

		System.out.println(findIntersection(l1, l2).data);

	}

}
