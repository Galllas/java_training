package net.ganzhao.cracking.Palindrome;

import net.ganzhao.cracking.RemoveDups.Node;

public class Palindrome {
		
	public static boolean isPalindrome(Node head){
		
		Node slow = head;
		Node fast = head;
		
		while (fast.next != null && fast.next.next != null){
			fast = fast.next.next;
			slow = slow.next;
		}
				
		Node newhead = slow.next;
		slow.next = null;
		Node pre = null;
		
		while (newhead != null){
			Node temp = newhead.next;
			newhead.next = pre;
			pre = newhead;
			newhead = temp;
		}
		
		while (pre != null){
						
			if (head.data != pre.data){
				return false;
			}
			pre = pre.next;
			head = head.next;
		}
		
		return true;
	}
		
	public static void main(String[] args) {
		
		Node l1 = new Node(1);
		l1.appendToTail(5);
		l1.appendToTail(9);
		l1.appendToTail(16);
		l1.appendToTail(9);
		l1.appendToTail(5);
		l1.appendToTail(1);
		
		System.out.println(isPalindrome(l1));

	}

}
