package com.fdmgroup.cracking.MinimalTree;

public class Node {
	
	public int value;
	public Node leftChild = null;
	public Node rightChild = null;
	public Node parent =null;
	public boolean visited = false;
	
	public Node(int value){
		this.value = value;
	}
	
	public void addleftChild(Node node){
		leftChild = node;
		node.parent = this;
	}
	
	public void addrightChild(Node node){
		rightChild = node;
		node.parent = this;
	}

	public void addParent(Node node){
		parent = node;
	}
	
}