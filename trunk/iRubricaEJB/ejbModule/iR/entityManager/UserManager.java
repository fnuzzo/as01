package iR.entityManager;

import java.util.List;

import iR.entity.*;

import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.jboss.ejb3.annotation.Clustered;

/**
 * Session Bean implementation class UserManager
 */

@Stateless
@Clustered
@WebService
public class UserManager implements UserManagerLocal {

	@PersistenceContext (unitName = "iRubricaEJB")
 	private EntityManager em;
	
	
    public UserManager() {}

    List <User> l;
    

    @WebMethod
	public void addUser(String name, String mail, String passwd, String type) {
		User us = new User();
		
		us.setUserName(name);
		us.setMail(mail);
		us.setPasswd(passwd);
		us.setType(type);
		em.persist(us);
	}

    @WebMethod
	public void changeStatus(String username, String type) {
		// TODO Auto-generated method stub
		User us = findByUsername(username);
		us.setType(type);
		em.refresh(us);
		
		Query qe = em.createNamedQuery("User.updateUserType");
		qe.setParameter("username", username );
		qe.setParameter("type", type );
		qe.executeUpdate();
		
	}

	@WebMethod
	public boolean exist(String username) {
		if(findByUsername(username)!=null)
			return true;
		else 
			return false;
	}

	@WebMethod
	public void removeUser(String  username) {
		User us = findByUsername(username);
		em.remove(us);
	}
	
	@WebMethod
	public void updateUser(String username, String mail, String passwd) {
		// TODO Auto-generated method stub
		User us = findByUsername(username);
		us.setMail(mail);
		us.setPasswd(passwd);
		
		Query qe = em.createNamedQuery("User.updateUser");
		qe.setParameter("username", username );
		qe.setParameter("mail",mail);
		qe.setParameter("passwd", passwd );
		qe.executeUpdate();
	
	}

	@WebMethod
	@SuppressWarnings("unchecked")
	public List <User>  allUser(){
		Query qe = em.createNamedQuery("User.findAll");
		l = qe.getResultList();
		return l;
		}

	@WebMethod
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

	@WebMethod
	public User findByUsername(String username) {
		User us;
		Query qe = em.createNamedQuery("User.findByUsername");
		qe.setParameter("username", username );
		try{
			us = (User) qe.getSingleResult();
		}catch(NoResultException nre){
			us = null;
		}
		return us;
	}
    
}
