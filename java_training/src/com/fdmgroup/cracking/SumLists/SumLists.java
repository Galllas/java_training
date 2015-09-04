package com.fdmgroup.cracking.SumLists;

import com.fdmgroup.cracking.RemoveDups.Node;

public class SumLists {
	
	public static Node sumReverseLists(Node l1, Node l2){
		
		
		
		
		
		
		
		return l1;
	}
	
	public static Node sumForwardLists(Node l1, Node l2){
		
		
		
		
		return l1;
	}	
	
	public static void main(String[] args) {
		
		Node l1 = new Node(1);
		l1.appendToTail(9);
		l1.appendToTail(3);
		Node l2 = new Node(8);
		l2.appendToTail(7);
		l2.appendToTail(5);

		Node s1 = sumReverseLists(l1, l2);
		Node s2 = sumForwardLists(l1, l2);
		
		while (s1 != null){
			
			System.out.println(s1.data);
			s1 = s1.next;
			
		}
		while (s2 != null){
			
			System.out.println(s2.data);
			s2 = s2.next;
			
		}
	
	}

}
