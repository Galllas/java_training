package net.ganzhao.cracking.RouteBetweenNodes;

import java.util.ArrayList;

public class Node {
	
	public String name;
	public ArrayList<Node> children = new ArrayList<Node>();
	public boolean visited = false;
	
	public Node(String name){
		this.name = name;
	}
	
	public void addChild(Node node){
		children.add(node);
	}
	
}
