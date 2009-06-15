package iR.entityManager;
import javax.ejb.Local;

@Local
public interface UserManagerLocal {

	
	void addUser(String name, String mail,String passwd,String type);
	
	void removeUser(int id);
	
	void updateUser(String username, String mail,String passwd,String type);
	
	String encode(String pass);
	
	boolean exist(String username);
	
	void changeStatus(String username,String status);
	
	
	
	
}
