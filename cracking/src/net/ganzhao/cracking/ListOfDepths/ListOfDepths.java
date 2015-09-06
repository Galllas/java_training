package net.ganzhao.cracking.ListOfDepths;

import java.util.ArrayList;
import java.util.LinkedList;

import net.ganzhao.cracking.MinimalTree.Node;

public class ListOfDepths {
		
	public static ArrayList<LinkedList<Node>> getTreeLists(Node root){
		
		if (root == null) return null;
		ArrayList<LinkedList<Node>> result = new ArrayList<LinkedList<Node>>();
		LinkedList<Node> queue = new LinkedList<Node>();
		
		if (root != null) queue.add(root);
		
		while (!queue.isEmpty()){
			
			result.add(queue);
			
			LinkedList<Node> temp = queue;
			queue =  new LinkedList<Node>();
			
			for (Node one : temp){
				
				if (one.leftChild != null) queue.add(one.leftChild);
				if (one.rightChild != null) queue.add(one.rightChild);
			}
		}
		
		return result;
		
	}
	
		
		
	public static void main(String[] args) {
		
		Node a = new Node(1);
		Node b = new Node(2);
		Node c = new Node(3);
		Node d = new Node(4);
		Node e = new Node(5);
		
		a.leftChild = d;
		a.rightChild = e;
		d.leftChild = b;
		d.rightChild = c;

		ArrayList<LinkedList<Node>> res = getTreeLists(a);
		for (LinkedList<Node> list : res){
			for (Node node : list){
				System.out.println(node.value);		
			}		
			System.out.println(" ");
		}	
	}
}
