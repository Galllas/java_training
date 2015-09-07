package net.gangzhao.cracking.RandomNode;

import java.util.Random;

public class Tree {
	
	TreeNode root = null;
	
	public int size(){ return root == null ? 0 : root.size();}
	
	public void insertNode(int i){
		if (root == null) root = new TreeNode(i);
	
		else root.insertNode(i);
	}
	
	
	public TreeNode getRandom(){
		
		if (size() == 0 ) return null;
		
		Random random = new Random();
		int i = random.nextInt(size());
		return root.find(i);
	}
	
}
