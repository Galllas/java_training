package net.ganzhao.cracking.LoopDetection;

import net.ganzhao.cracking.RemoveDups.Node;

public class LoopDetection {

	public static Node detectLoop(Node head){
		
		Node fast = head.next.next;
		Node slow = head.next;
		
		while( fast != slow){
			fast = fast.next.next;
			slow = slow.next;
			
		} 
		
		Node nslow = head;
		
		while(nslow != slow){
			nslow = nslow.next;
			slow = slow.next;
		}
				
		return slow;
	}
	
	public static void main(String[] args) {
		
		Node hd1 = new Node(10);
		Node hd2 = new Node(9);
		Node hd3 = new Node(8);
		Node hd4 = new Node(7);
		Node hd5 = new Node(6);
		Node hd6 = new Node(5);
		Node hd7 = new Node(4);
		
		hd1.next = hd2;
		hd2.next = hd3;
		hd3.next = hd4;
		hd4.next = hd5;
		hd5.next = hd6;
		hd6.next = hd7;
		hd7.next = hd4;
		
		System.out.println(detectLoop(hd1).data);

	}
}
