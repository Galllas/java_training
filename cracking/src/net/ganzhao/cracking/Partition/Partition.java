package net.ganzhao.cracking.Partition;

import net.ganzhao.cracking.RemoveDups.Node;

public class Partition {
		
	public static Node partitionLinkedlist(Node head, int k){
		
		Node before = new Node(0);
		Node t1 = before;
		Node after = new Node(0);
		Node t2 = after;
		
		while(head != null) {
			
			if (head.data < k){
				before.next = head;
				before = before.next;
			}
			else {
				after.next = head;
				after = after.next;
			}
			head = head.next;
		}
		
		after.next = null;
		before.next = t2.next;
		return t1.next;
	}
		
	public static void main(String[] args) {
		Node head = new Node(10);
		head.appendToTail(9);
		head.appendToTail(3);
		head.appendToTail(7);
		head.appendToTail(2);
		head.appendToTail(5);
		Node res = partitionLinkedlist(head, 4);
		while (res != null){
			
			System.out.println(res.data);
			res = res.next;
			
		}
	}

}
