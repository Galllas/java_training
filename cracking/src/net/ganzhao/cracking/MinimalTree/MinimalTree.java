package net.ganzhao.cracking.MinimalTree;

public class MinimalTree {
	
	public static Node buildTree(int[] nums, int start, int end){
		
		
		if (start > end) return null;
		
		Node root = new Node(nums[(start + end)/2]);
		
		root.leftChild = buildTree(nums, start, (start + end)/2 - 1);
		root.rightChild = buildTree(nums,  (start + end)/2 + 1, end);
		
		return root;
		
	}
	
	
	public static void inOrder(Node root){
		if (root != null){
		inOrder(root.leftChild);
		System.out.println(root.value);
		inOrder(root.rightChild);
		}
		
	}
	
	public static void main(String[] args) {
		int[] vals = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
		Node root = buildTree(vals, 0, vals.length-1);
		inOrder(root);
	}
}
