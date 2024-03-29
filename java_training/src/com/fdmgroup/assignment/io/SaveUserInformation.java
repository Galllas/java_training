package com.fdmgroup.assignment.io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SaveUserInformation {

	public static void writeUserData(String txt){
		
		List<User> users = new ArrayList<User>();
		
		Scanner input = new Scanner(System.in);

			while ( true )
			{
				String name = null;
				String address = null;
				String email = null;
				
				System.out.print("Input User Data: (Exit by press Enter with User Name)\n");
				System.out.print("User Name\n");
				name = input.nextLine();
				
				if( name.equals("") ) 
					break;
				
				System.out.print("User Address\n");
				address = input.nextLine();		   
				System.out.print("User Email\n");
				email = input.nextLine();
				
				User user = new User(name, address, email);
				users.add(user);
				
			}	
			
			try {

				File file1 = new File(txt);	
				FileWriter fw;
				fw = new FileWriter(file1);
				
				for (User user : users){		
					fw.write( user.getName()+ ";"+ user.getAddress()+";" + user.getEmail()+"\n"); 	
				}
			
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
		
	}	
	

	public static void main(String[] args) {
		writeUserData("Users.txt");

	}

}
