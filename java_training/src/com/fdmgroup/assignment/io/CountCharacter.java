package com.fdmgroup.assignment.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CountCharacter {
	
	public static int countChars(String file1, char c) {
		
		int count = 0;
		FileReader fr2 = null;
		BufferedReader br = null;
		
		try{
		
		fr2 = new FileReader(file1);
		br = new BufferedReader(fr2);
		
		String thisLine;
	
		while ((thisLine = br.readLine()) != null){
			for (char nc : thisLine.toCharArray()){
				if (nc == c){
					count ++;
				}				
			}
		}
	
		}
	 catch (IOException e) {
		// TODO Auto-generated catch block
		 e.printStackTrace();
	} 		
	catch(NullPointerException e){
		e.printStackTrace();
	}
		finally {
		// Close resources here! 
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
		
		return count;
	}
	
	private static Object tochars(String thisLine) {
		// TODO Auto-generated method stub
		return null;
	}

	public static void main(String[] args) {
		
		File file1 = new File("file.txt");	
		FileWriter fw;
		try {
			
			fw = new FileWriter(file1);
			fw.write("howdy\nfolks\nhowdy\nfolks\nhowdy\nfolks\nhowdy\nfolks\nhowdy\nfolks\n"); 	
			fw.flush(); 					
			fw.close(); 
				
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 		
		finally {
			// Close resources here! 
			// (all close() calls)
		}										
		System.out.println(countChars("file.txt", 's'));
		System.out.println(countChars(null, 's'));
		
	}

}
