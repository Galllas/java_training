package com.fdmgroup.cracking.RemoveDups;

import java.util.HashSet;

public class RemoveDups {

	
	public static Node removeDups(Node head){
		
		HashSet<Integer> nodes = new HashSet<Integer>();
		Node dummy = new Node(0);
		dummy.next = head;
		
		while (dummy.next != null){
			
			if (!nodes.contains(dummy.next.data)){
				nodes.add(dummy.next.data);
				dummy = dummy.next;
				
			}
			
			else{
				dummy.next = dummy.next.next;
				dummy = dummy.next;
				
				
				
			}
	
			
		}
		return dummy.next;
	}
	
	
	public static void main(String[] args) {
		
		Node head = new Node(10);
		head.appendToTail(9);
		head.appendToTail(8);
		head.appendToTail(7);
		head.appendToTail(7);
		head.appendToTail(5);
		removeDups(head);
		
		while(head != null){
			
			System.out.println(head.data);
			head = head.next;
		}
		
		
	}

}
