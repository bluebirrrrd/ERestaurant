package com.bionic.edu.ERestro;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class App 
{
	private static final String UNIT_NAME = "ER";
  	private static EntityManagerFactory factory;
  	
  	public static void createUsers() {
  		
  		factory = Persistence.createEntityManagerFactory(UNIT_NAME);
		EntityManager em = factory.createEntityManager();
		
  		boolean valid = true;
  		Employee cust1 = new Employee();
  		cust1.setName("Andrew Bowl");
  		cust1.setEmail("and_bowl@gmail.com");
  		cust1.setBirthDate(java.sql.Date.valueOf("1977-10-20"));
  		Rights cook = new Rights();
  		cook.setRole("Cook");
  		cust1.setAccess(cook);
  		cust1.setValid(valid);
  		
  		
  		Employee cust2 = new Employee();
  		cust2.setName("Mary Black");
  		cust2.setEmail("blackmary@live.com");
  		cust2.setBirthDate(java.sql.Date.valueOf("1992-06-17"));
  		Rights administrator = new Rights();
  		administrator.setRole("Administrator");
  		cust2.setAccess(administrator);
  		cust2.setValid(valid);
  		
  		Employee cust3 = new Employee();
  		cust3.setName("Damien Hurst");
  		cust3.setEmail("dh@hurst.com");
  		cust3.setBirthDate(java.sql.Date.valueOf("1956-5-14"));
  		Rights superuser = new Rights();
  		superuser.setRole("Super User");
  		cust3.setAccess(superuser);
  		cust3.setValid(valid);
  		
  		try{
			System.out.println(cust1.getId());
			System.out.println(cust2.getId());
			System.out.println(cust3.getId());
			em.getTransaction().begin();
			em.persist(cust1);
			em.persist(cust2);
			em.persist(cust3);
			em.getTransaction().commit();
			System.out.println(cust1.getId());
			System.out.println(cust2.getId());
			System.out.println(cust3.getId());
		}
		finally{ em.close(); }
  		
  	}
  	
  	
  	public static void main( String[] args)   {
  		createUsers();
    }
}
