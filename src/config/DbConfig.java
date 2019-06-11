package config;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DbConfig {
	
	private static EntityManagerFactory factory;
	
	private static EntityManager em = Persistence.createEntityManagerFactory("tarefas").createEntityManager();
	
	
	public static EntityManager getEm() {
		return em;
	}

}
