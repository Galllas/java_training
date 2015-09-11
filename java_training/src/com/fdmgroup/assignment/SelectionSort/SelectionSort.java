package com.fdmgroup.assignment.SelectionSort;

import java.util.Arrays;

public class SelectionSort {
	
	private SelectionSort(){};
	
    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i+1; j < N; j++) {
                if (less(a[j], a[min])) min = j;
            }
            exch(a, i, min);
        }
    }
    
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    } 
    
    private static void exch(Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }
	
	
	public static void main(String[] args) {
		Integer[] num = new Integer[]{10, 6, 1, 2, 8, 7, 0, 4, 9, 5, 3};
		SelectionSort.sort(num);
		System.out.println(Arrays.asList(num));
	}

}
