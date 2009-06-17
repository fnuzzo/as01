package iR.stateful;
import iR.entity.User;

import javax.ejb.Local;

@Local
public interface LoginStateLocal {

	
	User getLogged();
	
	void login(String username);
	
	void logout();
	
	
	
	
	
	
	
	
	
}
