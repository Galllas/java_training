package com.fdmgroup.assignment.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RestoreUserObject {

	public static List<User> restoreUserData(String txt){
		
		List<User> users = new ArrayList<User>();
		
		try{
			
			FileReader fr2 = new FileReader(txt);
			BufferedReader br = new BufferedReader(fr2);
			
			String thisLine;
		
			while ((thisLine = br.readLine()) != null){
				
				String[] parts = thisLine.split(";");
				User user = new User(parts[0], parts[1], parts[2]);
				users.add(user);
			}
			}
		 catch (IOException e) {
			e.printStackTrace();
		} 		
			finally {
			// Close resources here! 
			// (all close() calls)
		}
		
		return users;
	}	
	

	public static void main(String[] args) {
		List<User> users = restoreUserData("Users.txt");
		for (User user : users){
			System.out.println(user);
		}
	}

}
