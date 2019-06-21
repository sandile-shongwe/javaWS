package ejb;

import java.util.List;

import javax.annotation.ManagedBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


import jpa.Client;

/**
 * Session Bean implementation class ClientBean
 */

@Stateless
@ManagedBean	
public class ClientEJB {

    /**
     * Default constructor. 
     */

	
	EntityManager entityManager;
	EntityManagerFactory entityManagerFactory;
	
    public ClientEJB() {
    	
    }
    
    private void closeEM() {
    	this.entityManager.close();
    	this.entityManagerFactory.close();
    }
    
    private void openEM() {
    	  entityManagerFactory = Persistence.createEntityManagerFactory("client");
          entityManager = entityManagerFactory.createEntityManager();
    }
     
    public void updateClient(int id, String name) {
    	openEM();
    	Client client = new Client();
    	client.setId(id);
    	client.setName(name);
		entityManager.merge(client);
		closeEM();
		
	}
	
    public void removeClient(int id) {
    	openEM();
    	Client client  = entityManager.find(Client.class, id);
    	entityManager.remove(client);
    	closeEM();
    
    }
    
    public List<Client> getAll(){
    	openEM();
    	Query q = entityManager.createQuery("select c from Client c");
    	
    	return (List<Client>) q.getResultList();
    
    }
    
    public Client getClient(int id) {
    	openEM();
    	Client client = entityManager.find(Client.class, id);
    	if (client == null) {
    		
    	}
    	closeEM();
    	return client;
    	
    }
    
    public void addClient(int id, String name) {
    	openEM();
    	Client client = new Client();
    	client.setId(id);
    	client.setName(name);
    	
    	entityManager.getTransaction().begin();
    	entityManager.persist(client);
    	entityManager.getTransaction().commit();
    	
    	closeEM();
    	
    	System.out.println("Client added...");
    	
    }
    
    
    


}