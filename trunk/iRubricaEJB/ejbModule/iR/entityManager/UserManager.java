package iR.entityManager;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import iR.entity.*;

import javax.ejb.Stateless;
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

public class UserManager implements UserManagerLocal {

	@PersistenceContext (unitName = "iRubricaEJB")
 	private EntityManager em;
	private	MessageDigest md;
	
	
    public UserManager() {}

    List <User> l;
    

	public void addUser(String name, String mail, String passwd, String type) {
		User us = new User();
		
		passwd = codifica(passwd);
		us.setUserName(name);
		us.setMail(mail);
		us.setPasswd(passwd);
		us.setType(type);
		em.persist(us);
	}

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

	public String encode(String pass) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean exist(String username) {
		if(findByUsername(username)!=null)
			return true;
		else 
			return false;
	}

	public void removeUser(String  username) {
		User us = findByUsername(username);
		em.remove(us);
	}
	
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

	@SuppressWarnings("unchecked")
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
	
	//Codifica con una funzione hash one-way la stringa in input
	public String codifica (String origin){
		sun.misc.BASE64Encoder encoder = new sun.misc.BASE64Encoder();
		@SuppressWarnings("unused")
		String encoded;
		byte[] temp=null;
		try {
			if (md==null){
				md = MessageDigest.getInstance("MD5");
			}
			md.reset();
			//md.update(origin.getBytes());
			temp = md.digest(origin.getBytes());
			//	md.reset();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return encoder.encode(temp);
		
	}
    
    
}
