package com.fdmgroup.cracking.ZeroMatrix;

import java.util.Arrays;

public class ZeroMatrix {
	
	
	public static void nullifyRow(int[][] matrix, int i){
		for (int j = 0; j<matrix[0].length; j++){
			matrix[i][j] = 0;
		}
	}
	
	public static void nullifyCol(int[][] matrix, int j){
		for (int i = 0; i<matrix.length; i++){
			matrix[i][j] = 0;
		}
	}

	public static void setZeroMatrix(int[][] matrix){
		
		boolean rowHasZero = false;
		boolean colHasZero = false;
		
		for (int j =0; j<matrix[0].length; j++){
			if (matrix[0][j] == 0) rowHasZero = true;
			break;
		}
		
		for (int i =0; i<matrix.length; i++){
			if (matrix[i][0] == 0) colHasZero = true;
			break;
		}
		
		for (int i=0; i<matrix.length; i++){
			for (int j=0; j<matrix[0].length; j++){
				if (matrix[i][j] == 0){
					matrix[0][j] = 0;
					matrix[i][0] = 0;			
				}
			}
		}
		
		
		for (int j= 1; j<matrix[0].length; j++){
			if (matrix[0][j] == 0){
				nullifyCol(matrix, j);
			}
		}
		
		for (int i= 1; i<matrix.length; i++){
			if (matrix[i][0] == 0){
				nullifyRow(matrix, i);
			}
		}
		
		if (rowHasZero) nullifyRow(matrix, 0);
		if (colHasZero) nullifyCol(matrix, 0);
		
	}
	
	public static void main(String[] args) {
		
		int[][] matrix = new int[][]{
			{0, 2, 3, 4, 5},	
			{1, 2, 3, 4, 5},
			{1, 2, 3 ,4, 5},
			{1, 2, 2, 4, 5},
			{1, 2, 3, 0, 5}
		};
		setZeroMatrix(matrix);
		System.out.println(Arrays.deepToString(matrix));

	}

}
