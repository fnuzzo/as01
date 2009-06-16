package iR.entityManager;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import iR.entity.*;
import javax.ejb.Remote;

@Remote
public interface ContactManagerRemote {

	
	
	
	void addContact(String name, String surname, 
					String tel_home, String tel_office, 
					String mobile_tel, String address_home, 
					String address_office, String fax, Date insertDate, 
					String note, int idCreatore, String other, String web,
					String city, String state);
	
	
	Collection<Contact> ListAll ();
	
	
	Contact searchUserForName(String name);
	

	
	
	Contact contactFindById(int value);
	
	List contactFindByName(String value);
	
	
	
}
