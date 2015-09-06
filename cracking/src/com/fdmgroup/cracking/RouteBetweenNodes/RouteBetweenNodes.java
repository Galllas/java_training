package com.fdmgroup.cracking.RouteBetweenNodes;

import java.util.LinkedList;
import java.util.Queue;

public class RouteBetweenNodes {
	
	public static boolean hasRoute(Node a, Node b){
		
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(a);
		
		while (!queue.isEmpty()){
			
			Node one = queue.poll();
			one.visited = true;
			for (Node n : one.children){
				if (n.visited) return false;
				
				if (n == b){
					return true;
				}
				
				queue.add(n);
			}
			
		}
		return false;
	}
	
public static void main(String[] args) {
	
	Node a = new Node("a");
	Node b = new Node("b");
	Node c = new Node("c");
	Node d = new Node("d");
	Node e = new Node("e");
	
	a.addChild(b);
	b.addChild(d);
	//c.addChild(d);
	d.addChild(e);
	e.addChild(a);

	System.out.println(hasRoute(a,c));
	
}

}
