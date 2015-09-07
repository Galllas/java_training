package net.gangzhao.cracking.RandomNode;

public class TreeNode {
	
	private int data;
	private int size;
	public TreeNode left;
	public TreeNode right;
	
	
	public TreeNode(int d){
		data = d;
		size = 1;
	}
	
	public int data(){ return data;}
	public int size(){ return size;}
	
	public TreeNode findIthNode(int i){
		int leftSize = left == null ? 0 : left.size();
		
		if (i == leftSize) return this;
		else if (i < leftSize) return left.findIthNode(i);
		else return right.findIthNode(i - 1 - leftSize);

	}
	
	public void insertNode(int i){
		if (data <= i){
			if (left == null) {
				
				TreeNode one = new TreeNode(i);
				left = one;
				
			}
			
			else left.insertNode(i);
		}
		else{
			if (right == null){
				
				TreeNode one = new TreeNode(i);
				right = one;			
			}
			else right.insertNode(i);
		}
		
		size ++;
		
	}
	
	public TreeNode find(int d){
		
		if (data == d) 
			return this;
		else if (data < d) 
			return right != null ? right.find(d) : null;
		else if (data > d)
			return left != null ? left.find(d) : null;
		
		return null;
	}
	
	

}
