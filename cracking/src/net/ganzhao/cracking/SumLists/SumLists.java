package net.ganzhao.cracking.SumLists;

import net.ganzhao.cracking.RemoveDups.Node;

public class SumLists {
	
	public static Node sumReverseLists(Node l1, Node l2){
		
		Node head = new Node(0);
		Node temp = head;
		int next = 0;
		
		while ( l1 != null || l2 != null || next!= 0){
			
			int v1 = l1 != null ? l1.data : 0;
			int v2 = l2 != null ? l2.data : 0;
			
			int sum = v1 + v2;
			int val = sum%10 + next;
			
			Node add = new Node(val);
			head.next = add;
			head = head.next;
			
			next = sum/10;
			if (l1 != null) l1 = l1.next;
			if (l2 != null) l2 = l2.next;
	
		}
		
		return temp.next;
	}
	
	
	public static void main(String[] args) {
		
		Node l1 = new Node(1);
		l1.appendToTail(5);
		l1.appendToTail(9);
		Node l2 = new Node(8);
		l2.appendToTail(9);
		l2.appendToTail(5);

		Node s1 = sumReverseLists(l1, l2);
	//	Node s2 = sumForwardLists(l1, l2);
		
		while (s1 != null){
			
			System.out.println(s1.data);
			s1 = s1.next;
			
		}
//		while (s2 != null){
//			
//			System.out.println(s2.data);
//			s2 = s2.next;
//			
//		}
	
	}

}
