package net.gangzhao.cracking.Insertion;

public class Insertion {

	static int insert(int n, int m, int i, int j){
		
		int allones = ~0;
		int left = allones << (j + 1);
		int right = (1 << i) -1;
		
		int mask = left | right;
		
		int clear = n & mask;
		int merge = m << i;
		
		return clear | merge;
		
		
	}
	
	
	public static void main(String[] args) {
		
		int n = 267;
		int m = 3;
		int i = 5;
		int j = 6;
		System.out.println(Integer.toBinaryString(insert(n, m, i, j)));

	}

}
