package com.examples.store;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class OldStore {
	
	
	
	public static void printDB(EntityManager em){
		
		List<Department> departments = null;
		List<Product> inventory = null;
		
		
		Query query = em.createNativeQuery(
				"SELECT * FROM JPA_DEPT", Department.class);

		departments = (List<Department>)query.getResultList();

		
		
		query = em.createNativeQuery(
				"SELECT * FROM JPA_PRODUCT", Product.class);

		inventory = (List<Product>)query.getResultList();
		
		
		
		for(Department d : departments)
			System.out.println("\n"+d);
		
		for(Product p : inventory)
			System.out.println("\n"+p);
		
	}
	
	
	
	public static void main(String[] args){

		/* Use Persistence to create EMF for storejpa */
		
		EntityManagerFactory emf = 
			Persistence.createEntityManagerFactory("storejpa");

		/* Use EMF to create EM */
		
		EntityManager em = emf.createEntityManager();

		
		/* Inserting a Department */
		
		Department fruitDept = new Department("Fruit");
		fruitDept.setID(1);
		
	
		
		
		
		/* persist() call takes place inside a transaction */
		
		em.getTransaction().begin();
		
		em.persist(fruitDept);
		
		em.getTransaction().commit();
	
		
		
		
		
		
		Department foodDept = new Department(1, "Food");
		
		Department dep = em.find(Department.class, 1);

		em.getTransaction().begin();
		
		dep.setName(foodDept.getName()); 
		
		em.getTransaction().commit();
		
		
		
		
		
		
		
		
		
		/* Inserting a Product */
		
		
		Product pineappleProduct = new Product();
		
		pineappleProduct.setItemID(1);
		pineappleProduct.setDollarPrice(10);
		pineappleProduct.setItemName("pineapple");
		pineappleProduct.setQuantityInStock(1);
		pineappleProduct.setDept(fruitDept);
//		
//		
//		
		em.getTransaction().begin();
		
		em.persist(pineappleProduct);
		
		em.getTransaction().commit();
		
		
		
		/* Inserting a second Department */
		
		Department jewelryDept = new Department("Jewelry");
		
		
		jewelryDept.setID(2);
	
		em.getTransaction().begin();
		
		em.persist(jewelryDept);
		
		em.getTransaction().commit();

		
		
		/* Shipment of diamond rings */

		
		//Department jewelryDept = em.find(Department.class, 2);
	
		Product ringProduct = new Product();
		
		ringProduct.setItemID(2);
		ringProduct.setDollarPrice(1000);
		ringProduct.setItemName("diamond ring");
		ringProduct.setQuantityInStock(50);
		ringProduct.setDept(jewelryDept);
		
		
		em.getTransaction().begin();
		
		em.persist(ringProduct);
		
		em.getTransaction().commit();
	
//		
//		
//		/* Printing out DB contents with a helper method. */ 
//	 	 
//		
		printDB(em);
//		
//		
//		/* Pineapples double in price */  
//
//		/* To update, open a transaction, and simply 
//		 * make changes to an EM-managed object.		
//		 * 
//		 * Since we called persist() on pineappleProduct
//		 * above, the EM has been "managing" it.
//		 * 
//		 */
//		
		em.getTransaction().begin();
	 
		pineappleProduct.setDollarPrice(
				pineappleProduct.getDollarPrice() * 2);
		
		em.getTransaction().commit();
////		
//		
//		
//		
//		/* The EM has to know exactly what record in the DB 
//		 * an object is mapped to, to make any updates.
//		 * 
//		 * Two ways to obtain a "managed" object:
//		 * 
//		 * - Persist an object. After the persist() call, 
//		 * 		the EM will be managing that object. 
//		 * 		Demonstrated above. 
//		 * 
//		 * - Call find() to retrieve an object from the database.
//		 * 		The retrieved object will be managed.
//		 */
//		
//
//
//		
		/* Sale on diamond rings */
		
		/* This time, instead of using the ringProduct reference
		 * directly, which we know is managed, let's call find() 
		 * to retrieve the managed Product from the DB.
		 */
//		
		Product product = em.find(Product.class, 1);
		
		em.getTransaction().begin();
				
		product.setDollarPrice(200);
		
		em.getTransaction().commit();
		
//		
		
		printDB(em);
		/* All sold out of diamond rings */

		em.getTransaction().begin();

		em.remove(product);

		em.getTransaction().commit();
//		
	

		
		
		
		/* Close EntityManager and EntityManagerFactory when done */
		
	
		
		
		em.close();
		emf.close();
		
		
		
		
	}
	
}

