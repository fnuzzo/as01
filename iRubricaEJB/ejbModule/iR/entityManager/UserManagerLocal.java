package iR.entityManager;
import iR.entity.User;

import java.util.List;

import javax.ejb.Local;

@Local
public interface UserManagerLocal {

	
	void addUser(String name, String mail,String passwd,String type);
	
	void removeUser(String user);
	
	void updateUser(String username, String mail,String passwd);
	
	String encode(String pass);
	
	boolean exist(String username);
	
	void changeStatus(String username,String status);
	
	public List<User> allUser();
	
	boolean auth (String username, String password);
	
	User findByUsername(String username);
	

	
	
}
