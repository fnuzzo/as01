package iR.entityManager;

import java.util.List;

import iR.entity.*;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Session Bean implementation class UserManager
 */
@Stateless
public class UserManager implements UserManagerLocal {

	@PersistenceContext (unitName = "iRubricaEJB")
 	private EntityManager em;
	
    public UserManager() {}

    
    List <User> l;
    
    
    
    
    
	public void addUser(String name, String mail, String passwd, String type) {
		User us = new User();
		
		us.setUserName(name);
		us.setMail(mail);
		us.setPasswd(passwd);
		us.setType(type);
		em.persist(us);
	
	}

	public void changeStatus(String username, String status) {
		// TODO Auto-generated method stub
		
	}

	public String encode(String pass) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean exist(String username) {
		
		if(em.find(User.class, username)!=null)
			return true;
		else 
			return false;
	}

	public void removeUser(String  user) {
		User us = em.find(User.class, user);
		em.remove(us);
	}

	
	
	
	
	
	public void updateUser(String username, String mail, String passwd,
			String type) {
		// TODO Auto-generated method stub
		
	}



	public List <User>  allUser(){
		Query qe = em.createNamedQuery("User.findAll");
		l = qe.getResultList();
		return l;
		}

	public void removeUser(int id) {
		// TODO Auto-generated method stub
		
	}

	public boolean auth(String username, String password) {
		// TODO Auto-generated method stub
		if(exist(username))
		{
			User toAuthenticate = this.findByUsername(username);
			if(password.equals(toAuthenticate.getPasswd())) return true;
			else return false;
		}
		else return false;
	}

	public User findByUsername(String username) {
		// TODO Auto-generated method stub
		User us = em.find(User.class, username);
		return us;
	}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
