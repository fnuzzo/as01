package iR.entityManager;
import iR.entity.User;

import javax.ejb.Remote;

@Remote
public interface UserManagerRemote {

	void addUser(String username, String mail,String passwd,String type);
	
	void removeUser(int id);
	
	void updateUser(String username, String mail,String passwd,String type);
	
	String encode(String pass);
	
	boolean exist(String username);
	
	void changeStatus(String username,String status);
	
	boolean auth (String username, String password);
	
	User findByUsername(String username);
	
}
