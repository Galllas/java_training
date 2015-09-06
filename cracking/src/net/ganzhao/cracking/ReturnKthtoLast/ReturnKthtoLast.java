package net.ganzhao.cracking.ReturnKthtoLast;

import net.ganzhao.cracking.RemoveDups.Node;

public class ReturnKthtoLast {

	public static Node returnKthtoLast(Node head, int k){
		
		Node faster = head;
		Node slow = head;
		
		while (k > 0){
			faster = faster.next;
			k -= 1;
		}
		
		while ( faster.next != null ){
			faster = faster.next;
			slow = slow.next;
			
		}
		
		return slow;
	}

	
	public static void main(String[] args) {
		Node head = new Node(10);
		head.appendToTail(9);
		head.appendToTail(8);
		head.appendToTail(7);
		head.appendToTail(6);
		head.appendToTail(5);
		System.out.println(returnKthtoLast(head, 2).data);
		

	}

}
