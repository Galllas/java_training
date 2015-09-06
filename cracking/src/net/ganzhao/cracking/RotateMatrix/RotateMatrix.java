package net.ganzhao.cracking.RotateMatrix;

import java.util.Arrays;

public class RotateMatrix {
	
	public static void rotateMatrix(int[][] matrix){
		
		int depth = matrix.length/2;
		int last = matrix.length -1;
		
		for (int i = 0; i < depth; i++){
			
			int start = i +1;
			int end = matrix.length -i-1;
						
			for (int j = start; j <= end; j++){
				
				int temp = matrix[i][j];
				
				matrix[i][j] = matrix[last-j][i];
				
				matrix[last-j][i] = matrix[last-i][last-j];
				
				matrix[last-i][last-j] = matrix[j][last-i];
				
				matrix[j][last-i] = temp;
				
			}
		}
	}
	
	public static void main(String[] args) {
		int[][] matrix = new int[][]{
				{1, 2, 3, 4, 5},	
				{1, 2, 3, 4, 5},
				{1, 2, 3 ,4, 5},
				{1, 2, 3, 4, 5},
				{1, 2, 3, 4, 5}
		};
		rotateMatrix(matrix);
		System.out.println(Arrays.deepToString(matrix));
	}

}
