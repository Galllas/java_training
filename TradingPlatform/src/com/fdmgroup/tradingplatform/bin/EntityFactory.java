package com.fdmgroup.tradingplatform.bin;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityFactory {
	
	private static EntityManagerFactory instance;
	
	private  EntityFactory () {
		
	}
	
	public static EntityManagerFactory getInstance(){
		if(instance == null){
			instance = Persistence.createEntityManagerFactory("storejpa");
		}
		return instance;
	}
	
}
