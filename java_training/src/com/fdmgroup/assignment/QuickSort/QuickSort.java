package com.fdmgroup.assignment.QuickSort;

import java.util.Arrays;


public class QuickSort {
	
	public static void sort(Comparable[] a){
		sort(a, 0, a.length -1);		
	}
	
	public static void sort(Comparable[] a, int lo, int hi){
		if (hi <= lo) return;
 		int last = lo;
 		for (int i = lo+1; i<=hi; i++){
 			if (less(a[i], a[lo])) exch(a, ++last, i);
 		}
		exch(a, lo, last);
		sort(a, lo, last-1);
 		sort(a, last+1, hi);
	}
	
	private static boolean less(Comparable v, Comparable w){
		return v.compareTo(w) < 0;
	}
	
	private static void exch(Object[] a, int i, int j){
		Object swap = a[i];
		a[i] = a[j];
		a[j] = swap;
	}
	
	public static void main(String[] args){
		//String[] numbers = new String[] {"3", "7", "2", "9", "4", "0", "8", "1", "6", "2"};
		Integer[] numbers = new Integer[] {3, 7, 2, 9, 4, 0, 8, 1, 6, 2};
		QuickSort.sort(numbers);		
		System.out.println(Arrays.asList(numbers));
	}

}
