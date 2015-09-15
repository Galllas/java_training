package com.fdmgroup.assignment.serializationtest;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import com.fdmgroup.assignment.serialization.Power;
import com.fdmgroup.assignment.serialization.Shield;
import com.fdmgroup.assignment.serialization.Wizard;
import com.fdmgroup.serialization.game.Backpack;
import com.fdmgroup.serialization.game.Board;
import com.fdmgroup.serialization.game.HealthPack;

public class SerializationTest {

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
			
		Board board = new Board();
		
		Wizard tom = new Wizard();
		Wizard jerry = new Wizard();
		Wizard newJerry = null;
		Wizard newTom = null;
 		
		tom.setName("Tom");
		jerry.setName("Jerry");
		tom.setHealthPoints(100);
		jerry.setHealthPoints(100);
		
		board.attack(tom, jerry);
		board.defend(jerry, tom);
		board.loseHealthPoint(jerry);
		board.loseHealthPoint(jerry);
		board.loseHealthPoint(jerry);
		board.loseHealthPoint(jerry);
		board.loseHealthPoint(jerry);
		
		HealthPack hp1 = new HealthPack(10);
		HealthPack hp2 = new HealthPack(20);
		jerry.getBackpack().addHealthPack(hp1);
		jerry.getBackpack().addHealthPack(hp2);
		tom.getBackpack().addHealthPack(hp2);
		
		Shield recover = new Shield("Recover", 5, 0, 0, 0);
		Power fast = new Power("Speed", 0, 0, 0, 0);
		Power invisible = new Power("Invisible", 0, 0, 0, 0);
		
		jerry.addShield(recover);
		jerry.addPower(fast);
		tom.addPower(invisible);
		
		try
		{
			// Serialize object
			FileOutputStream fs = new FileOutputStream("wizard.txt"); //give file name
			ObjectOutputStream os = new ObjectOutputStream(fs); //make objectoutputstream using your fileoutputstream			
			os.writeObject(jerry);	
			os.writeObject(tom);	
			os.close(); //always close stream when finished
			
			FileInputStream fis = new FileInputStream("wizard.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			newJerry = (Wizard) ois.readObject(); //it returns object, so you must cast it
			newTom = (Wizard) ois.readObject(); //it returns object, so you must cast it
			ois.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
			fail();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail();
		} 
		
		
		assertEquals(tom.getName(), newTom.getName());	
		assertEquals(tom.getHealthPoints(), newTom.getHealthPoints());	
		assertEquals(tom.getPowers().toString(), newTom.getPowers().toString());	
		assertEquals(tom.getShields().toString(), newTom.getShields().toString());	
		assertEquals(20, newTom.getBackpack().useHealthPack().getHealthPoints());

		assertEquals(jerry.getName(), newJerry.getName());	
		assertEquals(jerry.getHealthPoints(), newJerry.getHealthPoints());	
		assertEquals(jerry.getPowers().toString(), newJerry.getPowers().toString());	
		assertEquals(jerry.getShields().toString(), newJerry.getShields().toString());
		assertEquals(10, newJerry.getBackpack().useHealthPack().getHealthPoints());
		assertEquals(20, newJerry.getBackpack().useHealthPack().getHealthPoints());
		
	}
		
}	
		
		

