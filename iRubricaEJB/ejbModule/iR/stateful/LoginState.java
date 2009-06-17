package iR.stateful;

import iR.entity.User;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


/**
 * Session Bean implementation class LoginState
 */
@Stateful
public class LoginState implements LoginStateLocal {

	@PersistenceContext (unitName = "iRubricaEJB")
	private EntityManager em;
	
	private User us;
	
	
    /**
     * Default constructor. 
     */
    public LoginState() {}
    
    

	public User getLogged() {
		return us;
	}

	public void login(String username) {
			
		if (this.us==null){
				Query qe = em.createNamedQuery("User.findByUsername");
				qe.setParameter("username", username );
				try{			
				 this.us = (User) qe.getSingleResult();
			
				}catch(NoResultException nre){					
					this.us = null;// in teoria non serve 	
				}
		}
	}

	
	public void logout() {
		this.us=null;
	}
    
    
    
    
    
}
