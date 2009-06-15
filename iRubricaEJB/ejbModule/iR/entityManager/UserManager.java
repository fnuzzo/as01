package iR.entityManager;

import iR.entity.*;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Session Bean implementation class UserManager
 */
@Stateless
public class UserManager implements UserManagerRemote, UserManagerLocal {

	@PersistenceContext (unitName = "iRubricaEJB")
 	private EntityManager em;
	
    public UserManager() {}

	public void addUser(String name, String mail, String passwd, String type) {
		
		
		
	}

	public void changeStatus(String username, String status) {
		// TODO Auto-generated method stub
		
	}

	public String encode(String pass) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean exist(String username) {
		// TODO Auto-generated method stub
		return false;
	}

	public void removeUser(int id) {
		// TODO Auto-generated method stub
		
	}

	public void updateUser(String username, String mail, String passwd,
			String type) {
		// TODO Auto-generated method stub
		
	}

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
